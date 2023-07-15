package com.naveenautomationlabs.automationframework.base;

import java.io.FileInputStream;
import org.testng.annotations.BeforeClass;

import com.naveenautomationlab.AutomationFramework.Listeners.WebDriverEvents;
import com.naveenautomationlab.AutomationFramework.Utils.Browsers;
import com.naveenautomationlab.AutomationFramework.Utils.Environment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	private FileInputStream fileInputStream;
	private Properties prop;
	public static Logger logger;
	private WebDriverEvents events;
	private EventFiringWebDriver eDriver;
//	private String browserName = System.getProperty("BROWSER"); // Retrieve browser choice from system property
	private Environment environment = Environment.PROD;

	public TestBase() {
		prop = new Properties();
		try {
			fileInputStream = new FileInputStream(
					"C:\\Users\\16477\\eclipse-workspace\\AutomationFramework\\src\\main\\java\\Config\\Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void insilisation() {
		String browserName = System.getProperty("BROWSER","Chrome");
		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup(); // Use setup() method instead of create()
			driver = new ChromeDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser choice: " + browserName);
		}

		eDriver = new EventFiringWebDriver(driver);
		events = new WebDriverEvents();
		eDriver.register(events);
		driver = eDriver;

		driver.get(environment.getUrl());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void tearDown() {
		driver.quit();
	}
}
