package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils{
	private static final Logger logger = LogManager.getLogger(Utils.class);
	
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
	
	public static void switchToWindowWithWebElement(WebDriver driver, By element, Set<String> windowHandles) {
		for (String windowHanlde : windowHandles) {
			driver.switchTo().window(windowHanlde);
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
				wait.until(ExpectedConditions.presenceOfElementLocated(element));
				return;
			}
			catch (TimeoutException e) {
				logger.info("Element not in this window: " + windowHanlde);
			}
			catch (NoSuchElementException e) {
				logger.info("Element not in this window: " + windowHanlde);
			}
		}
	}
}
