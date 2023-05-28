package selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E://New folder//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//String baseUrl = "https://demo.guru99.com/test/newtours/";
		 String baseUrl = "https://www.youtube.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // clears the history cache
		WebElement username = driver.findElement(By.name("userName"));
		username.sendKeys("Test123");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Test123");
		
		//formatting code cntrl+shift+F
		
		

	}

}
