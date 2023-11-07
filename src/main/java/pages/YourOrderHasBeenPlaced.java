package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class YourOrderHasBeenPlaced extends Page{
	
	public String PAGE_URL = "";

	public YourOrderHasBeenPlaced(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	
	
	public String pageTitle() {
	return	((ProxyDriver) driver).getTitle();
	}
	private static By orderPlaceSuccessMessage = By.cssSelector("div#content>p:first-of-type");
	
	
	public String getTextOfOrderPlaceSuccessMessage() {
		return ((ProxyDriver) driver).getText(orderPlaceSuccessMessage);
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
