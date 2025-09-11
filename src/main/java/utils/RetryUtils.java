package utils;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

public class RetryUtils {

	private static final Logger logger = Logger.getLogger(RetryUtils.class.getName());

    // Generic retry method
    public static <T> T runWithRetry(Callable<T> action, int retries, long waitMs) throws Exception {
        for (int i = 0; i <= retries; i++) {
            try {
                return action.call(); // ✅ run the action
            } catch (Exception e) {
                if (i == retries) {
                    throw e; // ❌ throw after last attempt
                }
                logger.warning("Retry attempt " + (i + 2) + " after failure: " + e.getMessage());
                Thread.sleep(waitMs); // ⏳ wait before retry
            }
        }
        return null;
    }

    // Overload for void methods
    public static void runWithRetry(Runnable action, int retries, long waitMs) throws Exception {
        runWithRetry(() -> {
            action.run();
            return null;
        }, retries, waitMs);
    }
}
