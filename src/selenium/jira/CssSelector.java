package selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v111.input.Input;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelector {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//scrpit for checking login functionality using css selectors in orange hrm
		
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.get("https://demo.guru99.com/test/newtours/");
		Thread.sleep(5000);
		
		//To enter username
		
		//driver.findElement(By.cssSelector(".oxd-input")).sendKeys("Admin");
		
		//driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		
		//To enter password
		
		//driver.findElement(By.cssSelector(".oxd-input--active")).sendKeys("admin123");
		
		//driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
		
		//Click on Login
		
		Thread.sleep(4000);
		
		//driver.findElement(By.cssSelector(".oxd-button ")).click();
		
		//driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//To validate text by clicking on demosites
		
	    driver.findElement(By.cssSelector("#site-name")).click();
	    
	    Thread.sleep(4000);
		
		String expectedResult = "Guru99 is totally new kind of learning experience.";
		
		boolean statement = driver.findElement(By.xpath("//div[@class ='g-content g-particle']//child::h3[contains(text(),'Guru99 is totally new kind of learning experience.')]")).isDisplayed();
		
		if(!statement) {
			return;
		} else {
		System.out.println(statement);
		}
		
		driver.findElement(By.cssSelector("input[name='search']")).sendKeys("testing materials");

	}

}
