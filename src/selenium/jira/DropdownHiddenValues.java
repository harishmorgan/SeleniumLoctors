package selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHiddenValues {

	public static void main(String[] args) throws InterruptedException {
		/* In order to handle Hidden elements in drop downs 
		=================================================================
				we need to click on which drop down we need to work 
				next we can inspect 
				In Inspect section we can find EventListners 
				Go to EventListeners and select blurr
				in blurr just remove all the 3 elements  */
		
		WebDriverManager.chromedriver().setup();
		
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://www.flipkart.com/");
		  
		  Thread.sleep(3000);

		  
		  driver.findElement(By.name("q")).sendKeys("mackbook");
		  Thread.sleep(3000);
		  Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//div[contains(@class,'lrtEPN') and text() ='book pro m2']"));
		 
		act.moveToElement(element).click();
		 
		  
		  

	}

}
