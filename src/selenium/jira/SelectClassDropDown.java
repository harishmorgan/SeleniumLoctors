package selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClassDropDown {

	public static void selectValurFromeDropDown(WebElement element,String value) {
		
		Select select = new Select(element);
		select.selectByVisibleText(value);
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//If we want to check with our test data so we can hardcode the value as 
		
		String date = "5/Sep/1993";
		String doarr[] = date.split("/");

		// selectByVisibleText
		Thread.sleep(5000);
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		
//		Select select = new Select(day);
//		select.selectByVisibleText("4");
//		Select select1 = new Select(month);
//		select1.selectByVisibleText("May");
//		Select select2 = new Select(year);
//		select2.selectByVisibleText("2022");
//		
		//let say there are 10 dropdowns for month date and year 
		
		//so in that case we can create one generic static method
		
//		selectValurFromeDropDown(day,"5");
//		selectValurFromeDropDown(month,"Sep");
//		selectValurFromeDropDown(year,"2023");
		
		selectValurFromeDropDown(day,doarr[0]);
		selectValurFromeDropDown(month,doarr[1]);
		selectValurFromeDropDown(year,doarr[2]);
		

	}

}
