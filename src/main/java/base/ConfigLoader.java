package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
	private static Properties properties;

    private static void loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try (FileInputStream fis = new FileInputStream("config/config.properties")) {
                properties.load(fis);
            } catch (IOException e) {
                System.err.println("WARN: config/config.properties not found. Using defaults.");
                properties = new Properties(); // empty
            }
        }
    }

    public static String getProperty(String key, String defaultValue) {
        loadProperties();
        String v = properties.getProperty(key);
        if (v == null) return defaultValue;
        v = v.trim();
        return v.isEmpty() ? defaultValue : v;
    }

    public static String getProperty(String key) { // required
        String v = getProperty(key, "");
        if (v.isEmpty()) throw new RuntimeException("Missing key '"+key+"' in config.properties");
        return v;
    }
}
