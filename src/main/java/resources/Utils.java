package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinations.Base;

public class Utils extends Base {
	
	private Utils(){
		
	}

	public static String getGlobalValue(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Admin\\eclipse-workspace\\uiAutomation\\src\\test\\resources\\global.properties");
			prop.load(fis);
			return prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static boolean elementIsVisibleAndClickable(By locator, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch (TimeoutException e) {
			return false;
		}
		return true;
		
	}
	
	public static boolean elementIsVisible(By locator, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch (TimeoutException e) {
			return false;
		}
		return true;
		
	}
	
	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
}
