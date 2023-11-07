package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;

public class EditPage extends Page {
	public EditPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	private static By firstNameInput = By.id("input-firstname");
	private static By lastNameInput = By.id("input-lastname");
	private static By emailInput = By.id("input-email");
	private static By telePhoneInput = By.id("input-telephone");
	private static By submitBtn = By.cssSelector("input[value='Continue']");

	public void enterFName(String name) {
		((ProxyDriver) driver).sendKeys(firstNameInput, name);
	}

	public void enterLName(String lname) {
		((ProxyDriver) driver).sendKeys(lastNameInput, lname);
	}

	public void enterEmail(String email) {
		((ProxyDriver) driver).sendKeys(emailInput, email);
	}

	public void enterTelephone(String number) {
		((ProxyDriver) driver).sendKeys(telePhoneInput, number);
	}

	public MyAccount clickSubmitBtn() {
		((ProxyDriver) driver).click(submitBtn);
		return null;
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

}
