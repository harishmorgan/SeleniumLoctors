package selenium.jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtraLocators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(new ByAll(By.name("field"),By.id("twotabse")
				//,By.xpath("//*[@placeholder='Search Amazon']"))).sendKeys("textBooks");
		
		
		//driver.findElement(new ByIdOrName("nav-input nav-progressive-attribute")).sendKeys("textBooks");
		
		WebElement searchBox = driver.findElement(new ByChained(By.className("nav-fill"),By.xpath("//div[@class ='nav-search-field ']"),By.id("twotabsearchtextbox")));
		searchBox.sendKeys("movies");
		Thread.sleep(3000);
		searchBox.clear();
		
		
	}

}
