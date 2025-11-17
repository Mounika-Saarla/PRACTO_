//---------------------property reader for normal scenarios-----------------------------

/*package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;

    static {
        try {
            String filePath = System.getProperty("user.dir") + "/src/test/resources/Properties/profile.properties";
            FileInputStream fis = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fis);
            System.out.println("Properties file loaded successfully from: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to load properties file.");
            e.printStackTrace();
            throw new RuntimeException("Properties file not found or unreadable.");
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        System.out.println("Property fetched: " + key + " = " + value);
        return value;
    }
}*/


//-------------------------propertyReader for scenario-outline-----------------------------

//package com.parameters;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class PropertyReader {
//
//    private static Properties properties = new Properties();
//
//    static {
//        try {
//            String path = System.getProperty("user.dir") + "/src/test/resources/Properties/profile.properties";
//            FileInputStream fis = new FileInputStream(path);
//            properties.load(fis);
//            System.out.println("Properties loaded successfully from: " + path);
//        } catch (IOException e) {
//            throw new RuntimeException("Failed to load properties file", e);
//        }
//    }
//
//    public static String getProperty(String key) {
//        String value = properties.getProperty(key);
//        if (value == null || value.isEmpty()) {
//            throw new RuntimeException("Property '" + key + "' not found in profile.properties");
//        }
//        return value;
//    }
//}



package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties = new Properties();

    static {
        try {
            String path = System.getProperty("user.dir") + "/src/test/resources/Properties/profile.properties";
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
            System.out.println("Properties loaded successfully from: " + path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("Property '" + key + "' not found in profile.properties");
        }
//        return value;
        return properties.getProperty(key);
        
    }

	public static Properties readProperty() {
		
		return properties;
	}
}
