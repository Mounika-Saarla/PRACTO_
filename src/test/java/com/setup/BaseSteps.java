package com.setup;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.parameters.PropertyReader;

public class BaseSteps {
    public static WebDriver driver;
    public BaseSteps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void initDriver() throws Exception {
        String browser = PropertyReader.getProperty("profile.properties", "browser");
        String url = PropertyReader.getProperty("profile.properties", "appURL");

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            // ✅ Block location popup
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.geolocation", 2); // 1=Allow, 2=Block
            options.setExperimentalOption("prefs", prefs);

            // ✅ Disable notifications
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.get(url);

        // ✅ Assert page loaded
        Assert.assertTrue(driver.getCurrentUrl().contains("practo.com"), "Failed to launch Practo");
    }
	public static WebDriver getDriver() throws Exception {
		// TODO Auto-generated method stub
//		return null;

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            initDriver();
            driver.manage().window().maximize();
        }
        return driver;

	}
}



//    @After
//    public void tearDown() {
//        driver.quit();
//    }*/


