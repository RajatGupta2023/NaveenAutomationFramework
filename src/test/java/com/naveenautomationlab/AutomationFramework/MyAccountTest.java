package com.naveenautomationlab.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationframework.base.TestBase;

import pages.AccountLogin;
import pages.ChangePassword;
import pages.MyAccount;
import pages.MyAccountInformation;
import pages.YourStore;

public class MyAccountTest extends TestBase {

	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;
	private ChangePassword changePassword;
	private MyAccountInformation myAccountInformation;

	@BeforeMethod
	public void setup() {
		insilisation();
		accountLogin = new AccountLogin(driver, false).get();
		yourStore = new YourStore(driver, false);

	}

	private void login() {
		yourStore.clickOnMyAccountBtn();
		accountLogin = yourStore.clickOnLoginBtn();
		accountLogin.loginToPortal();

	}

	@Test
	public void validateLogin() {
		yourStore.clickOnMyAccountBtn();
		accountLogin = yourStore.clickOnLoginBtn();
		accountLogin.loginToPortal();

		// login();
		Assert.assertEquals(driver.getTitle(), "My Account", "You are not on logged in page");

	}

	@Test
	public void validateChangePassword() {

		yourStore.clickOnMyAccountBtn();
		accountLogin = yourStore.clickOnLoginBtn();
		myAccount = accountLogin.loginToPortal();

		changePassword = myAccount.clickOnPasswordBtn();
		changePassword.enterPassword();
		changePassword.enterPasswordConfirm();
		myAccount = changePassword.clickOnContinueBtn();

		Assert.assertEquals(myAccount.getPassswordChangeSeccessfulMessage(), "Password", "Password is not changed");
	}

	@Test
	public void validateUpdatingAccountInformation() {
		yourStore.clickOnMyAccountBtn();
		accountLogin = yourStore.clickOnLoginBtn();
		myAccount = accountLogin.loginToPortal();
		myAccountInformation = myAccount.clickOnEditYourAccountInformationBtn();
		myAccountInformation.editTelephone("1234567896");
		myAccount = myAccountInformation.clickOnContinueBtn();
		Assert.assertEquals(myAccount.getAccountUpdatedMessage(), "Password");
	}

	@AfterMethod
	public void teerDown() {
		tearDown();
	}

}
