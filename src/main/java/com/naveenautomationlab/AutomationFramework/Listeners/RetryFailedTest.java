package com.naveenautomationlab.AutomationFramework.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class RetryFailedTest extends TestBase implements IRetryAnalyzer{
	int maxCounter =2;
	int cnt =1;

	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying failed test XXXXXX" + result.getMethod().getMethodName() +"for "+ cnt +" times");
		if(cnt<maxCounter) {
			cnt++;
			return true;
		}
		return false;
	}

}
