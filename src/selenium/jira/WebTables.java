package selenium.jira;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		/* There are two ways of handling WebTable:

Method – 1:
• Iterate row and column and get the cell value. 
• Using for loop
• Get total rows and iterate table
• Put if(string matches) then select the respective checkbox
• Lengthy method

Method – 2:
• Using custom XPath 
• Using parent and preceding-sibling tags
• No need to write for loop
• No full iteration of table
• Single line statement
• More dynamic
• Efficient and fast */
		
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		
		//Get number of rows In table.
		 List<WebElement> Row_count = driver.findElements(By.xpath("//table[@id ='example']/tbody/tr"));
		System.out.println("Number Of Rows = "+Row_count.size());
		 
		//Get number of columns In table.
		 List<WebElement> Col_count = driver.findElements(By.xpath("//table[@id ='example']/tbody/tr/td"));
		 System.out.println("Number Of Columns = "+Col_count.size());
		 
		//divided xpath In two parts to pass Row_count and Col_count values.
		 String first_part = "//table[@id ='example']/tbody/tr[";
		 String second_part =  "]/td";
		 String third_part ="[@class='sorting_1']";
		 for(int i = 1; i<=10;i++) {
			 String name = driver.findElement(By.xpath(first_part+i+second_part+third_part)).getText();
			 System.out.println(name);
			 if(name.contains("Airi Satou")) {
				 driver.findElement(By.xpath("//table[@id ='example']/tbody/tr["+i+"]/td[@class='  select-checkbox']")).click();
			 }
		 }
		 
		 //Method-2
		 
		 //driver.findElement(By.xpath("//td[contains(text(),'Cedric Kelly')]/preceding-sibling::td[@class='  select-checkbox']")).click();
	}

}
