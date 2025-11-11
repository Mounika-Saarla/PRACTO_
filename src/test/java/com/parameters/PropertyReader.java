package com.parameters;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String getProperty(String fileName, String key) throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/PropertiesFile/" + fileName);
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }
}











/*
import java.io.FileInputStream;

import java.util.Properties;

public class PropertyReader {
	
	public static Properties prop;
	
    public static void loadProperties() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/PropertiesFile/profile.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}*/
	/*
	public static Properties readProperty() {

		Properties prop = null;

		String fileName = ".\\src\\test\\resources\\PropertiesFile\\profile.properties";

		try {

			FileInputStream fis  = new FileInputStream(fileName);

			prop = new Properties();

			prop.load(fis);				

		}catch(FileNotFoundException e) {

			System.out.println("File name or file path is not correct");

		}catch(IOException e) {

			e.printStackTrace();

		}

		return prop;

	}*/

//}