package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class Monitors extends Page {
	public String PAGE_URL = "/opencart/index.php?route=product/category&path=25_28";

	public Monitors(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By addToCartBtn = By
			.cssSelector("#content>div:nth-of-type(3)>div:first-of-type div.button-group>button:first-of-type");

//	private static By mediumBtn = By.cssSelector("#input-option218>div:nth-of-type(2) input");

	public AppleCinema30 clickOnaddToCartBtn() {
		((ProxyDriver) driver).click(addToCartBtn);
		return new AppleCinema30(driver, false);
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
