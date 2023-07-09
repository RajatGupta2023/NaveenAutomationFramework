package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class YourStore extends TestBase{
	WebDriverWait wait;
	public YourStore() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 30);
	}
	@FindBy(css = "ul.nav>li:nth-of-type(3) a")
	private WebElement componentsBtn;
	
	@FindBy(css = "ul.nav>li:nth-of-type(3) ul li:nth-of-type(2) a")
	private WebElement monitorsBtn;
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountBtn;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement login;
	
	
	@FindBy(css = "div#slideshow0 >div>div.swiper-slide-duplicate-prev")
	private WebElement firstImage;
	
	public WebElement getFirstImageWebElement() {
		//wait.until(ExpectedConditions.visibilityOf(image));
		
		return firstImage;
		
	}
	
	@FindBy(css = "div#slideshow0 >div>div.swiper-slide-duplicate-active")
	private WebElement secondImage;
	
	public WebElement getSecondImageWebElement() {
		//wait.until(ExpectedConditions.visibilityOf(image));
		
		return secondImage;
		
	}
	
	
	public void clickOnComponentsBtn() {
		
		wait.until(ExpectedConditions.elementToBeClickable(componentsBtn));
		componentsBtn.click();
		
	}
	
	public Monitors clickOnmonitorsBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(monitorsBtn));
		monitorsBtn.click();
		
		return new Monitors();
		
	}
	
	public void clickOnMyAccountBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(myAccountBtn));
		myAccountBtn.click();
	}
	
	public AccountLogin clickOnLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		return new AccountLogin();
	}
	
}
