package base;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.Constant;

public class PredefinedActions {

	protected static WebDriver driver;
	static WebDriverWait wait;
	private static Actions actions;

	public static void start(String env) {
		String browser = System.getProperty("browser");
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty(Constant.CHROMEDRIVERKEY, Constant.CHROMEDRIVER);
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty(Constant.FIREFOXDRIVERKEY, Constant.FIREFOXDRIVER);
			driver = new FirefoxDriver();
			break;

		case "edge":
			System.setProperty(Constant.EDGEDRIVERKEY, Constant.EDGEDRIVER);
			driver = new EdgeDriver();
			break;
		}
		
		switch (env) {
		case "qa":
			driver.get(Constant.QAURL);			
			break;
			
		case "uat":
			driver.get(Constant.UATURL);
			break;
		}

		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Constant.EXPLICITWAIT);
		actions = new Actions(driver);
	}

	public static String getPageTitle() {
		return driver.getTitle();
	}

	protected void clickOnElement(WebElement e, boolean isWaitRequired) {
		if (isWaitRequired) {
			wait.until(ExpectedConditions.elementToBeClickable(e));
		}
		e.click();
	}

	protected void clickOnLoginButton(WebElement e, boolean isWaitRequired) {
		if (isWaitRequired)
			wait.until(ExpectedConditions.elementToBeClickable(e));
		e.submit();
	}

	protected void enterText(WebElement e, String str) {
		e.sendKeys(str);
	}

	protected String getElementText(WebElement e, boolean isWaitRequired) {
		if (isWaitRequired) {
			waitForVisibilityOfElement(e);
		}

		String text = e.getText();
		if (text.equals(""))
			text = e.getAttribute("value");

		return text;
	}

	protected boolean isElementDisplayed(WebElement e, boolean isWaitRequired) {
		if (waitForVisibilityOfElement(e)) {
			return true;
		}
		return false;
	}

	protected List<String> getListOfElementText(List<WebElement> list) {
		List<String> listOfElementText = new ArrayList<String>();
		for (WebElement e : list) {
			listOfElementText.add(e.getText());
		}
		return listOfElementText;
	}

	protected boolean waitForVisibilityOfElement(WebElement e) {
		try {
			wait.until(ExpectedConditions.visibilityOf(e));
		} catch (Exception exception) {
			return false;
		}
		return true;
	}

	protected void mouseHoverToElement(WebElement e, boolean isWaitRequired) {
		if (isWaitRequired)
			waitForVisibilityOfElement(e);
		actions.moveToElement(e).build().perform();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public static void wrapUp() {
		driver.quit();
	}

	public static void takeScreenshot(String testName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./failedTCSS/" + testName + ".jpeg"));
		} catch (IOException e) {
		}

	}

}