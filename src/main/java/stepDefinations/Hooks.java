package stepDefinations;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import resources.TestContext;

public class Hooks{
	
	private final TestContext contex;
	
	public Hooks (TestContext contex) {
		this.contex=contex;
	}
	
	@Before
	public void setUp() {
		contex.initialiseDriver();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		 if (scenario.isFailed()) {
	            byte[] screenshot = ((TakesScreenshot) contex.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", "Failed Test Screenshot");
	        }
		contex.getDriver().quit();
	}

}
