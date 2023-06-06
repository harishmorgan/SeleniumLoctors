package selenium.jira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class WebDriverManagerConcept {
	WebDriver driver;

	@BeforeAll
    static void setupAll(){
//    	WebDriverManager.chromedriver().setup();
//		WebDriverManager.firefoxdriver().setup();
//		WebDriverManager.edgedriver().setup();
//		WebDriverManager.operadriver().setup();
//		WebDriverManager.chromiumdriver().setup();
//		WebDriverManager.iedriver().setup();
		
		WebDriverManager.chromedriver().driverVersion("113.0.5672.127").setup();
    	
    }
	
	@BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }
	
	@AfterEach
    void teardown() {
        driver.quit();
    }

	public static void main(String[] args) {
	
		WebDriverManagerConcept launch = new WebDriverManagerConcept();
		setupAll();
		launch.setup();
		launch.teardown();

	}

}
