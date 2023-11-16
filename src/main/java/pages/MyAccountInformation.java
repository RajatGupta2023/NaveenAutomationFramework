package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;

public class MyAccountInformation extends Page {

	public String PAGE_URL = "/opencart/index.php?route=account/edit";

	public MyAccountInformation(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By editFirstName = By.id("input-firstname");
	private static By editLastName = By.id("input-lastname");
	
	private static By editEmail = By.id("input-email");
	private static By editTelephone = By.id("input-telephone");
	private static By continueBtn = By.cssSelector("input[value='Continue']");
	
	public void editFirstName(String firstName) {
		((ProxyDriver) driver).clear(editFirstName);
		((ProxyDriver) driver).sendKeys(editFirstName, firstName);
	}
	
	public void editLastName(String lastName) {
		((ProxyDriver) driver).clear(editLastName);
		((ProxyDriver) driver).sendKeys(editLastName, lastName);
	}
	
	public void editEmail(String email) {
		((ProxyDriver) driver).clear(editEmail);
		((ProxyDriver) driver).sendKeys(editEmail, email);
	}
	
	public void editTelephone(String telephone) {
		((ProxyDriver) driver).clear(editTelephone);
		((ProxyDriver) driver).sendKeys(editTelephone,telephone);
	}
	
	public MyAccount clickOnContinueBtn() {
		((ProxyDriver) driver).click(continueBtn);
		return new MyAccount(driver, true);
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getPageUrl() {
		return getDomain() + PAGE_URL;
	}

}
