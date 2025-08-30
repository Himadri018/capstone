package utils;

import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {
	public static Map<String, String> getLoginData(String key) {
		Map<String, String> m = new HashMap<>();
		if ("valid".equalsIgnoreCase(key)) {
		m.put("mobile", "9999999999"); 
		} else {
		m.put("mobile", "12345");
		}
		return m;
}
}