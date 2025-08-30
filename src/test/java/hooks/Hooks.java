package hooks;

import org.openqa.selenium.WebDriver;

import base.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {

    // Keep a single reference to the driver for this scenario run
    private static WebDriver d;

    @Before
    public void setUp() {
        // Opens the browser (Chrome/Firefox/Edge based on config) and
        // navigates to baseUrl if your DriverSetup.OpenBrowser() does that.
        d = DriverSetup.openBrowser();
        DriverSetup.goToBaseUrl();
    }

    @After
    public void tearDown(Scenario scenario) {
        // If a scenario fails, capture and attach a screenshot to Cucumber report
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.captureScreenshot(d, scenario.getName());
            if (screenshot != null) {
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        }

        // Quit browser at the end of each scenario
        DriverSetup.quitDriver();
        d = null;
    }

    // Utility getter if you need the driver in places where DI isn't used
    public static WebDriver getDriver() {
        return d;
    }
}
