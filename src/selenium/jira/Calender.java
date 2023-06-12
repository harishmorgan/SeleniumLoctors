package selenium.jira;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {

		// Steps to handle calendar in Selenium Webdriver:
		/*
		 * 1- Click on calendar 2- Get all td of tables using findElements method 3-
		 * using for loop get text of all elements 4- using if else condition we will
		 * check specific date 5- If date is matched then click and break the loop. 6-
		 * Handle NoSuchElementException in case of (31st day)
		 */

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/#date%E2%88%92range");

		 //identify and switch to frame
	      WebElement r = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	      driver.switchTo().frame(r);
	    
	      //identify element
	      WebElement e = driver.findElement(By.id("datepicker"));
	      e.click();
	      
	      //identify elements with td tag in list
	      List<WebElement> d =driver.findElements(By.xpath("//table/tbody/tr/td"));
	      //iterate list
	      for (int i = 0; i<d.size(); i++) {
	         //check expected data
	         String s = d.get(i).getText();
	         if (s.equals("22")) {
	            d.get(i).click();
	            break;
	         }
	      }
	    //get data selected
	      String m = e.getAttribute("value");
	      System.out.print("Date selected in calendar is: "+ m);
	      //close browser
	     
		
	}

}
