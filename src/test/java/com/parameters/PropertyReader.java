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









