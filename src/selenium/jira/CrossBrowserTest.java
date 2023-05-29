package selenium.jira;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest {

	private static WebDriver driver;

	public static String title;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {

		// Chrome
		System.setProperty("webdriver.chrome.driver", "E:\\New folder\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String baseUrl = "https://www.amazon.in/";
		driver.get(baseUrl);

		// validation point

		title = driver.getTitle();

		if (title == baseUrl) {
			System.out.println("we are in correct Page");
		} else {
			System.out.println("We are not in correct page");
		}

		driver.quit();

		// FireFox

		System.setProperty("webdriver.gecko.driver", "E:\\New folder\\geckodriver-v0.33.0-win32\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://www.amazon.in/");

		driver.quit();

		// Edge

		System.setProperty("webdriver.edge.driver", "E:\\New folder\\edgedriver_win32\\msedgedriver.exe");

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://www.amazon.in/");

		driver.quit();

	}

}
