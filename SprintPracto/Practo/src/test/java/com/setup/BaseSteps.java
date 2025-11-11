package com.setup;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.parameters.PropertyReader;

public class BaseSteps {
    public static WebDriver driver;
    public static Properties prop;

    public static void launchBrowser() {
        prop = PropertyReader.readProperty();
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("appUrl");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Invalid browser specified: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void navigateToSearchClinicUrl() {
        String searchClinicUrl = prop.getProperty("SearchClinicUrl");
        if (searchClinicUrl == null) {
            throw new RuntimeException("SearchClinicUrl is missing in profile.properties");
        }
        driver.get(searchClinicUrl);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
 // ---------------- Scenario 2 Methods ----------------

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
