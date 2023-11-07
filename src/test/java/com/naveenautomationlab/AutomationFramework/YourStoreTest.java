package com.naveenautomationlab.AutomationFramework;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationframework.base.TestBase;

import pages.YourStore;

public class YourStoreTest extends TestBase {

	private YourStore yourStore;
	

	@BeforeMethod
	public void setup() {
		insilisation();
		yourStore = new YourStore(driver, true).get();
		

	}

	@Test
	public void validateImageSlideShow() {
		// wait.until(ExpectedConditions.visibilityOf(yourStore.getImageWebElement()));
		int imageIntialPosition = yourStore.getFirstImageWebElement().getLocation().getX();

		int imageFinalPosition = yourStore.getSecondImageWebElement().getLocation().getX();

		Assert.assertNotEquals(imageIntialPosition, imageFinalPosition);

	}

	@AfterMethod
	public void teerDown() {
		tearDown();
	}

}
