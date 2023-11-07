package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;

public class YourAccountHasBeenCreated extends Page {


	public String PAGE_URL = "/opencart/index.php?route=account/success";

	public YourAccountHasBeenCreated(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}
	
	private static By yourAccountHasBeenCreatedMessage = By.cssSelector("#content>h1");
	
	public String getYourAccountHasBeenCreatedMessage() {
		
		return ((ProxyDriver) driver).getText(yourAccountHasBeenCreatedMessage);
		
		
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

	@Override
	public YourAccountHasBeenCreated get() {
		return (YourAccountHasBeenCreated) super.get();
	}
}
