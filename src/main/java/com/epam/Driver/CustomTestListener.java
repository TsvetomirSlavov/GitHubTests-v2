package com.epam.Driver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.reportportal.message.ReportPortalMessage;


public class CustomTestListener implements ITestListener {

	public static Logger logger = Logger.getLogger(CustomTestListener.class);
	public String rp_message = "test message for Report Portal";
	private static String DEFAULT_TIMESTAMP_PATTERN = "yyyy-MM-dd_HH-mm-ss";
	private String timeStamp = FastDateFormat.getInstance(DEFAULT_TIMESTAMP_PATTERN).format(System.currentTimeMillis());

	public void onTestStart(ITestResult result) {

		System.out.println("Test is started: " + testName(result) + " at " + timeStamp);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed: " + testName(result) + " at " + timeStamp);

		File scrFile = ((TakesScreenshot) WebDriverSingleton.getWebDriverInstance()).getScreenshotAs(OutputType.FILE);
		File destFile = new File("test-output/screenshots/" + testName(result) + " " + timeStamp + ".png");

		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ReportPortalMessage message = new ReportPortalMessage(destFile, rp_message);
		logger.info(message);

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Result is failed: " + testName(result) + " at " + timeStamp);

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped: " + testName(result) + " at " + timeStamp);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	private String testName(ITestResult result) {
		return result.getInstance().getClass().getSimpleName() + "." + result.getMethod().getMethodName();
	}

}
