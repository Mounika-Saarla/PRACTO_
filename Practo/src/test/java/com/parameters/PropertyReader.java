package com.parameters;

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
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}