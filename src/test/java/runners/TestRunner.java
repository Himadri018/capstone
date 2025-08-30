package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/features",
		glue = {"stepDefinitions", "hooks"},
		plugin = {
				"pretty",
				"html:reports/cucumber-report.html"
				},
		monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
