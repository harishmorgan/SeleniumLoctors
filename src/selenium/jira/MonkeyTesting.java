package selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MonkeyTesting {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://www.amazon.com/");
		  
		  Thread.sleep(3000);
		  
		List<WebElement>  links = driver.findElements(By.cssSelector("div.navFooterVerticalRow li a"));
		
		int footerCount = links.size();
		
		for(int i =0; i<footerCount; i++) {
			int randomIndex =(int) Math.floor(Math.random()+footerCount);
			System.out.println(randomIndex);
			
			WebElement e = links.get(randomIndex);
			System.out.println(e.getText());
			e.click();
			driver.navigate().back();
			Thread.sleep(5000);
			links = driver.findElements(By.cssSelector("div.navFooterVerticalRow li a"));
		}

	}

}
