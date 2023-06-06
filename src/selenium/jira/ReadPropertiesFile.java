package selenium.jira;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropertiesFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		// First we need to create an object for properties class
		
		Properties properties = new Properties();
		
		//we need to specify the properties file location
		
		FileInputStream fi= new FileInputStream("./properties//config.properties");
		
		//To load the properties File
		
		properties.load(fi);
		
		//to read data from Properties file
		
		String applnUrl=properties.getProperty("baseUrl");
		String browserName = properties.getProperty("browser");
		String userId=properties.getProperty("UserName");
		String userPwd=properties.getProperty("password");
		
		if(browserName.equals("chrome")) {
			
			//To Initialize the browser with application
			
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}else if(browserName.equals("FireFox")) {
			
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			
		} else if(browserName.equals("Edge")) {
			
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}
		
		driver.get(applnUrl);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//To enter user name and password 
		
		driver.findElement(By.name(properties.getProperty("userNameLocator_value"))).sendKeys(userId);
		
		driver.findElement(By.name(properties.getProperty("userPasswordLocator_value"))).sendKeys(userPwd);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(properties.getProperty("Login"))).click();
		
		//driver.close();
		

	}

}
