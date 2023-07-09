package com.naveenautomationlab.AutomationFramework.Utils;


import com.naveenautomationlabs.automationframework.base.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
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
}
