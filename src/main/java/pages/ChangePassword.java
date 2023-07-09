package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class ChangePassword extends TestBase{
	
	public ChangePassword() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#input-confirm")
	private WebElement passwordConfirm;

	@FindBy(css = "#input-password")
	private WebElement password;

	@FindBy(css = "input[value= 'Continue']")
	private WebElement continueBtn;

	public void enterPasswordConfirm() {
		passwordConfirm.sendKeys("RAJATjain");
		
	}

	public void enterPassword() {
		password.sendKeys("RAJATjain");
	}

	public MyAccount clickOnContinueBtn() {
		continueBtn.submit();
		return new MyAccount();
	}

}
