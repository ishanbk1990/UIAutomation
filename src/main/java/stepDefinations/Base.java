package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	private static WebDriver driver;
	
	public void initialiseDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
