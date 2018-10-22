package com.cleartrip.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.cleartrip.testBase.TestBase;


public class TestNGListener extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Driver in onTestSuccess : "+driver);
		String methodName = result.getName().toString().trim();
		System.out.println("methodName:::" + methodName);
		try {
			takeScreenShot(methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//tearDown();
		System.out.println("methodName:::" + methodName);
	}

	public void onTestFailure(ITestResult result) {
		String methodName =result.getName().toString().trim();
		System.out.println("methodName:::" + methodName);
		try {
			takeScreenShot(methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//tearDown();
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		tearDown();
	}

}
