package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class AccountLogin extends TestBase {
	public AccountLogin() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#input-email")
	private WebElement inputEmail;
	
	@FindBy(css = "#input-email")
	private WebElement inputEmails;

	@FindBy(css = "#input-password")
	private WebElement password;

	@FindBy(css = "input[value='Login']")
	private WebElement loginButton;

	private void enterEmail() {
		inputEmail.sendKeys("jainrajat1234@gmail.com");
	}

	private void enterPassword() {
		password.sendKeys("RAJATjain");
	}

	private MyAccount clickOnLoginBtn() {
		loginButton.submit();
		return new MyAccount();
	}
	
	public MyAccount loginToPortal() {
		enterEmail();
		enterPassword();
		clickOnLoginBtn();
		return new MyAccount();
	}
}
