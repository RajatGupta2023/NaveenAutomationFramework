package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class AccountLogin extends Page {

	public String PAGE_URL = "/opencart/index.php?route=account/login";

	public AccountLogin(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By emailInput = By.id("input-email");
	private static By pwdInput = By.id("input-password");
	private static By loginBtn = By.cssSelector("input[type='Submit']");

	private void enterEmail() {
		((ProxyDriver) driver).sendKeys(emailInput, "jainrajat1235@gmail.com");
	}

	private void enterPassword() {
		((ProxyDriver) driver).sendKeys(pwdInput, "RAJATjain");
	}



	public MyAccount loginToPortal() {
		enterEmail();
		enterPassword();
		((ProxyDriver) driver).click(loginBtn);
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

	@Override
	public AccountLogin get() {
		return (AccountLogin) super.get();
	}
}
