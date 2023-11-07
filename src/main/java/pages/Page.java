package pages;

import org.openqa.selenium.WebDriver;

public abstract class Page extends GeneralPage {
	

	private static final String URL = "https://naveenautomationlabs.com";
	
	public Page(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);
		
	}
	
	public String getDomain() {
		return URL;
	}
	
	protected String getPageUrl() {
		return getDomain();
	}
	

}
