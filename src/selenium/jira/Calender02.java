package selenium.jira;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.utils.DateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender02 {

	static WebDriver driver;
	
	public static void main(String[] args) {

		// Steps to handle calendar in Selenium Webdriver:
		
		/*
		Step 1- Click on calendar

		Step 2- Get all td of tables using findElements method

		Step 3- using for loop get the text of all elements

		Step 4- using if else condition we will check the specific date

		Step 5- If the date is matched then click and break the loop.
		 */

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
        // click on date picker so that we can get the calendar in view 
		driver.findElement(By.id("datepicker")).click();
		
		
		// this will find all matching nodes in calendar		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		 // now we will iterate all values and will capture the text. We will select when date is 28
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
                        // once date is 28 then click and break
			if(date.equalsIgnoreCase("28"))
			{
				ele.click();
				break;
			}
			
		}
	 
	}

}
