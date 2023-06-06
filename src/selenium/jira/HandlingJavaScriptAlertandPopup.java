package selenium.jira;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingJavaScriptAlertandPopup {

	public static void main(String[] args) throws InterruptedException {
		
		// Handling JavaScript Alert and Popup 
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("alertbox")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();//clicks on ok
		
		Thread.sleep(5000);
		
		driver.findElement(By.name("confirmalertbox")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.dismiss();//clicks on cancel
		
		driver.findElement(By.name("promptalertbox1234")).click();
		Alert alert2 = driver.switchTo().alert();
		String text = alert2.getText();
		
		if(text.equals("Do you like Automation ?")) {
			System.out.println("correct text validated");
		}else {
			System.out.println("Wrong text we got");
		}
		
		alert2.sendKeys("Yes");//Enters any data
		alert2.accept();
	}

}
