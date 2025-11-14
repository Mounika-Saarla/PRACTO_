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
//    private static Properties properties = new Properties();
//
//    static {
//        try {
//            String path = System.getProperty("user.dir") + "/src/test/resources/Properties/profile.properties";
//            FileInputStream fis = new FileInputStream(path);
//            properties.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to load properties file at path: " +
//                    System.getProperty("user.dir") + "/src/test/resources/Properties/profile.properties");
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



//--------------Sceraio-outline:2------------------------------------


package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties = new Properties();

    static {
        try {
            // Load properties file from resources
            FileInputStream fis = new FileInputStream("src/test/resources/profile.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load profile.properties file.");
        }
    }

    /**
     * Get property value by key
     * @param key property key
     * @return property value
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property key not found: " + key);
        }
        return value;
    }
}