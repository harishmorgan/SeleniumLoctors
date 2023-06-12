package selenium.jira;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {

public static void main(String[] args) {

	// Set the driver path
	WebDriverManager.chromedriver().setup();

	// start chrome
	WebDriver driver=new ChromeDriver();

 // start application
 driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

// click on date picker so that we can get the calendar in view
driver.findElement(By.id("datepicker")).click();

// this will find all matching nodes in calendar
List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

// Click on date 28 or any other date of your choice
driver.findElement(By.xpath("//a[text()='28']")).click();

}

}
