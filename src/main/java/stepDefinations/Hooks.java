package stepDefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base{
	
	@Before
	public void setUp() {
		setupLogger();
		initialiseDriver();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		 if (scenario.isFailed()) {
	            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", "Failed Test Screenshot");
	        }
		closeDriver();
	}

}
