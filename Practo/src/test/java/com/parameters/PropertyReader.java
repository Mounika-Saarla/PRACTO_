//package com.parameters;
// 
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
// 
//public class PropertyReader {
//	public static Properties readProperty() {
//		Properties prop = null;
//		String fileName = ".\\src\\test\\resources\\Properties\\profile.properties";
//		try {
//			FileInputStream fis = new FileInputStream(fileName);
//			prop = new Properties();
//			prop.load(fis);
//		} catch (FileNotFoundException e) {
//			System.out.println("File name or file path is not correct");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
// 
//		return prop;
// 
//	}
//}
// 


package com.parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertyReader {
    private static Properties prop = new Properties();
    static {
        try {
            FileInputStream fis = new FileInputStream("src\\test\\resources\\Properties\\profile.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}