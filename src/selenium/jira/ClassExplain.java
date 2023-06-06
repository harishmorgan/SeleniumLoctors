package selenium.jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassExplain {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E://New folder//chromedriver_win32//chromedriver.exe");
		System.setProperty("webdriver.chrome.verboseLogging","true");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // clears the history cache
		
		WebElement userName = driver.findElement(By.className("oxd-input oxd-input--active"));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		userName.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.className("oxd-input oxd-input--active"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		password.sendKeys("admin123");
		
		WebElement login = driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login.click();
		
		

	}

}
