package selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagExplain {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E://New folder//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // clears the history cache

		WebElement submits = driver.findElement(By.tagName("Submit"));

		Thread.sleep(5000);

		String myPresentUrl = driver.getCurrentUrl();

		String expected = "https://demo.guru99.com/test/newtours/login_sucess.php";

		if (myPresentUrl == expected) {
			System.out.println("Login Successfully");

		} else {

			System.out.println("Login failed");
		}
		
		driver.close();

	}

}
