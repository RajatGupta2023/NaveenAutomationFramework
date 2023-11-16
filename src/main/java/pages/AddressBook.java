package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;

public class AddressBook extends Page {

	public String PAGE_URL = "/opencart/index.php?route=account/address";

	public AddressBook(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By editBtn = By.xpath("//a[text()='Edit']");
	private static By newAddressBtn = By.xpath("//a[text()='New Address']");
	private static By deleteBtn = By.xpath("//a[text()='Delete']");
	private static By addressSuccessfullyEditMessage = By.cssSelector("#account-address>div:first-of-type");

	public EditAddressBook clickOnEditBtn() {
		((ProxyDriver) driver).click(editBtn);

		return new EditAddressBook(driver, true);
	}

	public String getAddressSuccessfullyEditMessage() {
		return ((ProxyDriver) driver).getText(addressSuccessfullyEditMessage);

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
