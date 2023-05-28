package selenium.jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IdExplain {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E://New folder//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.google.com/";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // clears the history cache
		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchBox.sendKeys("Test123");
		driver.close();

	}

}
