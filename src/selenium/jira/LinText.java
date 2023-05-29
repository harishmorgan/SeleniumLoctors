package selenium.jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinText {
	
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
		
		driver.findElement(By.linkText("SIGN-ON")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("REGISTER")).click();
		
	  String title = driver.getTitle();
	  
	  System.out.println(title);
	  
	  String finalTiltle = "Register: Mercury Tours";
	  
	  if(title.equals(finalTiltle)) {
		  System.out.println("we have been navigated to register link");
	  } else {
		  System.out.println("Test case Failed");
	  }
		

	}

}
