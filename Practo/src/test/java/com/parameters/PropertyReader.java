package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.setup.BaseSteps;

public class PropertyReader extends BaseSteps {
    private static Properties prop = new Properties();

    public static Properties readProperty() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/Properties/profile.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load profile.properties file.");
        }
        return prop;
    }


public static String getProperty(String key) {
        String value = prop.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in profile.properties");
        }
        return value;
    }


   
}