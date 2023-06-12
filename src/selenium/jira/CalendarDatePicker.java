package selenium.jira;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarDatePicker {
	
	
	static WebDriver driver;
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);

		driver.get("https://www.justdial.com/Travel/Train-Booking"); // enter URl

		WebElement date = driver.findElement(By.id("departDate"));
		date.click();
		date.clear();
		String date_value = "Tue,06-Jun-2023";
		
		selectDateByJS(driver, date, date_value);
	      
		
		
	}

}
