
public class RateLimiterConfig {
    private long maxTokens;
    private long refillRate;
    private long windowSizeInMillis;
    private long fixedWindowSize;


    // Getters and setters
    public long getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(long maxTokens) {
        this.maxTokens = maxTokens;
    }

    public long getRefillRate() {
        return refillRate;
    }

    public void setRefillRate(long refillRate) {
        this.refillRate = refillRate;
    }

    public long getWindowSizeInMillis() {
        return windowSizeInMillis;
    }

    public void setWindowSizeInMillis(long windowSizeInMillis) {
        this.windowSizeInMillis = windowSizeInMillis;
    }

    public long getFixedWindowSize() {
        return fixedWindowSize;
    }

    public void setFixedWindowSize(long fixedWindowSize) {
        this.fixedWindowSize = fixedWindowSize;
    }
}
