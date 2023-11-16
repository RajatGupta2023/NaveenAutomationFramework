package com.naveenautomationlab.AutomationFramework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationframework.base.TestBase;

import pages.AccountLogin;
import pages.AddressBook;
import pages.EditAddressBook;
import pages.MyAccount;
import pages.YourStore;

public class AddressBookTest extends TestBase {

	private YourStore yourStore;

	private AccountLogin accountLogin;
	private MyAccount myAccount;
	private AddressBook addressBook;

	private EditAddressBook editAddressBook;

	@BeforeMethod
	public void setup() {
		insilisation();

		yourStore = new YourStore(driver, true).get();

	}

	@Test
	public void updatingAddress() {
		yourStore.clickOnMyAccountBtn();
		accountLogin = yourStore.clickOnLoginBtn();
		myAccount = accountLogin.loginToPortal();
		addressBook = myAccount.clickOnModifyYourAddressBookEntriesBtn();
		editAddressBook = addressBook.clickOnEditBtn();
		editAddressBook.enterPostalCode();

		addressBook = editAddressBook.clickonContinueBtn();
		Assert.assertEquals("Your address has been successfully updated",
				addressBook.getAddressSuccessfullyEditMessage());

	}
	
	@AfterMethod
	public void teerDown() {
		tearDown();
	}

}
