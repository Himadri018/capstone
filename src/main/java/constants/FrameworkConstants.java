package constants;

import base.ConfigLoader;

public class FrameworkConstants {
	public static final String BASE_URL;
    public static final String BROWSER;
    public static final String REPORTS_DIR = "reports";
    public static final String SCREENSHOT_DIR = "screenshots";
    public static final String TESTDATA_EXCEL = "resources/testdata/DataSource.xlsx";

    static {
        try {
            BASE_URL = ConfigLoader.getProperty("baseUrl");
            BROWSER = ConfigLoader.getProperty("browser");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config values", e);
        }
    }
}
