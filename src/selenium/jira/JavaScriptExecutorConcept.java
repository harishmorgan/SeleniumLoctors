package selenium.jira;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {
	
	static WebDriver driver;
	
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver , timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		//locator.click();
		
	}
	
	public static void flash(WebDriver driver,WebElement element) {
		
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		String bgColour = element.getCssValue("backgroundColor");
		for(int i =0;i<10;i++) {
		changeColor("rgb(0,200,0)",driver,element);
		changeColor(bgColour,driver,element);
		}
		
	}

	public static void changeColor(String color, WebDriver driver, WebElement element) {
		
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '" +color+"'",element); //execute the script
		
		try {
			Thread.sleep(20);
		} catch(InterruptedException e) {
			
		}
		
		
	}

	public static void main(String[] args) {
		
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
		
		flash(driver,element);//highlights the background color
		
		driver.getTitle();
		

	}

}
