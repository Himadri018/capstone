package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil{

    /**
     * Returns PNG bytes for Cucumber `scenario.attach(...)`
     * Also saves the screenshot under ./screenshots/<name>_<timestamp>.png
     */
    public static byte[] captureScreenshot(WebDriver d, String name) {
        try {
            byte[] bytes = ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);

            File src = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
            String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File dest = new File("screenshots" + File.separator + safe(name) + "_" + ts + ".png");
            dest.getParentFile().mkdirs();
            FileUtils.copyFile(src, dest);

            return bytes;
        } catch (Exception e) {

            return null;
        }
    }

    private static String safe(String s) {
        return s == null ? "screenshot" : s.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
    }
}
