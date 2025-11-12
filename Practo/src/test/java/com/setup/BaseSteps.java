//package com.setup;
// 
//import java.util.Properties;
// 
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
// 
//import com.parameters.PropertyReader;
// 
//public class BaseSteps {
// 
//	public static WebDriver driver;
//	
//	public static void launchBrowser() {
//        Properties prop = PropertyReader.readProperty();
//        String browser = prop.getProperty("browserName"); //chrome will open
//        
// 
//        if (browser.equalsIgnoreCase("chrome")) {
//            
//            System.setProperty("webdriver.chrome.driver", "C:\\Training\\SeleniumGrid\\chromedriver.exe");
//            driver = new ChromeDriver();
//        }
//        else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        }
//        else if (browser.equalsIgnoreCase("edge"))
//        {
//         	//System.setProperty("webdriver.edge.driver", "C:\\Training\\SeleniumGrid\\msedgedriver.exe");
//            driver = new EdgeDriver();
//        }
//        else {
//            System.out.println("Invalid browser specified in config.properties");
//            return;
//        }
//        String url = prop.getProperty("sourceUrl");
//        driver.get(url);
//        //maximizw the screen
//        driver.manage().window().maximize();
//       
//    }
// 
//    public static void sleep(int msec) { //hardcoded implementation, handling waits
//        try
//        {
//            Thread.sleep(2000);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
// 
// 



package com.setup;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.parameters.PropertyReader;

public class BaseSteps {

    public static WebDriver driver;

    public static void launchBrowser() {
        Properties prop = PropertyReader.readProperty();

        if (prop == null) {
            throw new RuntimeException("Failed to load config.properties. PropertyReader returned null.");
        }

        String browser = prop.getProperty("browserName");
        String url = prop.getProperty("sourceUrl");

        if (browser == null || url == null) {
            throw new RuntimeException("Missing browserName or sourceUrl in config.properties");
        }

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Training\\SeleniumGrid\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Training\\SeleniumGrid\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "C:\\Training\\SeleniumGrid\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser specified: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}