package pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;





public class SideNavBar extends Page {

	public SideNavBar(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);
	}

	@Override
	protected void isLoaded() {
		// TODO Auto-generated method stub

	}

	public Page OpenPageByClickOnSideNavBar(ConsumerSideNavigationBar item) {
		List<WebElement> sideBarItems = driver.findElements(By.cssSelector("div.list-group a"));

		for (WebElement webElement : sideBarItems) {
			if (webElement.getText().trim().equalsIgnoreCase(item.getItem())) {
				((ProxyDriver) driver).click(webElement);
				return (Page) this.waitForPageToLoad(item.getpageClass());
			}
		}
		return null;
	}

}
