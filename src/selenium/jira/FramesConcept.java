package selenium.jira;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesConcept {

	public static void main(String[] args) {
		
		// How to Handle Frames in Selenium WebDriver
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//To Find Number of Frames in an application
		
	List<WebElement>FramesInApp = driver.findElements(By.tagName("iframe"));
	
	System.out.println("Number of Frames available in an current webpage are: "+FramesInApp.size());
	
	//To Read Each Frame we can use advanced For loop
	
	for(WebElement e : FramesInApp) {
		System.out.println(e.getAttribute("name"));
	}

	//we need to click on org.openqa.selenium
	//so first we need to switch on to frame
	
	driver.switchTo().frame("packageListFrame");
	
	driver.findElement(By.linkText("org.openqa.selenium")).click();
	
	}

}
