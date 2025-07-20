package resources;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}
	
	public static void quitDriver() {
		driver.get().quit();
		driver.remove();
	}
}
