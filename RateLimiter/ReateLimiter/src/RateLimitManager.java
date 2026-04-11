public class RateLimitManager {

    private RateLimiter rateLimiter;

    public RateLimitManager(RateLimiterType type, RateLimiterConfig config) {
        RateLimitFactory.setConfig(config!=null? config:getDefaultConfig());
        this.rateLimiter = RateLimitFactory.getRateLimiter(type,config);
    }

    private RateLimiterConfig getDefaultConfig() {
        RateLimiterConfig config = new RateLimiterConfig();
        config.setMaxTokens(10);
        config.setRefillRate(1);
        config.setWindowSizeInMillis(1000);
        return config;
    }

    public boolean allowRequest(String clientId) {
        return rateLimiter.allowRequest(clientId);
    }

}
