package selenium.jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialLinkText {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\New folder\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String baseUrl ="https://demo.guru99.com/test/newtours/";
		driver.get(baseUrl);
		
		driver.findElement(By.partialLinkText("SIGN")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("REGI")).click();
		
		driver.findElement(By.partialLinkText("Insu")).click();
		
	  String title = driver.getTitle();
	  
	  System.out.println(title);
	  
	  String finalTiltle = "Insurance Broker System - Login";
	  
	  if(title.equals(finalTiltle)) {
		  System.out.println("we have been navigated to Insurance Broker link");
	  } else {
		  System.out.println("Test case Failed");
	  }
	}
}

