package com.naveenautomationlab.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationframework.base.TestBase;

import pages.AccountLogin;
import pages.ChangePassword;
import pages.MyAccount;
import pages.YourStore;

public class MyAccountTest extends TestBase {

	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;
	private ChangePassword changePassword;

	@BeforeMethod
	public void setup() {
		insilisation();
		yourStore = new YourStore();

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
	public void test1() {
		Assert.assertEquals(false, false);
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, false);
	}

	@Test
	public void validateChangePassword() {

		yourStore.clickOnMyAccountBtn();
		accountLogin = yourStore.clickOnLoginBtn();
		accountLogin.loginToPortal();

		// login();

		myAccount = new MyAccount();

		changePassword = myAccount.clickOnPasswordBtn();
		changePassword.enterPassword();
		changePassword.enterPasswordConfirm();
		myAccount = changePassword.clickOnContinueBtn();

		Assert.assertEquals(myAccount.getPassswordChangeSeccessfulMessage(), "Password", "Password is not changed");
	}

	@AfterMethod
	public void teerDown() {
		tearDown();
	}

}
