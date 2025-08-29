package utils;

import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;

public class RetryAnalyzer implements IRetryAnalyzer{
	 private int retryCount = 0;
	    private static final int maxRetryCount = 1; // Retry failed test 1 time

	    @Override
	    public boolean retry(ITestResult result) {
	        if (retryCount < maxRetryCount) {
	            retryCount++;
	            System.out.println("Retrying test " + result.getName() + 
	                               " again | Attempt " + (retryCount + 1));
	            return true;
	        }
	        return false;
	    }

}
