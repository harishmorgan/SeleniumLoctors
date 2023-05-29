package selenium.jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {
	
	public static 	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\New folder\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String baseUrl ="https://demo.guru99.com/test/newtours/";
		driver.get(baseUrl);
		
		driver.findElement(By.xpath("//input[@type='text'or @name='pharish']")).sendKeys("aDMIN123");
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@type='password']")).click();
//		
//		driver.findElement(By.xpath("//input[@value='Submit']")).click();
//		
//		//click on sign-on
//		
//		driver.findElement(By.xpath("//*[@href='login.php']")).click();
		
//		//multiple attributes
//		
//		driver.findElement(By.xpath("//input[@id='userName'][@name='text']")).click();
//		
//		//AND --00 -0 10-1 01-1 11-0
//		
//		driver.findElement(By.xpath("//input[@type='text'and @name='userName']")).sendKeys("aDMIN123");
		
		//or 00 -0 10-0 01-0 11-1
		
		driver.findElement(By.xpath("//input[@type='text'or @name='pharish']")).sendKeys("aDMIN123");
		
	 
	}
}
