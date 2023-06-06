package selenium.jira;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://www.onlinesbi.sbi"; 
		driver.get(baseUrl);		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Take screenshot and store it in a file format
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date dt = new Date();
		System.out.println(dt);
		SimpleDateFormat df = new SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		System.out.println(df.format(dt));
		FileUtils.copyFile(screenshotFile, new File("E:\\New folder\\17.11 pm Jun 05" + df.format(dt) +"SBIHomePage.png"));

	}

}
