package selenium.jira;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	static WebDriver driver;

	// To Highlight Element

	public static void flash(WebDriver driver, WebElement element) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgColour = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", driver, element);
			changeColor(bgColour, driver, element);
		}

	}

	public static void changeColor(String color, WebDriver driver, WebElement element) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element); // execute the script

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

		}

	}

	// DrawBorder around an Element
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border= '3px solid red'", element);
	}

	// Generate custom Alert during Test Execution

	public static void generateCustomAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	// Click on an Element by using JaveScript
	public static void clickOnWebElementByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	// Refresh browser by using JavaScript
	public static void refreshBroswerByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	// Get Title by using JavaScript
	
	public static String getTitleByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	//Get InnerText of page by using JavaScript
	
	public static String getInnerTextByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	// Scroll Page Down
	
	public static void scrollPageDownByJs(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//Scroll Into View
	
	public static void scrollIntoViewByJs(WebElement element,WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/newtours/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("userName")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

		WebElement element = driver.findElement(By.name("submit"));

		flash(driver, element);// highlights the background color

		drawBorder(element, driver); // To Draw a border

		// Take Screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File("C:\\Users\\bhara\\Downloads\\Bug.png"));

		// To generate custom alert

		// generateCustomAlert(driver,"There is an issue at submit button in HomePage");

		//clickOnWebElementByJs(driver, element);
		
		refreshBroswerByJs(driver);
		
		System.out.println(getTitleByJs(driver));
		
		System.out.println(getInnerTextByJs(driver));
		
		//scrollPageDownByJs(driver);
		
		WebElement findOut = driver.findElement(By.xpath("//img[@src='images/hdr_links.gif']"));
		
		scrollIntoViewByJs(findOut,driver);
	}

}
