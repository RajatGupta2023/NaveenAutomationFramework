package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;

public class EditAddressBook extends Page {

	private static final String PAGE_URL = "/opencart/index.php?route=account/address/edit&address_id=4559";

	public EditAddressBook(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

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

	private static By inputFirstName = By.id("input-firstname");
	private static By inputLastName = By.id("input-lastname");
	private static By inputCompany = By.id("input-company");

	private static By inputAddress1 = By.id("input-address-1");
	private static By inputAddress2 = By.id("input-address-2");
	private static By inputCity = By.id("input-city");

	private static By inputPostalcode = By.id("input-postcode");
	private static By inputCountry = By.id("input-country");
	private static By inputState = By.id("input-zone");
	private static By continueBtn = By.cssSelector("input[value='Continue']");
	
	
	
	public void enterFirstName() {
		((ProxyDriver) driver).clear(inputFirstName);
		((ProxyDriver) driver).sendKeys(inputFirstName, "Rajat");
	}
	
	public void enterLastName() {
		((ProxyDriver) driver).clear(inputLastName);
		((ProxyDriver) driver).sendKeys(inputLastName, "Jain");
	}
	
	public void enterCompanyName() {
		((ProxyDriver) driver).clear(inputCompany);
		((ProxyDriver) driver).sendKeys(inputLastName, "Garg Machinary");
	}
	
	public void enterAddress1() {
		((ProxyDriver) driver).clear(inputAddress1);
		((ProxyDriver) driver).sendKeys(inputAddress1, "XYZ");
	}
	
	public void enterAddress2() {
		((ProxyDriver) driver).clear(inputAddress2);
		((ProxyDriver) driver).sendKeys(inputAddress2, "ABC");
	}
	
	public void entercity() {
		((ProxyDriver) driver).clear(inputCity);
		((ProxyDriver) driver).sendKeys(inputCity, "Brampton");
	}
	
	public void enterPostalCode() {
		((ProxyDriver) driver).clear(inputPostalcode);
		((ProxyDriver) driver).sendKeys(inputPostalcode, "X1Y1Z1");
	}
	
	public void selectCountery() {
		((ProxyDriver) driver).selectItemFromDropDown(inputCountry,"India");
	}
	
	public void selectState() {
		
		((ProxyDriver) driver).selectItemFromDropDown(inputState,"Haryana");
	}
	
	public AddressBook clickonContinueBtn() {
		
		((ProxyDriver) driver).click(continueBtn);
		
		return new AddressBook(driver,true);
	}
	
	

}
