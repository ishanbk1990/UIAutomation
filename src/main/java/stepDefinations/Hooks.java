package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks{
	
	@Before
	public void setUp() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		StepDefinations.driver = driver;
	}
	
	@After
	public void tearDown() {
		StepDefinations.driver.quit();
	}

}
