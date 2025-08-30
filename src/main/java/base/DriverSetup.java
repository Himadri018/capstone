package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

    private static WebDriver d;

    public static WebDriver openBrowser() {
        if (d == null) {
            String browser = ConfigLoader.getProperty("browser", "chrome");

            switch (browser.toLowerCase()) {
                case "firefox":
                    d = new FirefoxDriver();
                    break;
                case "edge":
                    d = new EdgeDriver();
                    break;
                default:
                    d = new ChromeDriver();
            }

            d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            d.manage().window().maximize();
        }
        return d;
    }

    public static void goToBaseUrl() {
        String baseUrl = ConfigLoader.getProperty("baseUrl", "https://in.bookmyshow.com/");
        d.get(baseUrl);
    }

    public static WebDriver getDriver() { return d; }

    public static void quitDriver() {
        if (d != null) {
            d.quit();
            d = null;
        }
    }
}
