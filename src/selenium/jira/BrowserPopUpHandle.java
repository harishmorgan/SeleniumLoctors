package selenium.jira;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserPopUpHandle {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/popup.php");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Click Here")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		/*As the method name suggests windowHandles, that means there are multiple windows and to handle all these opened windows
		 *  we have to use this function.
		 *  It returns the Set of String.
		 *  Set stores the unique values and handle of all the windows that will be unique.
		 */

		//Set values are not stored based on the index, 
		//so to iterate over the set, we need to use the Iterator to get the handler values 
		//and this method will give you an iterator of string.
		
		Iterator<String> it = handles.iterator();
		
		String parentWindowID = it.next();
		System.out.println("parent window id is : " + parentWindowID);
		
		String childWindowID = it.next();
		System.out.println("child pop up window id is : " + childWindowID);
		
		driver.switchTo().window(childWindowID);
		
		System.out.println("child window title is " + driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		System.out.println("parent window title is " + driver.getTitle());

	}

}
