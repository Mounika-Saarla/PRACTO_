package com.parameters;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
public class PropertyReader {
    private static Properties prop = new Properties();
 
    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/com/Properties/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}