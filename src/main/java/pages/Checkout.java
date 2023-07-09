package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class Checkout extends TestBase {
	public Checkout() {
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, 10);
	@FindBy(css = "#input-email")
	private WebElement emailInputField;

	@FindBy(css = "#input-password")
	private WebElement passwordInputField;

	@FindBy(css = "#button-login")
	private WebElement loginBtn;

	private void enterEmail() {
		emailInputField.sendKeys("jainrajat1234@gmail.com");
	}

	private void enterPassword() {
		passwordInputField.sendKeys("RAJATjain");
	}

	private void clickLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();

	}

	public void loginToPortal() {
		enterEmail();
		enterPassword();
		clickLoginBtn();
	}

	// Address
	@FindBy(css = "form.form-horizontal>div:nth-of-type(3) input")
	private WebElement newAddressRadioBtn;

	@FindBy(css = "#input-payment-firstname")
	private WebElement firstNameInputField;

	@FindBy(css = "#input-payment-lastname")
	private WebElement lastNameInputField;

	@FindBy(css = "#input-payment-company")
	private WebElement companyInputField;

	@FindBy(css = "#input-payment-address-1")
	private WebElement address1InputField;

	@FindBy(css = "#input-payment-address-2")
	private WebElement address2InputField;

	@FindBy(css = "#input-payment-city")
	private WebElement cityInputField;

	@FindBy(css = "#input-payment-postcode")
	private WebElement postalCodeInputField;

	@FindBy(css = "#input-payment-country")
	private WebElement countryInputField;

	@FindBy(css = "#input-payment-zone")
	private WebElement stateInputField;

	@FindBy(css = "#button-payment-address")
	private WebElement billingDetailsContinueBtn;

	private void clickOnNewAddressRadioBtn() {
		newAddressRadioBtn.click();
	}

	private void enterFirstName() {
		firstNameInputField.sendKeys("Rajat");
	}

	private void enterLastName() {
		lastNameInputField.sendKeys("Jain");
	}

	private void enterCompany() {
		companyInputField.sendKeys("ATS");
	}

	private void enterAddress1() {
		address1InputField.sendKeys("ABC Drive");
	}

	private void enterAddress2() {
		address2InputField.sendKeys("ABC Drive");
	}

	private void enterCity() {
		cityInputField.sendKeys("Brampton");
	}

	private void enterPostalCode() {
		postalCodeInputField.sendKeys("A1B2C3");
	}

	private void selectCountry() {
		Select sc = new Select(countryInputField);
		sc.selectByValue("38");
	}

	private void selectState() {
		Select sc = new Select(stateInputField);
		sc.selectByValue("610");
	}

	private Checkout clickBillingDetailsContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(billingDetailsContinueBtn));
		billingDetailsContinueBtn.click();
		return new Checkout();
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

	@FindBy(css = "div#collapse-shipping-address>div:first-of-type input")
	private WebElement deliverDetailsRadioBtn;

	@FindBy(css = "input#button-shipping-address")
	private WebElement deliverContinueBtn;

//	private void clickDeliverDetailsRadioBtn() {
//		deliverDetailsRadioBtn.click();
//		
//	}

	public void clickdeliverContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(deliverContinueBtn));
		deliverContinueBtn.click();

	}

	public void deliveryAddressToPortal() {
		// clickDeliverDetailsRadioBtn();
		clickdeliverContinueBtn();
	}

	// Delivery Method

//	@FindBy(css = "input[value='flat.flat']")
//	private WebElement flatRateRadioBtn;

//	@FindBy(css = "textarea.form-control")
//	private WebElement addCommentsInputField;

	@FindBy(css = "input#button-shipping-method")
	private WebElement deliveryMethodContinueBtn;

//	private void clickOnFlatRateRadioBtn() {
//		flatRateRadioBtn.click();
//	}

//	private void addCommentsInputField() {
//		addCommentsInputField.sendKeys("Thanks for this product");
//	}

	private void clickOnDeliveryMethodContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(deliveryMethodContinueBtn));
		deliveryMethodContinueBtn.click();

	}

	public void deliveryMethodToPortal() {
		// clickOnFlatRateRadioBtn();
		// addCommentsInputField();
		clickOnDeliveryMethodContinueBtn();
	}

	// Payment Method

	@FindBy(css = "input[name='payment_method']")
	private WebElement cashOnDeliveryRadioBtn;

	@FindBy(css = "input[name='agree']")
	private WebElement termsAndConditionsCheckBtn;

	@FindBy(css = "input#button-payment-method")
	private WebElement paymentMethodContinueBtn;

	private void clickOnCashOnDeliveryRadioBtn() {
		cashOnDeliveryRadioBtn.click();
	}

	private void clickOntermsAndConditionsCheckBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(termsAndConditionsCheckBtn));
		termsAndConditionsCheckBtn.click();
	}

	private Checkout clickOnPaymentMethodContinueBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueBtn));
		paymentMethodContinueBtn.click();
		return new Checkout();
	}

	public Checkout paymentMethodToPortal() {
		// clickOnCashOnDeliveryRadioBtn();
		clickOntermsAndConditionsCheckBtn();
		return clickOnPaymentMethodContinueBtn();
	}

	// Confirm Order

	@FindBy(css = "input#button-confirm")
	private WebElement confirmOrderBtn;

	public YourOrderHasBeenPlaced clickOnconfirmOrderBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));

		confirmOrderBtn.click();
		return new YourOrderHasBeenPlaced();
	}

}
