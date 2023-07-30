package com.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utilites.DriverUtils;

public class MyListener extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "testcase pass Successfully");
		
	}

	public void onTestFailure(ITestResult result){
	
			try {
				test.log(Status.FAIL, "Test case Failed");
				String path=DriverUtils.captureScreenshot(result.getName());
				test.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "testcase Skiped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {//before suit
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
