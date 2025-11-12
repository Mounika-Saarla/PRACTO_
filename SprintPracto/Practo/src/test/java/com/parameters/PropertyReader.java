package com.parameters;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/Properties/profile.properties");
            props.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}