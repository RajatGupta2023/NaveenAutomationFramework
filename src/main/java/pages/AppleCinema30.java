package pages;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlab.AutomationFramework.Utils.ProxyDriver;
import com.naveenautomationlab.AutomationFramework.Utils.Utils;
import com.naveenautomationlabs.automationframework.base.TestBase;

public class AppleCinema30 extends Page {

	public String PAGE_URL = "/opencart/index.php?route=product/product&product_id=42";

	public AppleCinema30(WebDriver driver, boolean waitForPageToLoad) {
		super(driver, waitForPageToLoad);

	}

	private static By mediumRadioBtn = By.cssSelector("input[name='option[218]']");
	private static By checkbox2Btn = By.cssSelector("#input-option223>div:first-of-type input");
	private static By inputText = By.cssSelector("#input-option208");
	private static By selectBar = By.cssSelector("#input-option217");
	private static By textArea = By.cssSelector("#input-option209");
	private static By uploadBtn = By.cssSelector("button#button-upload222");
	private static By addToCartBtn = By.cssSelector("#button-cart");
	private static By addToCartBtnSuccessMessage = By.cssSelector("#product-product>div:first-of-type");
	private static By shoppingCartBtn = By.cssSelector("ul.list-inline>li:nth-of-type(4) span");

	public void clickOnmediumRadioBtn() {
		((ProxyDriver) driver).click(mediumRadioBtn);

	}

	public void clickOncheckbox2Btn() {
		((ProxyDriver) driver).click(checkbox2Btn);

	}

	// first I need to clear enter text
	public void enterText() {
		((ProxyDriver) driver).clear(inputText);

		((ProxyDriver) driver).sendKeys(inputText, "Rajat");
	}

	public void selectcolor() {
		WebElement selectBarWebElement = ((ProxyDriver) driver).findElement(selectBar);
		Select sc = new Select(selectBarWebElement);
		sc.selectByValue("2");
	}

	public void enterMessageInTextArea() {
		((ProxyDriver) driver).sendKeys(textArea, "Thanks for selecting this product");
	}

	public void uploadingFile() {
		String filePath = "C:\\Users\\16477\\Desktop\\Java\\upload.pdf";

		// Click the upload button to open the file dialog
		((ProxyDriver) driver).click(uploadBtn);

		// Wait for the file dialog to appear

		
		Utils.sleep(2000);

		// Set the file path in the file dialog using the Robot class We are performing
		// control c operation here
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			return;
		}

		// Simulate keyboard shortcuts to paste the file path and press Enter
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.delay(1000); // Delay to allow the file path to be pasted

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Wait for the file to be uploaded
		Utils.sleep(2000);

	}

	public void clickOnaddToCartBtn() {
		((ProxyDriver) driver).click(addToCartBtn);
	}

	public ShoppingCart clickOnshoppingCartBtn() {
		((ProxyDriver) driver).click(shoppingCartBtn);
		return new ShoppingCart(driver, true);
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
