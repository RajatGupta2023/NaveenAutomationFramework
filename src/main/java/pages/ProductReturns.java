package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlab.AutomationFramework.Utils.Utils;

public class ProductReturns extends Page {

	public String PAGE_URL = "/opencart/index.php?route=account/return/add";

	public ProductReturns(WebDriver driver, boolean waitForPageToLoad) {
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

	private static By firstNameInput = By.id("input-firstname");
	private static By lastNameinput = By.id("input-lastname");
	private static By emailInput = By.id("input-email");

	private static By telephoneInput = By.id("input-telephone");
	private static By orderId = By.id("input-order-id");
	private static By calender = By.cssSelector("button[class$='btn-default']");
	private static By monthYear = By.cssSelector("div[class*=\"bootstrap\"]>div>div>table>thead>tr>th:nth-of-type(2)");
	private static By prevBtn = By.cssSelector(
			"div[class*=\"bootstrap\"]>div>div:first-of-type>table>thead>tr:first-of-type>th:first-of-type");

	private static By productNameInput = By.id("input-product");
	private static By productCodeInput = By.id("input-model");
	private static By quantityInput = By.id("input-quantity");

	private static By receiveWrongItemRadioBtn = By.cssSelector("input[name='return_reason_id'][value='5']");
	private static By commentBox = By.id("input-comment");
	private static By submitBtn = By.cssSelector("input[value='Submit']");

	public void selectDate(String exMonth, String exYear, String exDate) {
		((ProxyDriver) driver).click(calender);
		String monthYearValue = ((ProxyDriver) driver).getText(monthYear);
		String month = monthYearValue.split(" ")[0].trim();
		String year = monthYearValue.split(" ")[1].trim();

		while (!(month.equals(exMonth) && year.equals(exYear))) {
			((ProxyDriver) driver).click(prevBtn);
			monthYearValue = ((ProxyDriver) driver).getText(monthYear);
			month = monthYearValue.split(" ")[0].trim();
			year = monthYearValue.split(" ")[1].trim();

		}
		System.out.println(month);
		By date = By.xpath("//td[text()='" + exDate + "']");
		((ProxyDriver) driver).click(date);

	}

	public void enterFirstName() {
		((ProxyDriver) driver).clear(firstNameInput);
		((ProxyDriver) driver).sendKeys(firstNameInput, "Rajat");
	}

	public void enterLastName() {
		((ProxyDriver) driver).clear(lastNameinput);
		((ProxyDriver) driver).sendKeys(lastNameinput, "Gupta");
	}

	public void enterEmail() {
		((ProxyDriver) driver).clear(emailInput);
		((ProxyDriver) driver).sendKeys(emailInput, "jainrajat1235@gmail.com");
	}

	public void enterTelephone() {
		((ProxyDriver) driver).clear(telephoneInput);
		((ProxyDriver) driver).sendKeys(telephoneInput, "6477394962");
	}

	public void enterOrderId() {
		((ProxyDriver) driver).clear(orderId);
		((ProxyDriver) driver).sendKeys(orderId, "64773");
	}

	public void enterProductName() {
		((ProxyDriver) driver).clear(productNameInput);
		((ProxyDriver) driver).sendKeys(productNameInput, "Moniter");
	}

	public void enterProductCode() {
		((ProxyDriver) driver).clear(productCodeInput);
		((ProxyDriver) driver).sendKeys(productCodeInput, "product15");
	}

	public void enterQuantity() {
		((ProxyDriver) driver).clear(quantityInput);
		((ProxyDriver) driver).sendKeys(quantityInput, "2");
	}

	public void selectItemReturnReason() {
		((ProxyDriver) driver).click(receiveWrongItemRadioBtn);
	}

	public void addComment() {
		((ProxyDriver) driver).sendKeys(commentBox, "Thank You!!!!");
	}

	public void clickOnSubmitBtn() {
		((ProxyDriver) driver).submit(submitBtn);
	}

	public ConfirmProductReturns returnProductPortal() {
		enterFirstName();
		enterLastName();
		enterEmail();
		enterTelephone();
		enterOrderId();
		selectDate("January", "2023", "26");
		enterProductName();
		enterProductCode();
		enterQuantity();
		selectItemReturnReason();
		addComment();
		clickOnSubmitBtn();
		return new ConfirmProductReturns(driver, true);
	}

}
