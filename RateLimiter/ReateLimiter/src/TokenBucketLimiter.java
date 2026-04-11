import java.util.HashMap;
import java.util.Map;

public class TokenBucketLimiter implements RateLimiter{

    private long maxTokens;
    private long currentTokens;
    private long lastRefillTimestamp;
    private long refillRate; //perscond 5 requests 
    private Map<String,Long> bucketMap;

    public TokenBucketLimiter(RateLimiterConfig config) {
        // Initialize token bucket parameters
        this.maxTokens = config.getMaxTokens();
        this.lastRefillTimestamp = System.currentTimeMillis();
        this.refillRate = config.getRefillRate();
        this.currentTokens = refillRate;
        this.bucketMap = new HashMap<>();
    }
    
    @Override
    public boolean allowRequest(String clientId) {
        // Implement token bucket algorithm
        refillTokens(clientId);
        long tokens = bucketMap.getOrDefault(clientId, currentTokens);
        if (tokens > 0) {
            bucketMap.put(clientId, tokens - 1);
            return true;
        }
        return false;
    }
    

    private void refillTokens(String clientId) {
        long now = System.currentTimeMillis();
        long timeGap = now - lastRefillTimestamp;
        currentTokens = Math.min(maxTokens, currentTokens + timeGap * refillRate / 1000);
        lastRefillTimestamp = now;
        bucketMap.put(clientId, currentTokens);
    }

}