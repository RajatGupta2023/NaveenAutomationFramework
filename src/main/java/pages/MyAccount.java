package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class MyAccount extends Page {

	List<WebElement> elements = new ArrayList<>();

	private static final String PAGE_URL = "opencart/index.php?route=account/account";

	public MyAccount(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By passwordBtn = By.cssSelector("div.list-group>a:nth-of-type(3)");
	private static By wishListBtn = By.cssSelector("ul.list-inline>li:nth-of-type(3)");

	public ChangePassword clickOnPasswordBtn() {
		((ProxyDriver) driver).click(passwordBtn);
		return new ChangePassword(driver, false);
	}

	private static By passswordChangeSeccessfulMessage = By.cssSelector("div.list-group>a:nth-of-type(3)");

	public String getPassswordChangeSeccessfulMessage() {

		return ((ProxyDriver) driver).getText(passswordChangeSeccessfulMessage);
	}

	public boolean selectionFromNavigation(String selection) {

		By elementsLocator = By.cssSelector("div.list-group a");
		List<WebElement> elements = driver.findElements(elementsLocator);
		// elements =
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.list-group
		// a")));
		for (WebElement element : elements) {
			if (element.getText().equals(selection)) {
				return true;
			}

		}
		return false;
	}

	public MyWishList clickWishListBtn() {
		((ProxyDriver) driver).click(wishListBtn);
		return new MyWishList();
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
