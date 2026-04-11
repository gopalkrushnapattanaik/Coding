public class RateLimitFactory {
   
    public static RateLimiterConfig config ;// Example configuration

    public static RateLimiter getRateLimiter(RateLimiterType type,RateLimiterConfig config) {
        switch (type) {
            case TOKENTBUCKET:
                return new TokenBucketLimiter(config);
            case SLIDINGWINDOWLOG:
                return new SlidingWindowLogLimiter(config);
            case FIXEDWINDOWCOUNTER:
            default:
                return new FixedWIndowLimter(config);
        }

    }

    public static void setConfig(RateLimiterConfig config) {
        RateLimitFactory.config = config;
    }

     public static RateLimiterConfig getConfig() {
        return config;
    }
}
