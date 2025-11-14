package com.parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public static Properties readProperty() {
		Properties prop = null;
		String fileName = ".\\src\\test\\resources\\PropertiesFile\\Profile.Properties";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File name or file path is not correct");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	private static Properties config;
	 
    static {
        try {
            FileInputStream fis = new FileInputStream("src\\test\\resources\\PropertiesFile\\Profile.Properties");
            config = new Properties();
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage());
        }
    }
 
    public static String getProperty(String key) {
        return config.getProperty(key);
    }
}
