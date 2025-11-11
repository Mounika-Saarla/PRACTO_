//package com.setup;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class BaseSteps {
//
//    private static WebDriver driver;
//
//    // Initialize WebDriver
//    public static void initializeDriver() {
//        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//    }
//
//    // Getter for WebDriver
//    public static WebDriver getDriver() {
//        return driver;
//    }
//
//    // Quit WebDriver
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}



//package com.setup;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BaseSteps {
//    private static WebDriver driver;
//
//    public static void initializeDriver() {
//        if (driver == null) {
//        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\dyamaa\\SpritPracto\\Practo\\Drivers\\chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//    }
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}



//package com.setup;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BaseSteps {
//    private static WebDriver driver;
//
//    public static void initializeDriver() {
//        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver", 
//                "C:\\Users\\dyamaa\\SpritPracto\\Practo\\Drivers\\chromedriver.exe"); 
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//    }
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
//
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}

//
//package com.setup;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BaseSteps {
//    private static WebDriver driver;
//
//    // Initialize WebDriver
//    public static void initializeDriver() {
//        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver",
//                "C:\\Users\\dyamaa\\SpritPracto\\Practo\\Drivers\\chromedriver.exe"); // Update path if needed
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
//    }
//
//    // Get WebDriver instance
//    public static WebDriver getDriver() {
//        return driver;
//    }
//
//    // Quit WebDriver
//    public static void quitDriver() {
//        if (driver != null) {
//            driver.quit();
//            driver = null;
//        }
//    }
//}

package com.setup;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BaseSteps {
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;
 
    // Load properties from profile.properties
    public BaseSteps() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/Properties/profile.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load profile.properties file!", e);
        }
    }
 
    // Initialize WebDriver based on browserName from properties
    public void initializeDriver() {
        String browserName = prop.getProperty("browserName");
        if (browserName == null || browserName.isEmpty()) {
            throw new RuntimeException("Browser name is missing in profile.properties!");
        }
 
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browserName);
        }
 
        driver.manage().window().maximize();
 
        // Implicit wait from properties or default 15 seconds
        String waitTime = prop.getProperty("implicit.wait");
        int implicitWait = (waitTime != null && !waitTime.isEmpty()) ? Integer.parseInt(waitTime) : 15;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
 
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
 
    // Navigate to a URL from properties
    public void navigateTo(String urlKey) {
        String url = prop.getProperty(urlKey);
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("URL key not found in profile.properties: " + urlKey);
        }
        driver.get(url);
    }
 
    // Capture screenshot for reporting
    public static String takeScreenshot(String screenshotName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
        try {
            FileUtils.copyFile(srcFile, new File(destPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destPath;
    }
}