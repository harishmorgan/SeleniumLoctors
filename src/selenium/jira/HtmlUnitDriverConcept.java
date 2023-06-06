package selenium.jira;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {
	

	public static void main(String[] args) throws InterruptedException {
		 
		//HtmlUnitDriver is not available before 3.0 version
		
		/*+Test execution using HtmlUnitDriver is very fast. Since it is the fastest implementation of Selenium WebDriver.
		 * +Being headless and fast, it is an ideal choice for web scrapping.
		 * +Its browser - htmlUnit is Java based. Hence, it is platform independent.
		 * +It also supports JavaScript execution through in-built Rhino javascript engine. */

		/*========================================================

		Limitations of HtmlUnitDriver:

		-Being non-GUI makes it difficult to create scripts and debug issues while scripting.
		-The Rhino javascript engine of HtmlUnitDriver makes it unsuitable to emulate other popular browser's javascript behaviour */
	
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		String baseUrl = "https://opensource-demo.orangehrmlive.com/";
		driver.get(baseUrl);
		
		System.out.println("Before Login title is----> : "+driver.getTitle());
		
		Thread.sleep(5000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();

		System.out.println("After Login title is----> : "+driver.getTitle());
	}

}
