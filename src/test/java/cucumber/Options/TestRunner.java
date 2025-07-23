package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature", glue = {
				"stepDefinations" }, tags = "@TopDeal", 
				plugin = {"pretty",
				        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				        "json:target/jsonReports/cucumber-report.json"
						})
public class TestRunner {

}