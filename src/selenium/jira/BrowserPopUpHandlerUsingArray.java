package selenium.jira;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserPopUpHandlerUsingArray {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/popup.php");

		driver.findElement(By.linkText("Click Here")).click();

		Set<String> handles = driver.getWindowHandles();

		ArrayList<String> ar = new ArrayList<String>(handles);

		System.out.println(ar);

		String parentWindowID = ar.get(0);

		System.out.println(parentWindowID);

		String childWindowID = ar.get(1);

		System.out.println(childWindowID);

		driver.switchTo().window(childWindowID);

		System.out.println("child window title is " + driver.getTitle());

		driver.close();

		driver.switchTo().window(parentWindowID);

		System.out.println("parent window title is " + driver.getTitle());
	}

}
