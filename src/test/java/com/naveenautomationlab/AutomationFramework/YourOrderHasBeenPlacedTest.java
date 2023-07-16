package com.naveenautomationlab.AutomationFramework;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.naveenautomationlabs.automationframework.base.TestBase;

import pages.AppleCinema30;
import pages.Checkout;
import pages.Monitors;
import pages.ShoppingCart;
import pages.YourOrderHasBeenPlaced;
import pages.YourStore;

public class YourOrderHasBeenPlacedTest extends TestBase {
	private YourStore yourStore;
	private Monitors monitors;
	private AppleCinema30 appleCinema30;
	private ShoppingCart shoppingCart;
	private Checkout checkout;
	private YourOrderHasBeenPlaced yourOrderHasBeenPlaced;
	private WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		insilisation();
		yourStore = new YourStore();
		wait = new WebDriverWait(driver, 10);

	}

	@Test @Ignore
	public void validateCustomerOrderprocess() {
		yourStore.clickOnComponentsBtn();
		monitors = yourStore.clickOnmonitorsBtn();
		appleCinema30 = monitors.clickOnaddToCartBtn();
		appleCinema30.clickOnmediumRadioBtn();
		appleCinema30.clickOncheckbox2Btn();
		appleCinema30.enterText();
		appleCinema30.selectcolor();
		appleCinema30.enterMessageInTextArea();
		appleCinema30.uploadingFile();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		appleCinema30.clickOnaddToCartBtn();
		appleCinema30.clickOnaddToCartBtn();
		shoppingCart = appleCinema30.clickOnshoppingCartBtn();
		checkout = shoppingCart.clickOnCheckoutBtn();
		checkout.loginToPortal();
		checkout.billingAddressToPortal();
		checkout.clickdeliverContinueBtn();
		checkout.deliveryMethodToPortal();
		checkout.paymentMethodToPortal();
		yourOrderHasBeenPlaced = checkout.clickOnconfirmOrderBtn();

		Assert.assertEquals(yourOrderHasBeenPlaced.getTextOfOrderPlaceSuccessMessage(),
				"Your order has been successfully processed!", "Your order is not Placed");

	}

	@AfterMethod
	public void quit() {
		tearDown();
	}
}
