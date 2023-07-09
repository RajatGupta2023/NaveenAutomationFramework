package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class YourOrderHasBeenPlaced extends TestBase{
	
	public String pageTitle() {
	return	driver.getTitle();
	}
	
	@FindBy(css = "div#content>p:first-of-type")
	private WebElement orderPlaceSuccessMessage;
	
	
	public String getTextOfOrderPlaceSuccessMessage() {
		return orderPlaceSuccessMessage.getText();
	}

}
