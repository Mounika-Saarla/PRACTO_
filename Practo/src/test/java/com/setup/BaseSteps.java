
//---------------------Remove comments to execute scenario:1 and scenario:2

/*package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.parameters.PropertyReader;

public class BaseSteps {

	private static WebDriver driver;

	public static void initializeDriver() {
		String browser = PropertyReader.getProperty("browserName");
		if (browser.equalsIgnoreCase("chrome")) {
			// Correct path
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}


	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
		}

	}	}*/


//----------------------scenario:3-------------------


/*package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BaseSteps {

    private static WebDriver driver;

   
    public static void initializeDriver() {
        if (driver == null) {
            // Use WebDriverManager to avoid hardcoding chromedriver path
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            System.out.println("ChromeDriver initialized successfully");
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Browser closed successfully");
        }
    }
}*/


//----------------------------------Scenario-outline----------------------------

//
//package com.setup;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class BaseSteps {
//    private static WebDriver driver;
//
//    public static WebDriver getDriver() {
//        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//        return driver;
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//
//	public static void initializeDriver() {
//		if (driver == null) {
//            // Use WebDriverManager to avoid hardcoding chromedriver path
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            System.out.println("ChromeDriver initialized successfully");
//        }
//		
//	}
//}

