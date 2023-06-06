package selenium.jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeV111X {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E://New folder//chromedriver_win32//chromedriver.exe");
		System.setProperty("webdriver.chrome.verboseLogging","true");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); // clears the history cache

	}

}
