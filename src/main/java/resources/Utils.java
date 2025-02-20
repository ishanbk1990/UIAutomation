package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utils {

	public static String getGlobalValue(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Admin\\eclipse-workspace\\uiAutomation\\src\\test\\resources\\global.properties");
			prop.load(fis);
			return prop.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
