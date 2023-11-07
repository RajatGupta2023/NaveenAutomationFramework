package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class YourStore extends Page {
	public String PAGE_URL = "/opencart/index.php?route=common/home";

	public YourStore(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By componentsBtn = By.cssSelector("ul.nav>li:nth-of-type(3) a");
	private static By monitorsBtn = By.cssSelector("ul.nav>li:nth-of-type(3) ul li:nth-of-type(2) a");
	private static By myAccountBtn = By.cssSelector("a[title='My Account']");

	private static By login = By.xpath("//a[text()='Login']");
	private static By registerBtn = By.xpath("//a[text()='Register']");
	private static By firstImage = By.cssSelector("div#slideshow0 >div>div.swiper-slide-duplicate-prev");

	public WebElement getFirstImageWebElement() {

		return ((ProxyDriver) driver).findElement(firstImage);

	}

	private static By secondImage = By.cssSelector("div#slideshow0 >div>div.swiper-slide-duplicate-active");

	public WebElement getSecondImageWebElement() {
		return ((ProxyDriver) driver).findElement(secondImage);

	}

	public void clickOnComponentsBtn() {

		((ProxyDriver) driver).click(componentsBtn);

	}

	public Monitors clickOnmonitorsBtn() {
		
		((ProxyDriver) driver).click(monitorsBtn);

		return new Monitors(driver, true);

	}

	public void clickOnMyAccountBtn() {
		
		((ProxyDriver) driver).click(myAccountBtn);
	}

	public AccountLogin clickOnLoginBtn() {
		
		((ProxyDriver) driver).click(login);
		return new AccountLogin(driver, true);
	}
	
	public RegisterAccount clickOnRegisterBtn() {
		
		((ProxyDriver) driver).click(registerBtn);
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
	public YourStore get() {
		return (YourStore) super.get();
	}
}
