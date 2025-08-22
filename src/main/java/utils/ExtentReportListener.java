package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener {
	
	 private static ExtentReports extent;
	    private static ExtentTest test;

	    public void onStart(ITestContext context) {
	        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	        // Timestamped report
	        String reportName = "ExtentReport_" + timestamp + ".html";
	        String reportPath = System.getProperty("user.dir") + "/test-output/" + reportName;

	        // Fixed report name for Jenkins
	        String fixedReportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

	        ExtentSparkReporter sparkTimestamped = new ExtentSparkReporter(reportPath);
	        ExtentSparkReporter sparkFixed = new ExtentSparkReporter(fixedReportPath);

	        extent = new ExtentReports();
	        extent.attachReporter(sparkTimestamped, sparkFixed);

	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User", System.getProperty("user.name"));
	    }

	    public void onTestStart(ITestResult result) {
	        test = extent.createTest(result.getMethod().getMethodName());
	    }

	    public void onTestSuccess(ITestResult result) {
	        test.pass("Test passed");
	    }

	    public void onTestFailure(ITestResult result) {
	        test.fail(result.getThrowable());
	    }

	    public void onTestSkipped(ITestResult result) {
	        test.skip(result.getThrowable());
	    }

	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
}
