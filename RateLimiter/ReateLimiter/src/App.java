public class App {
    public static void main(String[] args) throws Exception {
       //RateLimiter Tester
         RateLimiterConfig config = new RateLimiterConfig();
            config.setMaxTokens(10);        
            config.setRefillRate(1); // 1 token per second
            config.setWindowSizeInMillis(1000); // 1 second window for fixed window counter
            config.setFixedWindowSize(1000); // 1 second window for fixed window counter

            RateLimiter rateLimiter = RateLimitFactory.getRateLimiter(RateLimiterType.FIXEDWINDOWCOUNTER, config);
            // Simulate requests
            for (int i = 0; i < 10; i++) {
                boolean allowed = rateLimiter.allowRequest("client-1");
                System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Denied"));
                Thread.sleep(100); // Sleep for 100ms between requests
            }
            System.out.println("Testing completed.");   

            // You can add more tests here for other rate limiter types
            RateLimiterConfig slidingWindowConfig = new RateLimiterConfig();
            slidingWindowConfig.setMaxTokens(10);
            slidingWindowConfig.setRefillRate(1);
            slidingWindowConfig.setWindowSizeInMillis(1000);
            slidingWindowConfig.setFixedWindowSize(1000);

            RateLimiter slidingWindowRateLimiter = RateLimitFactory.getRateLimiter(RateLimiterType.SLIDINGWINDOWLOG, slidingWindowConfig);
            // Simulate requests
            for (int i = 0; i < 10; i++) {
                boolean allowed = slidingWindowRateLimiter.allowRequest("client-1");
                System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Denied"));
                Thread.sleep(100);
            }
            System.out.println("Testing completed.");

             RateLimiterConfig tokenBucketConfig = new RateLimiterConfig();
            tokenBucketConfig.setMaxTokens(10);
            tokenBucketConfig.setRefillRate(1);                 
            RateLimiter tokenBucketRateLimiter = RateLimitFactory.getRateLimiter(RateLimiterType.TOKENTBUCKET, tokenBucketConfig);
            // Simulate requests
            for (int i = 0; i < 10; i++) {
                boolean allowed = tokenBucketRateLimiter.allowRequest("client-1");
                System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Denied"));
                Thread.sleep(100);
            }
            System.out.println("Testing completed.");
    }
}
