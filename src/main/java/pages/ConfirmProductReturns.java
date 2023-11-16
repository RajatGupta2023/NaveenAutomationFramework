package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;

public class ConfirmProductReturns extends Page {
	public String PAGE_URL = "/opencart/index.php?route=account/return/add";

	public ConfirmProductReturns(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

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

	private static By productReturnMessage = By.cssSelector("#content>h1");

	public String getProductReturnMessage() {
		return ((ProxyDriver) driver).getText(productReturnMessage);

	}

}
