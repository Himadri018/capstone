package hooks;

import org.openqa.selenium.WebDriver;

import base.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtil;

public class Hooks {
    private static WebDriver d;

    @Before
    public void setUp() {
        d = DriverSetup.openBrowser();
        DriverSetup.goToBaseUrl();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.captureScreenshot(d, scenario.getName());
            if (screenshot != null) {
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        }
        DriverSetup.quitDriver();
        d = null;
    }
    public static WebDriver getDriver() {
        return d;
    }
}
