package pages;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GeneralPage extends LoadableComponent<GeneralPage> {

	protected WebDriver driver;

	private static final int Default_Time_For_Page_Load = 60;

	public GeneralPage(WebDriver driver, boolean waitForPageToLoad) {
		super();
		this.driver = driver;
		if (waitForPageToLoad) {
			this.waitForDocumentCompleteState();
		}
	}

	public boolean waitForDocumentCompleteState() {
		return new WebDriverWait(driver, Default_Time_For_Page_Load).until((ExpectedCondition<Boolean>) p -> {
			while (true) {
				String documentState = getDocumentReadyState();
				if (documentState.equals("complete")) {
					return true;
				}
			}
		});
	}

	public String getDocumentReadyState() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		return jse.executeScript(" return document.readyState").toString();

	}

	@Override
	public GeneralPage get() {
		return super.get();
	}
	
	protected boolean urlContains(String url) {
		try {
			String pageUrl = getPageUrl();
			URL pageUrlObject = new URL(pageUrl);
			URL urlObject = new URL(url);
			String pageUrlHost = pageUrlObject.getHost();
			String urlHost = urlObject.getHost();
			if(pageUrlHost.equalsIgnoreCase(urlHost)) {
				String pageUrlExcelHost = pageUrl.substring(pageUrl.indexOf(pageUrlHost)+ pageUrlHost.length());
				String urlExclHost = url.substring(url.indexOf(urlHost)+ urlHost.length());
				return urlExclHost.toLowerCase().contains(pageUrlExcelHost.toLowerCase());
			}
		} catch (MalformedURLException e) {
			
		}
		return false;
	}

	@Override
	protected void load() {
		String pageUrl = getPageUrl();
		driver.get(pageUrl);

	}

	protected abstract String getPageUrl();

	@Override
	protected abstract void isLoaded();
	@SafeVarargs
	public final GeneralPage waitForPageToLoad(final Class<? extends GeneralPage>... pagestoWaitFor) {

		return waitForPageToLoad(30,pagestoWaitFor);
	}

	

	@SafeVarargs
	protected final GeneralPage waitForPageToLoad(int timeForLoad,
			final Class<? extends GeneralPage>... pagestoWaitFor) {

		return new WebDriverWait(driver, timeForLoad).until(new ExpectedCondition<GeneralPage>() {

			@Override
			public GeneralPage apply(WebDriver input) {

				for (Class<? extends GeneralPage> page : pagestoWaitFor) {

					try {
						GeneralPage pg = page.getConstructor(WebDriver.class, Boolean.TYPE).newInstance(driver, true);
						return pg;
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}

				}
				return null;

			}
		});

	}

}
