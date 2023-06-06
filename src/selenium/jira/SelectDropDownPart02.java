package selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownPart02 {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		// selectByIndex
				Thread.sleep(5000);
				WebElement day = driver.findElement(By.id("day"));
				WebElement month = driver.findElement(By.id("month"));
				WebElement year = driver.findElement(By.id("year"));
				
				Select select = new Select(day);
				select.selectByIndex(10);
				
				//to check whether we have multiple values selection in drop down
				
				System.out.println(select.isMultiple());
				
				//list of webElements
				List<WebElement> listDays = select.getOptions();
				int totalDays = listDays.size()-1;
				System.out.println("total days are: "+totalDays);
				
				//how to print all the values in drop down
				
				for(int i =0; i<listDays.size();i++) {
					String daysValue = listDays.get(i).getText();
					System.out.println(daysValue);
					
					if(daysValue.equals("30")) {
						listDays.get(i).click();
						break;
					}
					
				}
	}

}
