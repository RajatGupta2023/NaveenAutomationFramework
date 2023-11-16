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
	private static By modifyYourAddressBookEntriesBtn = By.xpath("//a[text()='Modify your address book entries']");
	private static By passswordChangeSeccessfulMessage = By.cssSelector("div.list-group>a:nth-of-type(3)");
	private static By editYourAccountInformationBtn = By.xpath("//a[text()='Edit your account information']");
	private static By accountUpdatedMessage = By.cssSelector("div.list-group>a:nth-of-type(3)");
	private static By returnsBtn = By.cssSelector("footer>div>div>div:nth-of-type(2)>ul>li:nth-of-type(2)>a");

	public ChangePassword clickOnPasswordBtn() {
		((ProxyDriver) driver).click(passwordBtn);
		return new ChangePassword(driver, true);
	}

	public ProductReturns clickOnReturnsBtn() {
		((ProxyDriver) driver).click(returnsBtn);
		return new ProductReturns(driver,true);
	}

	public AddressBook clickOnModifyYourAddressBookEntriesBtn() {
		((ProxyDriver) driver).click(modifyYourAddressBookEntriesBtn);
		return new AddressBook(driver, true);
	}

	public MyAccountInformation clickOnEditYourAccountInformationBtn() {
		((ProxyDriver) driver).click(editYourAccountInformationBtn);
		return new MyAccountInformation(driver, true);
	}

	public String getPassswordChangeSeccessfulMessage() {

		return ((ProxyDriver) driver).getText(passswordChangeSeccessfulMessage);
	}

	public String getAccountUpdatedMessage() {

		return ((ProxyDriver) driver).getText(accountUpdatedMessage);
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
