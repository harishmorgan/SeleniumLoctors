package selenium.jira;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDown02 {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("dropdownMenuButton")).click();
		
		List<WebElement> dataList = driver.findElements(By.xpath("//div[(@class='dropdown-menu' and @aria-labelledby='dropdownMenuButton')]//a"));
		
		System.out.println(dataList.size());
		
		//To print there text and select only defined text
		
				for(int i =0; i<dataList.size();i++) {
					System.out.println(dataList.get(i).getText());
					
					if(dataList.get(i).getText().contains("Another action")) {
						dataList.get(i).click();
						break;
					}
				}
				
				//To select all the checkboxes
				
				for(int i = 0; i<dataList.size();i++) {
					System.out.println(dataList.get(i).getText());
					dataList.get(i).click();
					}
	}

}
