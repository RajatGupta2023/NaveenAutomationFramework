package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class MyAccount extends TestBase {
	private WebDriverWait wait;

	List<WebElement> elements = new ArrayList<>();

	public MyAccount() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	@FindBy(css = "div.list-group>a:nth-of-type(3)")
	private WebElement passwordBtn;

	@FindBy(css = "ul.list-inline>li:nth-of-type(3)")
	WebElement wishListBtn;

	public ChangePassword clickOnPasswordBtn() {
		passwordBtn.click();
		return new ChangePassword();
	}

	@FindBy(css = "div.list-group>a:nth-of-type(3)")
	private WebElement passswordChangeSeccessfulMessage;

	public String getPassswordChangeSeccessfulMessage() {

		return passswordChangeSeccessfulMessage.getText();
	}

	public boolean selectionFromNavigation(String selection) {

		elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.list-group a")));
		for (WebElement element : elements) {
			if (element.getText().equals(selection)) {
				return true;
			}

		}
		return false;
	}

	public MyWishList clickWishListBtn() {
		wishListBtn.click();
		return new MyWishList();
	}

}
