package stepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	private static WebDriver driver;
	private static Logger logger = Logger.getLogger("Automation Logs");
	
	public void initialiseDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	public void setupLogger(){
		LogManager.getLogManager().reset(); // Reset default configuration
        logger.setLevel(Level.ALL);

        // Console Handler
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);

        // File Handler
        FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler("application.log", true);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
	}
	
	public Logger getLogger() {
		return logger;
	}
}
