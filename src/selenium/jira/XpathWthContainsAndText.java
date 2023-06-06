package selenium.jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathWthContainsAndText {

	public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.chrome.driver", "E://New folder//chromedriver_win32//chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		WebDriverManager.chromedriver().setup();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.chromedriver().driverVersion("113.0.5672.127").setup();
		
		//
		//1. //a[text()='Features']
		//2. //a[contains(text(),'Features')] --recommended
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.currentTimeMillis();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    driver.findElement(By.xpath("//*[contains(text(),'REGISTER')]")).click();  
	    
	    Thread.sleep(4000);
	  
	  String element =driver.findElement(By.xpath("//*[contains(text(),'SIGN-ON')]")).getText();
		
	  System.out.println(element);
	

		

	}

}
