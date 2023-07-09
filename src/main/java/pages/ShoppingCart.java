package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class ShoppingCart extends TestBase{
	public ShoppingCart() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a.btn-primary")
	private WebElement checkoutBtn;
	
	public Checkout clickOnCheckoutBtn() {
		checkoutBtn.click();
		return new Checkout();
	}
	
	


}
