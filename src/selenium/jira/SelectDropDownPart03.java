package selenium.jira;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownPart03 {
	
	static WebDriver driver;
	
	
public static void selectValurFromeDropDown(String xpathVlaue,String value) {
		
	List<WebElement> months = driver.findElements(By.xpath(xpathVlaue));
	System.out.println(months.size());
	
	for(int i =0; i<months.size();i++) {
		String monthsValues = months.get(i).getText();
		System.out.println(monthsValues);
		
		if(monthsValues.equals(value)) {
			months.get(i).click();
			break;
		}
	}
		
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		// selectByIndex
		Thread.sleep(5000);
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

		List<WebElement> yearsList = driver.findElements(By.xpath("//select[@id='year']//option"));

		System.out.println(yearsList.size());

//		List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']//option"));
//
//		System.out.println(months.size());
//		
//		for(int i =0; i<months.size();i++) {
//			String monthsValue = months.get(i).getText();
//			System.out.println(monthsValue);
//			
//			if(monthsValue.equals("Jun")) {
//				months.get(i).click();
//				break;
//			}
//		}
		
		//using generic method
		
		String month_xpath = "//select[@id='month']//option";
		
		selectValurFromeDropDown(month_xpath,"May");
	}

}
