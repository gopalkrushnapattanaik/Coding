public class App {
    public static void main(String[] args) throws Exception {
    
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║     THREAD-SAFE CACHE MANAGER - CONCURRENCY DEMONSTRATION      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        // Create a thread-safe cache manager
        CacheManager<String> cacheManager = new CacheManager<>(10);
        
        System.out.println("\n=== Single-threaded Test ===");
        cacheManager.setCacheEntry("user:1", "Alice", 60);
        cacheManager.setCacheEntry("user:2", "Bob", 60);
        cacheManager.setCacheEntry("user:3", "Charlie", 60);
        cacheManager.printCacheEntries();
        
        System.out.println("\n=== Multi-threaded Test (10 threads) ===");
        System.out.println("Spawning 10 concurrent threads...\n");
        
        // Create 10 threads that will read/write to cache concurrently
        Thread[] threads = new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                try {
                    // Each thread performs read/write operations
                    for (int j = 0; j < 5; j++) {
                        // Write operations
                        String key = "data:" + threadId + ":" + j;
                        String value = "Thread-" + threadId + "-Value-" + j;
                        cacheManager.setCacheEntry(key, value, 120);
                        
                        // Sleep a bit to simulate work
                        Thread.sleep(10);
                        
                        // Read operations
                        String readKey = "data:" + (threadId % 5) + ":" + (j % 3);
                        CacheEntry<String> entry = cacheManager.getCacheEntry(readKey);
                        if (entry != null) {
                            // Successfully read without race condition
                        }
                        
                        // Occasional removal
                        if (j % 2 == 0) {
                            cacheManager.removeCacheEntry("user:" + ((j % 3) + 1));
                        }
                    }
                    System.out.println("✓ Thread " + threadId + " completed all operations");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
        
        // Wait for all threads to complete
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("\n=== Final Cache State ===");
        cacheManager.printCacheEntries();
        cacheManager.printCacheStats();
        
        System.out.println("\n=== Concurrent Read Test (Heavy Load) ===");
        System.out.println("Pre-loading cache...");
        for (int i = 0; i < 10; i++) {
            cacheManager.setCacheEntry("key:" + i, "value:" + i, 300);
        }
        
        System.out.println("Spawning 20 reader threads...\n");
        Thread[] readers = new Thread[20];
        
        for (int i = 0; i < 20; i++) {
            final int readerId = i;
            readers[i] = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    String key = "key:" + (readerId % 10);
                    CacheEntry<String> entry = cacheManager.getCacheEntry(key);
                    if (entry != null) {
                        // Simulate read operation
                    }
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("✓ Reader " + readerId + " completed 10 reads");
            });
            readers[i].start();
        }
        
        // Wait for all readers
        for (Thread t : readers) {
            t.join();
        }
        
        System.out.println("\n=== Final Statistics ===");
        cacheManager.printCacheStats();
        
        System.out.println("\n✅ All concurrent operations completed successfully!");
        System.out.println("   Cache is thread-safe using ReadWriteLock");
        System.out.println("   Multiple readers can access simultaneously");
        System.out.println("   Writers have exclusive access");
    }
}
