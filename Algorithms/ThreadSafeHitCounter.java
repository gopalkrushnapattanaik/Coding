import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;

public class ThreadSafeHitCounter {
    private final int WINDOW_SIZE = 300;
    private final AtomicLongArray times;
    private final AtomicIntegerArray counts;

    public ThreadSafeHitCounter() {
        this.times = new AtomicLongArray(WINDOW_SIZE);
        this.counts = new AtomicIntegerArray(WINDOW_SIZE);
    }

    /** Records a hit at the given timestamp. */
    public void hit(long timestamp) {
        int index = (int) (timestamp % WINDOW_SIZE);

        // Check if the current bucket's timestamp matches the incoming one
        if (times.get(index) != timestamp) {
            // Use compareAndSet to ensure only one thread resets the bucket for a new window cycle
            if (times.compareAndSet(index, times.get(index), timestamp)) {
                counts.set(index, 1);
            } else {
                // If reset failed, another thread already updated it; increment the new count
                counts.incrementAndGet(index);
            }
        } else {
            // Already at the correct second, just increment
            counts.incrementAndGet(index);
        }
    }

    /** Returns total hits within the last 300 seconds of the given timestamp. */
    public int getHits(long timestamp) {
        int totalHits = 0;
        for (int i = 0; i < WINDOW_SIZE; i++) {
            // Only sum buckets that fall within the last 300 seconds
            if (timestamp - times.get(i) < WINDOW_SIZE) {
                totalHits += counts.get(i);
            }
        }
        return totalHits;
    }
}