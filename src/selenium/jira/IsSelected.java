package selenium.jira;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsSelected {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/radio-button");

		List<WebElement> Radio_Options = driver.findElements(By.cssSelector(".custom-radio"));
		for (WebElement options : Radio_Options)
			System.out.println("Options :" + options.getText());

		// Create a boolean variable which will hold the value (True/False)
		boolean radio_value = false;

		// This statement will return True, in case of first Radio button is already selected
		radio_value = Radio_Options.get(0).isSelected();
		System.out.println("First Option is already selected :" + radio_value);

		// If button 1 is not selected, then select otherwise select button 2
		if (radio_value == false) {
			Radio_Options.get(0).click();
			System.out.println("Button Selected is :" + Radio_Options.get(0).getText());
		} else {
			Radio_Options.get(1).click();
			System.out.println("Button Selected is :" + Radio_Options.get(1).getText());
		}

		// close the web browser
		driver.close();
	}

}
