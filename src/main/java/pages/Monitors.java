package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class Monitors extends TestBase{
	public Monitors() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = "#content>div:nth-of-type(3)>div:first-of-type div.button-group>button:first-of-type")
	private WebElement addToCartBtn;
	
	
//	@FindBy(css = "#input-option218>div:nth-of-type(2) input")
//	private WebElement mediumBtn;
	
	public AppleCinema30 clickOnaddToCartBtn() {
		addToCartBtn.click();
		return new AppleCinema30();
	}
}
