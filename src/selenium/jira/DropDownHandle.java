package selenium.jira;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	// we can use Gemeric Function when there are multiple drop downs at place

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public static void doSelectElementByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}

	public static void doSelectElementByIndex(By locator, int value) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(value);
	}

	public static void doSelectElementByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	// combine the above methods into a single generic function

	public static void SelectFromDropdown(By locator, String type, String value) {
		Select select = new Select(getElement(locator));

		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibleText":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("select the correct crietria");
			break;
		}
	}

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// How to write a Generic Function (Code) to Handle DropDown in Selenium

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://formstone.it/components/dropdown/demo/");

		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,2346)");

		Thread.sleep(5000);

		By Country = By.xpath("//select[@name='demo_basic_2']");
		By JumpSites = By.xpath("//select[@name='demo_custom_2' and @id='demo_custom_2']");

//		Select select = new Select(driver.findElement(Country));
//		select.selectByVisibleText("Alaska");
//		
//		Select select1 = new Select(driver.findElement(JumpSites));
//		select1.selectByVisibleText("Four");

//		doSelectElementByVisibleText(Country,"Hawaii");
//		doSelectElementByVisibleText(JumpSites,"Five");
//		
//		doSelectElementByIndex(Country,3);
//		doSelectElementByIndex(JumpSites,3);
//		
//		doSelectElementByValue(Country, "CO");
//		doSelectElementByValue(JumpSites, "4");
		
		SelectFromDropdown(Country,"index","3");
		SelectFromDropdown(Country,"value","CO");
		SelectFromDropdown(Country,"visibleText","Hawaii");
		
		//In our real time project we will see the dyanmic changes so in order to handle it 
		//we will create one Enum called as DropDown and we can the methods from there 
		
		SelectFromDropdown(Country,DropDown.INDEX.toString(),"3");
		SelectFromDropdown(JumpSites,DropDown.INDEX.toString(),"3");
		
		Thread.sleep(4000);
		
		SelectFromDropdown(Country,DropDown.VISIBLETEXT.toString(),"Hawaii");
		SelectFromDropdown(JumpSites,DropDown.VISIBLETEXT.toString(),"Five");
		
		Thread.sleep(4000);
		
		SelectFromDropdown(Country,DropDown.VALUE.toString(),"CO");
		SelectFromDropdown(JumpSites,DropDown.VALUE.toString(),"3");
		
	}

}
