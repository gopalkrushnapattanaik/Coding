import java.util.*;

public class FixedWIndowLimter implements RateLimiter {

    private Map<String, Integer> requestCounts;
    private long fixedWindowSize;
    private Map<String, Long> windowStartTimes;

    public FixedWIndowLimter(RateLimiterConfig config) {
        this.fixedWindowSize = config.getFixedWindowSize();
        this.requestCounts = new HashMap<>();
        this.windowStartTimes = new HashMap<>();
    }

    @Override
    public boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis();
        long windowStartTime = windowStartTimes.getOrDefault(clientId, 0L);

        if (currentTime - windowStartTime >= fixedWindowSize) {
            // Reset the count and start time for the new window
            requestCounts.put(clientId, 1);
            windowStartTimes.put(clientId, currentTime);
            return true;
        } else {
            int count = requestCounts.getOrDefault(clientId, 0);
            if (count < 5) { // Assuming a limit of 5 requests per window
                requestCounts.put(clientId, count + 1);
                return true;
            } else {
                return false;
            }
        }
    }
}

