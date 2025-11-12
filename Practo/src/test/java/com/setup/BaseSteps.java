
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


//----------------------scenario-outline-------------------


package com.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSteps {
    private static WebDriver driver;

    public static void initializeDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


