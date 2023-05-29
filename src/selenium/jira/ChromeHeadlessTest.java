package selenium.jira;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadlessTest {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\New folder\\chromedriver_win32\\chromedriver.exe");
		
		//mandatory 
		
		//1.chrome version should be greater than 59 on mac and greater than 60 on windows
		//2.window-size=1400,800
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("--headless");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		String baseUrl = "https://opensource-demo.orangehrmlive.com/";
		driver.get(baseUrl);
		
		System.out.println("Before Login title is----> : "+driver.getTitle());
		

		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();

		System.out.println("After Login title is----> : "+driver.getTitle());


	}

}
