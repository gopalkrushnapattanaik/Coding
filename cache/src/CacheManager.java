import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheManager<V> {

    private Map<String,CacheEntry<V>> cache;
    
    private LinkedList<String> accessOrder;
    
    private int maxSize;
    
    private int hits = 0;
    private int misses = 0;
    private int evictions = 0;
    
    // ReadWriteLock for better concurrency: multiple readers, exclusive writers
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public CacheManager() {
        this(100); // Default max size of 100
    }
    
    public CacheManager(int maxSize) {
        this.cache = new HashMap<String,CacheEntry<V>>();
        this.accessOrder = new LinkedList<String>();
        this.maxSize = maxSize;
    }

    public CacheEntry<V> getCacheEntry(String key){
        lock.readLock().lock();
        try {
            // Check if entry exists
            if(!cache.containsKey(key)){
                misses++;
                return null;
            }
            
            CacheEntry<V> entry = cache.get(key);
            
            // Check if entry has expired
            if(entry.isExpired()){
                // Upgrade to write lock for removal
                lock.readLock().unlock();
                lock.writeLock().lock();
                try {
                    removeCacheEntry(key);
                    misses++;
                    return null;
                } finally {
                    lock.writeLock().unlock();
                    lock.readLock().lock();
                }
            }
            
            // Update access order - need write lock for this
            lock.readLock().unlock();
            lock.writeLock().lock();
            try {
                this.updateAccessOrder(key);
                hits++;
                return cache.get(key);
            } finally {
                lock.writeLock().unlock();
                lock.readLock().lock();
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setCacheEntry(String key , V value, long ttl){
        lock.writeLock().lock();
        try {
            // If key already exists, remove it from access order first
            if(cache.containsKey(key)){
                accessOrder.remove(key);
            }
            
            // Check if we need to evict (only if adding new entry)
            if(!cache.containsKey(key) && cache.size() >= maxSize){
                evictLRU();
            }
            
            CacheEntry<V> entry = new CacheEntry<>(value,ttl);
            this.cache.put(key, entry);
            this.accessOrder.addFirst(key);
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    private void evictLRU(){
        if(!accessOrder.isEmpty()){
            String lruKey = accessOrder.removeLast();
            cache.remove(lruKey);
            evictions++;
            System.out.println("[EVICTION] Removed least recently used key: " + lruKey);
        }
    }

    private void updateAccessOrder(String key){
        if(this.accessOrder.contains(key)){
            this.accessOrder.remove(key);
            this.accessOrder.addFirst(key);
        }
    }

    public void removeCacheEntry(String key){
        lock.writeLock().lock();
        try {
            if(cache.containsKey(key)){
                this.accessOrder.remove(key);
                this.cache.remove(key);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void printCacheEntries(){
        lock.readLock().lock();
        try {
            if(cache.isEmpty()){
                System.out.println("Cache is empty.");
                return;
            }
            for(Map.Entry<String, CacheEntry<V>> entry : cache.entrySet()){
                CacheEntry<V> cacheEntry = entry.getValue();
                long ageInSeconds = (System.currentTimeMillis() - cacheEntry.getCreationTime()) / 1000;
                System.out.println("Key: " + entry.getKey() + ", Value: " + cacheEntry.getValue() + 
                                 ", TTL: " + cacheEntry.getTtl() + "s, Age: " + ageInSeconds + "s");
            }
        } finally {
            lock.readLock().unlock();
        }
    }
    
    public void printCacheStats(){
        lock.readLock().lock();
        try {
            System.out.println("\n=== Cache Statistics ===");
            System.out.println("Cache Size: " + cache.size() + " / " + maxSize);
            System.out.println("Cache Hits: " + hits);
            System.out.println("Cache Misses: " + misses);
            System.out.println("Cache Evictions: " + evictions);
            if(hits + misses > 0){
                double hitRate = (double) hits / (hits + misses) * 100;
                System.out.println("Hit Rate: " + String.format("%.2f%%", hitRate));
            }
        } finally {
            lock.readLock().unlock();
        }
    }
    
    public int getCacheSize(){
        lock.readLock().lock();
        try {
            return cache.size();
        } finally {
            lock.readLock().unlock();
        }
    }
    
    public boolean containsKey(String key){
        lock.readLock().lock();
        try {
            return cache.containsKey(key) && !cache.get(key).isExpired();
        } finally {
            lock.readLock().unlock();
        }
    }

}
