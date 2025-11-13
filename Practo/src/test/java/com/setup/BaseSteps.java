package com.setup;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.parameters.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
    public static WebDriver driver;
    public static Properties prop;

    public static void launchBrowser() {
    	WebDriverManager.chromedriver().setup();
        prop = PropertyReader.readProperty();
        String browser = prop.getProperty("browser");
        String appUrl = prop.getProperty("appUrl");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Invalid browser specified: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(appUrl); // Navigate here
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
//    public static void navigateToSearchClinicUrl() {
//        String searchClinicUrl = prop.getProperty("SearchClinicUrl");
//        if (searchClinicUrl == null) {
//            throw new RuntimeException("SearchClinicUrl is missing in profile.properties");
//        }
//        driver.get(searchClinicUrl);
//    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

	public static void sleep(int msec) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(msec);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
    


   