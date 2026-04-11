import java.util.*;

public class SlidingWindowLogLimiter  implements RateLimiter {

    private ArrayDeque<Long> requestTimestamps;
    private final long windowSizeInMillis;
    private Map<String, ArrayDeque<Long>> clientRequestMap;


    public SlidingWindowLogLimiter(RateLimiterConfig config) {
         this.windowSizeInMillis = config.getWindowSizeInMillis() > 0 ? config.getWindowSizeInMillis() : 10;
         this.requestTimestamps = new ArrayDeque<>();
         this.clientRequestMap = new HashMap<>();
    }

    @Override
    public boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis();
        requestTimestamps = clientRequestMap.getOrDefault(clientId, new ArrayDeque<>());

        // Remove timestamps that are outside the sliding window
        while (!requestTimestamps.isEmpty() && requestTimestamps.peekFirst() < currentTime - windowSizeInMillis) {
            requestTimestamps.pollFirst();
        }

        // Check if the number of requests in the sliding window exceeds the limit
        if (requestTimestamps.size() < 5) { // Assuming a limit of 5 requests per window
            requestTimestamps.offerLast(currentTime);
            clientRequestMap.put(clientId, requestTimestamps);
            return true;
        } else {
            return false;
        }
    }

}
