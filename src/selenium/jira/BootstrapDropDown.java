package selenium.jira;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropDown {

	public static void main(String[] args) {
		//How to handle Bootstrap DropDown in Selenium :
/*
• How to handle different styles of bootstrap down
• Click on the given dropdown
• Get all the tags while are available under "li" tag
• Get the text of each "li//a" OR "div//a"
• Match the text and click on it */
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
		System.out.println(list.size());

		//To print there text and select only defined text
		
		for(int i =0; i<list.size();i++) {
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().contains("Java")) {
				list.get(i).click();
				break;
			}
		}
		
		//To select all the checkboxes
		
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i).getText());
				list.get(i).click();
			}
	}

}
