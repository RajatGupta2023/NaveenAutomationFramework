package com.naveenautomationlab.AutomationFramework.Utils;


import com.naveenautomationlabs.automationframework.base.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utils extends TestBase {

	public static void takeScreenShot(String testName) {
		// TimeStamp
		String timeStamp = new SimpleDateFormat("dd.mm.YYYY.HH.mm.ss").format(new Date());

		// Take a Screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		//save ScreenShot
		try {
			FileUtils.copyFile(screenshotFile, new File("./FailedScreenShots\\"+"_"+testName+"_"+timeStamp +".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sleep(long millseconds) {
		try {
			Thread.sleep(millseconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static String generateRandomString(int chCnt) {
		return RandomStringUtils.randomAlphabetic(chCnt);
	}

	public static String generateRandomAlphaNumeric(int chCnt) {
		return RandomStringUtils.randomAlphanumeric(chCnt);
	}

	public static String generateRandomNumber(int cnt) {
		return RandomStringUtils.randomNumeric(cnt);
	}

	public static String getCurrentDateTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	}
}
