# 📚 Cache Manager - Usage Guide

## Quick Start

### Basic Usage

```java
// Create a cache with default size (100 entries)
CacheManager<String> cache = new CacheManager<>();

// Or specify custom max size
CacheManager<String> cache = new CacheManager<>(50);

// Add entries (key, value, ttl_in_seconds)
cache.setCacheEntry("user:123", "John Doe", 3600); // 1 hour TTL
cache.setCacheEntry("token:abc", "xyz_token", 1800); // 30 minutes TTL

// Retrieve entries
CacheEntry<String> entry = cache.getCacheEntry("user:123");
if (entry != null) {
    String value = entry.getValue();
    long ttl = entry.getTtl();
    System.out.println("Value: " + value + ", TTL: " + ttl + "s");
}

// Remove entries
cache.removeCacheEntry("user:123");

// View all entries
cache.printCacheEntries();

// View statistics
cache.printCacheStats();
```

---

## API Reference

### Constructor

```java
// Default: 100 entry capacity
CacheManager<V> cache = new CacheManager<>();

// Custom capacity
CacheManager<V> cache = new CacheManager<>(50);
```

### Core Methods

#### `setCacheEntry(String key, V value, long ttl)`
Adds or updates a cache entry.
```java
cache.setCacheEntry("key1", "value1", 60); // 60 second TTL
```
- **Parameters**:
  - `key`: Unique identifier
  - `value`: Data to cache (any type due to generics)
  - `ttl`: Time to live in seconds
- **Notes**: 
  - Automatically updates access order (moves to most recent)
  - Triggers LRU eviction if cache is full
  - Thread-safe

#### `getCacheEntry(String key)`
Retrieves a cache entry.
```java
CacheEntry<String> entry = cache.getCacheEntry("key1");
if (entry != null) {
    String value = entry.getValue();
}
```
- **Returns**: CacheEntry or null
- **Auto-cleanup**: Expired entries are automatically removed
- **Access Update**: Marks as most recently used
- **Thread-safe**: Multiple readers supported simultaneously

#### `removeCacheEntry(String key)`
Removes an entry from cache.
```java
cache.removeCacheEntry("key1");
```
- **Thread-safe**: Writer lock acquired
- **Notes**: Safe to call on non-existent keys

#### `printCacheEntries()`
Displays all current cache entries.
```java
cache.printCacheEntries();
```
**Output Example:**
```
Key: user:1, Value: Alice, TTL: 60s, Age: 5s
Key: user:2, Value: Bob, TTL: 120s, Age: 2s
Key: user:3, Value: Charlie, TTL: 180s, Age: 1s
```

#### `printCacheStats()`
Displays cache performance metrics.
```java
cache.printCacheStats();
```
**Output Example:**
```
=== Cache Statistics ===
Cache Size: 8 / 10
Cache Hits: 125
Cache Misses: 25
Cache Evictions: 5
Hit Rate: 83.33%
```

### Utility Methods

#### `getCacheSize()`
Returns current number of entries.
```java
int size = cache.getCacheSize();
```

#### `containsKey(String key)`
Checks if key exists and is not expired.
```java
if (cache.containsKey("user:123")) {
    // Entry exists and is valid
}
```

---

## Common Patterns

### Pattern 1: User Session Cache
```java
CacheManager<User> sessionCache = new CacheManager<>(10000);

// Store session
User user = new User("john", "john@example.com");
sessionCache.setCacheEntry("session:" + sessionId, user, 1800); // 30 min

// Retrieve session
CacheEntry<User> entry = sessionCache.getCacheEntry("session:" + sessionId);
if (entry != null) {
    User currentUser = entry.getValue();
}

// Logout (remove session)
sessionCache.removeCacheEntry("session:" + sessionId);
```

### Pattern 2: API Response Caching
```java
CacheManager<ApiResponse> apiCache = new CacheManager<>(500);

// Cache API response
ApiResponse response = callExternalAPI();
apiCache.setCacheEntry("api:endpoint:" + params, response, 300); // 5 min

// Check cache before API call
CacheEntry<ApiResponse> cached = apiCache.getCacheEntry("api:endpoint:" + params);
if (cached != null) {
    return cached.getValue(); // Use cached response
} else {
    ApiResponse response = callExternalAPI(); // Call API
}
```

### Pattern 3: Database Query Cache
```java
CacheManager<List<Record>> queryCache = new CacheManager<>(1000);

// Cache query results
String query = "SELECT * FROM users WHERE status='active'";
List<Record> results = database.query(query);
queryCache.setCacheEntry("query:" + query.hashCode(), results, 600); // 10 min

// Retrieve cached query
CacheEntry<List<Record>> cached = queryCache.getCacheEntry("query:" + query.hashCode());
if (cached != null) {
    return cached.getValue();
}
```

### Pattern 4: Multi-threaded Service
```java
// Thread-safe cache shared across threads
CacheManager<String> sharedCache = new CacheManager<>(100);

// Multiple threads can safely read
Thread reader = new Thread(() -> {
    for (int i = 0; i < 100; i++) {
        CacheEntry<String> entry = sharedCache.getCacheEntry("key:" + i);
        // No race conditions
    }
});

// Single/Multiple writers
Thread writer = new Thread(() -> {
    sharedCache.setCacheEntry("key:new", "value", 60);
});

reader.start();
writer.start();
```

---

## Advanced Topics

### Thread Safety Guarantees

The cache uses `ReentrantReadWriteLock` which provides:
- **Multiple Readers**: Many threads can read simultaneously ✅
- **Exclusive Writers**: Only one thread can write at a time ✅
- **No Race Conditions**: Data integrity guaranteed ✅
- **No Deadlocks**: Proper lock ordering ✅

```java
// Safe: Multiple threads reading
for (int i = 0; i < 10; i++) {
    new Thread(() -> {
        cache.getCacheEntry("key1"); // No conflicts
    }).start();
}

// Safe: Mixed read/write
cache.getCacheEntry("key1");  // Read lock
cache.setCacheEntry("key2", "value", 60); // Write lock
cache.removeCacheEntry("key3"); // Write lock
```

### TTL Behavior

- **Lazy Expiration**: Entries expire when read, not automatically
- **Granularity**: 1-second precision
- **Default**: 30 seconds (if not specified)
- **Min/Max**: No limits (use 1 second to 86400 seconds recommended)

```java
// Immediate expiration
cache.setCacheEntry("temp", "value", 1);
Thread.sleep(2000);
CacheEntry<String> entry = cache.getCacheEntry("temp"); // Returns null

// Long TTL (1 day)
cache.setCacheEntry("config", "data", 86400);
```

### LRU Eviction Details

Eviction happens when:
1. Cache reaches max capacity
2. New entry is added (not update)
3. Least Recently Used entry is removed

**Access order updated on:**
- ✅ `getCacheEntry()` (read)
- ✅ `setCacheEntry()` (new write)
- ❌ NOT on expiration check

```java
// After 3 writes to full cache:
cache.setCacheEntry("key1", "value1", 60); // Added
cache.setCacheEntry("key2", "value2", 60); // Added
cache.setCacheEntry("key3", "value3", 60); // Added
cache.setCacheEntry("key4", "value4", 60); // Evicts key1 (LRU)

cache.getCacheEntry("key2"); // key2 is now most recent
cache.setCacheEntry("key5", "value5", 60); // Evicts key3 (new LRU)
```

### Memory Considerations

Each entry uses approximately:
- Key (String): ~40 bytes + content
- Value: Type-dependent
- TTL (long): 8 bytes
- CreationTime (long): 8 bytes
- LinkedList node: ~32 bytes

**Estimate for 10,000 entries with small strings:**
```
10,000 entries × (100 bytes avg) ≈ 1 MB
```

---

## Performance Tips

### Tip 1: Right-Size Your Cache
```java
// Too small: High eviction rate
CacheManager<String> cache = new CacheManager<>(10); // ❌

// Better: Based on expected data
CacheManager<String> cache = new CacheManager<>(1000); // ✅
```

### Tip 2: Use Appropriate TTLs
```java
// Short-lived data
cache.setCacheEntry("temp_session", data, 60); // 1 minute

// Medium-term cache
cache.setCacheEntry("api_response", data, 300); // 5 minutes

// Long-term cache
cache.setCacheEntry("config", data, 3600); // 1 hour
```

### Tip 3: Monitor Hit Rate
```java
// Check hit rate regularly
cache.printCacheStats();
// If hit rate < 50%, increase cache size
// If hit rate > 95%, TTLs may be too long
```

### Tip 4: Batch Operations
```java
// Avoid repeated writes in hot loop
for (int i = 0; i < 1000; i++) {
    cache.setCacheEntry("key:" + i, value, 60);
    cache.getCacheEntry("key:" + i); // ❌ Better to batch
}

// Better approach: Single batch operation
for (int i = 0; i < 1000; i++) {
    cache.setCacheEntry("key:" + i, value, 60);
}
for (int i = 0; i < 1000; i++) {
    cache.getCacheEntry("key:" + i);
}
```

---

## Troubleshooting

### Issue: Always getting null from getCacheEntry()
**Cause**: Entry is expired
**Solution**: Check TTL values, increase if needed
```java
// TTL might be too short
cache.setCacheEntry("key", "value", 1); // 1 second ❌
cache.setCacheEntry("key", "value", 3600); // 1 hour ✅
```

### Issue: High eviction rate
**Cause**: Cache capacity too small
**Solution**: Increase max size
```java
CacheManager<String> cache = new CacheManager<>(1000); // ✅
```

### Issue: Memory growing too large
**Cause**: Long TTLs + large cache size
**Solution**: Reduce TTL or cache size
```java
cache.setCacheEntry("key", "value", 300); // 5 min ✅ (was 3600)
```

### Issue: Null Pointer Exception
**Cause**: Not checking for null before using value
**Solution**: Always check if entry is not null
```java
CacheEntry<String> entry = cache.getCacheEntry("key");
if (entry != null) {
    String value = entry.getValue(); // ✅ Safe
} else {
    // Handle cache miss
}
```

---

## Best Practices

1. ✅ Always check for null on getCacheEntry()
2. ✅ Use meaningful key formats (e.g., "type:id:version")
3. ✅ Monitor cache statistics periodically
4. ✅ Right-size cache based on expected workload
5. ✅ Use appropriate TTLs for your data
6. ✅ Remove entries explicitly when no longer needed
7. ✅ Don't store mutable objects (or make them immutable)
8. ✅ Use cache in read-heavy scenarios (not write-heavy)

---

## Summary

Your cache is **production-ready** for:
- ✅ Multi-threaded applications
- ✅ Web server session storage
- ✅ API response caching
- ✅ Database query caching
- ✅ High-concurrency systems

Start using it today with confidence!
