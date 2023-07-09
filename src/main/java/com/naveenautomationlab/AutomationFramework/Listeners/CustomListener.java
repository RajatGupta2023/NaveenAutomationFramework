package com.naveenautomationlab.AutomationFramework.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomationlab.AutomationFramework.Utils.Utils;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class CustomListener extends TestBase implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test"+ result.getMethod().getMethodName() + "started*****************************" );
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test"+ result.getMethod().getMethodName() + "passed@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test"+ result.getMethod().getMethodName() + "failed XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" );
		Utils.takeScreenShot(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test"+ result.getMethod().getMethodName() + "skipped ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
