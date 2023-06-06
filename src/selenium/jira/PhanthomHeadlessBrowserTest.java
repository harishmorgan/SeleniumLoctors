package selenium.jira;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;



public class PhanthomHeadlessBrowserTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		// download url for phanthomjs is https://phantomjs.org/download.html
		//for jar file https://repo1.maven.org/maven2/com/codeborne/phantomjsdriver/1.4.4/phantomjsdriver-1.4.4.jar
		//PhanthomJsDriver Internally uses ghostDriver
		//ghostDriver -- It is used as JSON Protocol --HTTP Rest calls
		//Headless Browser Testing : No Browser is launched and testing will happened behind the scene
		//It is very fast
		//It directly Interacts with HTML,DOM
		
		System.setProperty("phantomjs.binary.path", "E:\\New folder\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");

		WebDriver driver = new PhantomJSDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String baseUrl ="https://demo.guru99.com/test/newtours/";
		driver.get(baseUrl);
		
		System.out.println(driver.getTitle());

	}

}
