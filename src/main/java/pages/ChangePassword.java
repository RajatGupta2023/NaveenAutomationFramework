package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class ChangePassword extends Page {

	public String PAGE_URL = "/opencart/index.php?route=account/password";

	public ChangePassword(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By passwordConfirm = By.cssSelector("#input-confirm");
	private static By password = By.cssSelector("#input-password");
	private static By continueBtn = By.cssSelector("input[value= 'Continue']");

	public void enterPasswordConfirm() {
		((ProxyDriver) driver).sendKeys(passwordConfirm, "RAJATjain");

	}

	public void enterPassword() {
		((ProxyDriver) driver).sendKeys(password, "RAJATjain");

	}

	public MyAccount clickOnContinueBtn() {
		((ProxyDriver) driver).submit(continueBtn);
		return new MyAccount(driver, true);
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
