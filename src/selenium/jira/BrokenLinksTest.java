package selenium.jira;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksTest {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		// **For checking the broken links, you will need to do the following steps.
/*
1. Collect all the links in the web page based on "a" and "img" tags.
2. Send HTTP request for the link and read HTTP response code.
3. Find out whether the link is valid or broken based on HTTP response code.
4. Repeat this for all the links captured. */
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://makemysushi.com/404?");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Collect all the links in the web page based on "a" and "img" tags.
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of full links and images are:"+links.size());
		
		List<WebElement>activeLinks = new ArrayList<WebElement>();
		
		//Iterate the links : exclude all the links/images that doesn't have proper attribute
		
		for(int i =0; i<links.size();i++) {
			
			System.out.println(links.get(i).getAttribute("href"));
			
			if(links.get(i).getAttribute("href")!=null && !(links.get(i).getAttribute("href").contains("javascript"))) {
				
				activeLinks.add(links.get(i));
			}
		}
		
		//get the size of activeLinks
		
		System.out.println("size of active links and imanges are:"+activeLinks.size());
		
		//3.check the href url with HTTP connection api
		
		for(int j =0; j<activeLinks.size();j++) {
		
			HttpURLConnection connection =	(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"---->"+response);
	}
	}

}
