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

package com.parameters;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties props = new Properties();

    static {
        try {
            // If file is inside Properties folder
            InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream("Properties/profile.properties");
            if (input == null) {
                throw new RuntimeException("profile.properties file not found in Properties folder under resources");
            }
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
