package com.naveenautomationlab.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationframework.base.TestBase;

import pages.RegisterAccount;

import pages.YourStore;

public class RegisterAccountTest extends TestBase{
	
	private YourStore yourStore;

	private RegisterAccount registerAccount;
	

	@BeforeMethod
	public void setup() {
		insilisation();
	
		yourStore = new YourStore(driver, true).get();

	}
	
	@Test
	public void validateWarningMessageIfTryingToRegisterWithRegistedEmail() {
		yourStore.clickOnMyAccountBtn();
		registerAccount = yourStore.clickOnRegisterBtn();
		registerAccount = registerAccount.registerPortalWithAlreadyRegistedEmail();
		
		Assert.assertEquals(registerAccount.getEmailAlradyRegisterEmailWarning(), "Warning: E-Mail Address is already registered!");
		
	}
	
	@Test
	public void validateWarningMessageIfTryingToRegisterWithoutEmail() {
		yourStore.clickOnMyAccountBtn();
		registerAccount = yourStore.clickOnRegisterBtn();
		registerAccount = registerAccount.registerPortalWithoutEmail();
		
		Assert.assertEquals(registerAccount.getWarningMessageEmailAddressDoesNotAppear(), "E-Mail Address does not appear to be valid!");
		
	}

}
