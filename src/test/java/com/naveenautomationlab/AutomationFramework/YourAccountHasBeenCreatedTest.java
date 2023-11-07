package com.naveenautomationlab.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.naveenautomationlabs.automationframework.base.TestBase;
import pages.RegisterAccount;
import pages.YourAccountHasBeenCreated;
import pages.YourStore;

public class YourAccountHasBeenCreatedTest extends TestBase {

	private YourStore yourStore;

	private RegisterAccount registerAccount;
	private YourAccountHasBeenCreated yourAccountHasBeenCreated;

	@BeforeMethod
	public void setup() {
		insilisation();
	
		yourStore = new YourStore(driver, true).get();

	}

	@Test
	public void validateRegisterAccount() {
		yourStore.clickOnMyAccountBtn();
		registerAccount = yourStore.clickOnRegisterBtn();
		yourAccountHasBeenCreated=	registerAccount.registerPortal();
		
		String yourAccountHasBeenCreatedMessage = yourAccountHasBeenCreated.getYourAccountHasBeenCreatedMessage();

		Assert.assertEquals(yourAccountHasBeenCreatedMessage, "Your Account Has Been Created!");

	}


}
