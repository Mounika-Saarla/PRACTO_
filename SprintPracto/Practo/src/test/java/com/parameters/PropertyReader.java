package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.setup.BaseSteps;

public class PropertyReader extends BaseSteps{
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
        if (prop.isEmpty()) {
            readProperty();
        }
        String value = prop.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found in profile.properties");
        }
        return value;
    }
    
//----------scenario 2----------------
    public static void navigateToClinicDetailsUrl() {
        String clinicDetailsUrl = PropertyReader.getProperty("ClinicDetailsUrl");
        driver.get(clinicDetailsUrl);
    }

    public static void navigateToDoctorDetailsUrl() {
        String doctorDetailsUrl = PropertyReader.getProperty("DoctorDetailsUrl");
        driver.get(doctorDetailsUrl);
    }

    public static void navigateToAppointmentBookingUrl() {
        String appointmentBookingUrl = PropertyReader.getProperty("AppointmentBookingUrl");
        driver.get(appointmentBookingUrl);
    }
}
