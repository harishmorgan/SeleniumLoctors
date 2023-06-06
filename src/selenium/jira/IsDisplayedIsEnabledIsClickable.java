package selenium.jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsDisplayedIsEnabledIsClickable {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://duckduckgo.com/");
		
		// isDisplayed() is the method used to verify the presence of a web element within the web page. 
		//The method returns a “true” value if the specified web element is present on the web page 
		//and a “false” value if the web element is not present on the web page.
		
		 WebElement searchBox = driver.findElement(By.className("searchbox_input__bEGm3"));
	        if (searchBox.isDisplayed()) {
	            System.out.println("Search Box is visible. Return: " + searchBox.isDisplayed());
	        } else {
	            System.out.println("Search Box is not visible. Return: " + searchBox.isDisplayed());
	        }
	        
	     // Verify that the “Search” Box is enabled
	        if (searchBox.isEnabled()) {
	            System.out.println("Search Box is enabled. Return: " + searchBox.isEnabled());
	            searchBox.sendKeys("Selenium");
	        } else {
	            System.out.println("Search Box is not enabled. Return: " + searchBox.isEnabled());
	        }
	 
	        System.out.println("Successful Execution of Test.");
	        
		
	}

}
