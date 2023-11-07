package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlab.AutomationFramework.Utils.Utils;

public class RegisterAccount extends Page{
	public String PAGE_URL = "/opencart/index.php?route=account/register";

	public RegisterAccount(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}
	
	private String randomPassword = Utils.generateRandomString(10);

	private static By firstName = By.id("input-firstname");
	private static By lastName = By.id("input-lastname");
	private static By inputEmail = By.id("input-email");
	
	private static By telephone = By.id("input-telephone");
	private static By password = By.id("input-password");
	private static By passwordCnfm = By.id("input-confirm");
	
	private static By policyAgreeCheckbox = By.xpath("//input[@name='agree']");
	private static By ContinueBtn = By.xpath("//input[@value='Continue']");
	private static By warningMessageEmailAleadyRegister = By.cssSelector("#account-register>div:first-of-type");
	private static By warningMessageEmailAddressDoesNotAppear = By.cssSelector("fieldset#account>div:nth-of-type(4)>div>div");
	
	
	private void enterFirstName() {
		((ProxyDriver) driver).sendKeys(firstName, Utils.generateRandomString(5));
	}

	private void enterLastName() {
		((ProxyDriver) driver).sendKeys(lastName, Utils.generateRandomString(5));
	}
	
	
	private void enterEmail() {
		((ProxyDriver) driver).sendKeys(inputEmail, Utils.generateRandomString(5)+"@gmail.com");
	}
	
	private void enterRegisteredEmail() {
		((ProxyDriver) driver).sendKeys(inputEmail,"jainrajat1234@gmail.com");
	}
	
	private void enterEmptyEmail() {
		((ProxyDriver) driver).sendKeys(inputEmail,"");
	}

	private void enterTelephone() {
		((ProxyDriver) driver).sendKeys(telephone, Utils.generateRandomNumber(10));
	}
	
	
	private void enterPassword() {
		((ProxyDriver) driver).sendKeys(password, randomPassword);
	}

	private void enterPasswordCnfm() {
		((ProxyDriver) driver).sendKeys(passwordCnfm, randomPassword);
	}
	
	
	private void clickOnPolicyBtn() {
		((ProxyDriver) driver).click(policyAgreeCheckbox);
	}

	private void clickOnContinueBtn() {
		((ProxyDriver) driver).submit(ContinueBtn);
	}
	 
	public  String getEmailAlradyRegisterEmailWarning() {
		
		return ((ProxyDriver) driver).getText(warningMessageEmailAleadyRegister);
		
	}
	
	public  String getWarningMessageEmailAddressDoesNotAppear() {
		
		return ((ProxyDriver) driver).getText(warningMessageEmailAddressDoesNotAppear);
		
	}
	
	
	
	
	public YourAccountHasBeenCreated registerPortal() {
		enterFirstName();
		enterLastName();
		enterEmail();
		enterTelephone();
		enterPassword();
		enterPasswordCnfm();
		clickOnPolicyBtn();
		clickOnContinueBtn();
		return new YourAccountHasBeenCreated(driver, true);
	}
	
	public RegisterAccount registerPortalWithAlreadyRegistedEmail() {
		enterFirstName();
		enterLastName();
		enterRegisteredEmail();
		enterTelephone();
		enterPassword();
		enterPasswordCnfm();
		clickOnPolicyBtn();
		clickOnContinueBtn();
		return new RegisterAccount(driver, true);
	}
	
	public RegisterAccount registerPortalWithoutEmail() {
		enterFirstName();
		enterLastName();
		enterEmptyEmail();
		enterTelephone();
		enterPassword();
		enterPasswordCnfm();
		clickOnPolicyBtn();
		clickOnContinueBtn();
		return new RegisterAccount(driver, true);
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
	public RegisterAccount get() {
		return (RegisterAccount) super.get();
	}
}
