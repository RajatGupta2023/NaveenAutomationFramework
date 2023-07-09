package pages;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.naveenautomationlabs.automationframework.base.TestBase;

public class AppleCinema30 extends TestBase {

	// How to upload file remaining
	public AppleCinema30() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='option[218]']")
	private WebElement mediumRadioBtn;

	@FindBy(css = "#input-option223>div:first-of-type input")
	private WebElement checkbox2Btn;

	@FindBy(css = "#input-option208")
	private WebElement inputText;

	@FindBy(css = "#input-option217")
	private WebElement selectBar;

	@FindBy(css = "#input-option209")
	private WebElement textArea;

	@FindBy(css = "button#button-upload222")
	private WebElement uploadBtn;

	@FindBy(css = "#button-cart")
	private WebElement addToCartBtn;

	@FindBy(css = "#product-product>div:first-of-type")
	private WebElement addToCartBtnSuccessMessage;

	@FindBy(css = "ul.list-inline>li:nth-of-type(4) span")
	private WebElement shoppingCartBtn;

	public void clickOnmediumRadioBtn() {
		mediumRadioBtn.click();
	}

	public void clickOncheckbox2Btn() {
		checkbox2Btn.click();
	}

	// first I need to clear enter text
	public void enterText() {
		inputText.clear();
		inputText.sendKeys("Rajat");
	}

	public void selectcolor() {
		Select sc = new Select(selectBar);
		sc.selectByValue("2");
	}

	public void enterMessageInTextArea() {
		textArea.sendKeys("Thanks for selecting this product");
	}

	public void uploadingFile() {
		String filePath = "C:\\Users\\16477\\Desktop\\Java\\upload.pdf";

		// Click the upload button to open the file dialog
		uploadBtn.click();

		// Wait for the file dialog to appear 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Set the file path in the file dialog using the Robot class  We are performing control c operation here
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void clickOnaddToCartBtn() {
		addToCartBtn.click();
	}

	public ShoppingCart clickOnshoppingCartBtn() {
		shoppingCartBtn.click();
		return new ShoppingCart();
	}

}
