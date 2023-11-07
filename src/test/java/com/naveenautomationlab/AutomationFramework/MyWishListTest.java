package com.naveenautomationlab.AutomationFramework;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationframework.base.TestBase;

import pages.AccountLogin;
import pages.MyAccount;
import pages.MyWishList;
import pages.MyWishList.MyWishListTable;
import pages.YourStore;

public class MyWishListTest extends TestBase {

	YourStore yourStore;
	AccountLogin accountLogin;

	MyWishList myWishlist;

	@BeforeMethod
	public void setUp() {
		insilisation();
		yourStore = new YourStore(driver, true).get();
		yourStore.clickOnMyAccountBtn();
		AccountLogin loginPg = yourStore.clickOnLoginBtn();
		MyAccount myAccount = loginPg.loginToPortal();
		myWishlist = myAccount.clickWishListBtn();

	}
	
	@Test
	public void testGit() {
		System.out.println("Git Testing");
	}
	
	@Test
	public void testGit1() {
		System.out.println("Git Testing");
	}
	
	

	@Test
	public void validateProductStock() {
		
//		WebElement element = myWishlist.getCellElementFromTable(MyWishListTable.STOCK, "Product 15");
//
//		Assert.assertEquals(element.getText(), "In Stock", "Not In Stock");
		
		try {
		    WebElement element = myWishlist.getCellElementFromTable(MyWishListTable.STOCK, "Product 15");
		    Assert.assertEquals(element.getText(), "In Stock", "Element text does not match 'In Stock'");
		} catch (NoSuchElementException e) {
		   System.out.println("Product is not added in list");
		}

	}

	@AfterMethod
	public void teerDown() {
		tearDown();
	}

}
