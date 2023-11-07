package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class Checkout extends Page {
	public String PAGE_URL = "";

	public Checkout(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By emailInputField = By.cssSelector("#input-email");
	private static By passwordInputField = By.cssSelector("#input-password");
	private static By loginBtn = By.cssSelector("#button-login");

	private void enterEmail() {
		((ProxyDriver) driver).sendKeys(emailInputField, "jainrajat1234@gmail.com");

	}

	private void enterPassword() {
		((ProxyDriver) driver).sendKeys(passwordInputField, "RAJATjain");

	}

	private void clickLoginBtn() {
		((ProxyDriver) driver).click(loginBtn);

	}

	public void loginToPortal() {
		enterEmail();
		enterPassword();
		clickLoginBtn();
	}

	// Address
	private static By newAddressRadioBtn = By.cssSelector("form.form-horizontal>div:nth-of-type(3) input");
	private static By firstNameInputField = By.cssSelector("#input-payment-firstname");
	private static By lastNameInputField = By.cssSelector("#input-payment-lastname");
	private static By companyInputField = By.cssSelector("#input-payment-company");
	private static By address1InputField = By.cssSelector("#input-payment-address-1");
	private static By address2InputField = By.cssSelector("#input-payment-address-2");
	private static By cityInputField = By.cssSelector("#input-payment-city");
	private static By postalCodeInputField = By.cssSelector("#input-payment-postcode");
	private static By countryInputField = By.cssSelector("#input-payment-country");
	private static By stateInputField = By.cssSelector("#input-payment-zone");
	private static By billingDetailsContinueBtn = By.cssSelector("#button-payment-address");

	private void clickOnNewAddressRadioBtn() {
		((ProxyDriver) driver).click(newAddressRadioBtn);
	}

	private void enterFirstName() {
		((ProxyDriver) driver).sendKeys(firstNameInputField, "Rajat");
	}

	private void enterLastName() {
		((ProxyDriver) driver).sendKeys(lastNameInputField, "Jain");
	}

	private void enterCompany() {
		((ProxyDriver) driver).sendKeys(companyInputField, "ATS");
	}

	private void enterAddress1() {
		((ProxyDriver) driver).sendKeys(address1InputField, "ABC Drive");
	}

	private void enterAddress2() {
		((ProxyDriver) driver).sendKeys(address2InputField, "ABC Drive");
	}

	private void enterCity() {
		((ProxyDriver) driver).sendKeys(cityInputField, "Brampton");
	}

	private void enterPostalCode() {
		((ProxyDriver) driver).sendKeys(postalCodeInputField, "A1B2C3");
	}

	private void selectCountry() {
		WebElement countryInputFieldWebElement = ((ProxyDriver) driver).findElement(countryInputField);
		Select sc = new Select(countryInputFieldWebElement);
		sc.selectByValue("38");
	}

	private void selectState() {
		WebElement stateInputFieldWebElement = ((ProxyDriver) driver).findElement(stateInputField);
		Select sc = new Select(stateInputFieldWebElement);
		sc.selectByValue("610");
	}

	private Checkout clickBillingDetailsContinueBtn() {
		((ProxyDriver) driver).click(billingDetailsContinueBtn);
		return new Checkout(driver, true);
	}

	public void billingAddressToPortal() {
		clickOnNewAddressRadioBtn();
		enterFirstName();
		enterLastName();
		enterCompany();
		enterAddress1();
		enterAddress2();
		enterCity();
		enterPostalCode();
		selectCountry();
		selectState();

		clickBillingDetailsContinueBtn();
	}

	private static By deliverDetailsRadioBtn = By.cssSelector("div#collapse-shipping-address>div:first-of-type input");
	private static By deliverContinueBtn = By.cssSelector("input#button-shipping-address");

	public void clickdeliverContinueBtn() {

		((ProxyDriver) driver).click(deliverContinueBtn);

	}

	public void deliveryAddressToPortal() {

		clickdeliverContinueBtn();
	}

	// Delivery Method

	private static By deliveryMethodContinueBtn = By.cssSelector("input#button-shipping-method");


	private void clickOnDeliveryMethodContinueBtn() {

		((ProxyDriver) driver).click(deliveryMethodContinueBtn);

	}

	public void deliveryMethodToPortal() {
		
		clickOnDeliveryMethodContinueBtn();
	}

	// Payment Method
	
	
	private static By cashOnDeliveryRadioBtn = By.cssSelector("input[name='payment_method']");
	private static By termsAndConditionsCheckBtn = By.cssSelector("input[name='agree']");
	private static By paymentMethodContinueBtn = By.cssSelector("input#button-payment-method");



	private void clickOnCashOnDeliveryRadioBtn() {
		((ProxyDriver) driver).click(cashOnDeliveryRadioBtn);
	}

	private void clickOntermsAndConditionsCheckBtn() {

		((ProxyDriver) driver).click(termsAndConditionsCheckBtn);
	}

	private Checkout clickOnPaymentMethodContinueBtn() {

		((ProxyDriver) driver).click(paymentMethodContinueBtn);
		return new Checkout(driver, true);
	}

	public Checkout paymentMethodToPortal() {
		// clickOnCashOnDeliveryRadioBtn();
		clickOntermsAndConditionsCheckBtn();
		return clickOnPaymentMethodContinueBtn();
	}

	// Confirm Order
	
	private static By confirmOrderBtn = By.cssSelector("input#button-confirm");

	
	public YourOrderHasBeenPlaced clickOnconfirmOrderBtn() {

		((ProxyDriver) driver).click(confirmOrderBtn);
		return new YourOrderHasBeenPlaced(driver, true);
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

}
