package selenium.jira;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void checkBrokenLinks(String UrlLink) {
try {
		URL url = new URL(UrlLink);
		HttpURLConnection httpurlConnection = (HttpURLConnection) url.openConnection();

		httpurlConnection.setConnectTimeout(5000);
		httpurlConnection.connect();
		
		if(httpurlConnection.getResponseCode() >=400) {
			System.out.println(UrlLink+" ---> "+httpurlConnection.getResponseMessage()+ "is a broken link");
		} else {
			System.out.println(UrlLink+" ---> "+httpurlConnection.getResponseMessage());
		}
}
		catch(Exception e) {
	
}
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		Thread.sleep(3000);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Number of links are: " + links.size());
      
		//To iterate each and every string
		List<String> urlList = new ArrayList<String>();

		for (WebElement e : links) {
			String attUrl = e.getAttribute("href");
			urlList.add(attUrl);
			//checkBrokenLinks(attUrl);
		}
		
		long startTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(e->checkBrokenLinks(e));
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken is: " +(endTime-startTime));
		driver.quit();
	}

}
