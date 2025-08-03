package cucumber.Options;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Feature", glue = "stepDefinations", plugin = { "pretty",
		"json:target/jsonReports/cucumber-report.json", "html:target/cucumber-html-report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, tags = "@regression")
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
	    return super.scenarios();
	}
}