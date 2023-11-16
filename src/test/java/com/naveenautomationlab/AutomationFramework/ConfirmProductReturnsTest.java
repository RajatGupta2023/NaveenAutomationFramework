package com.naveenautomationlab.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlab.AutomationFramework.Utils.Utils;
import com.naveenautomationlabs.automationframework.base.TestBase;

import pages.AccountLogin;
import pages.ConfirmProductReturns;
import pages.MyAccount;
import pages.ProductReturns;
import pages.YourStore;

public class ConfirmProductReturnsTest extends TestBase {

	private YourStore yourStore;
	private AccountLogin accountLogin;
	private MyAccount myAccount;
	private ProductReturns productReturns;
	private ConfirmProductReturns confirmProductReturns;

	@BeforeMethod
	public void setup() {
		insilisation();

		yourStore = new YourStore(driver, true).get();

	}

	@Test
	public void validateProductReturn() {
		yourStore.clickOnMyAccountBtn();
		accountLogin = yourStore.clickOnLoginBtn();
		myAccount = accountLogin.loginToPortal();
		productReturns = myAccount.clickOnReturnsBtn();
		confirmProductReturns = productReturns.returnProductPortal();
		
		Assert.assertEquals(confirmProductReturns.getProductReturnMessage(), "Product Returns");

		Utils.sleep(10000);

	}

	@AfterMethod
	public void teerDown() {
		tearDown();
	}

}
