package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class ShoppingCart extends Page {
	public String PAGE_URL = "/opencart/index.php?route=checkout/cart";

	public ShoppingCart(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By checkoutBtn = By.cssSelector("a.btn-primary");

	public Checkout clickOnCheckoutBtn() {
		((ProxyDriver) driver).click(checkoutBtn);
		return new Checkout(driver, false);
	}
	@Override
	protected void isLoaded() {
		if (!urlContains(driver.getCurrentUrl())) {
			throw new Error();
		}
	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

}
