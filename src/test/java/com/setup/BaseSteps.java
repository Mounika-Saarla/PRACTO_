package com.setup;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.parameters.PropertyReader;

public class BaseSteps {
    public static WebDriver driver;

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





















	/*public static WebDriver driver;
	public static void launchBrowser() {
		Properties prop = PropertyReader.readProperty();
		String browser = prop.getProperty("browser");
 
        //chrome launches
		if (browser.equalsIgnoreCase("chrome")) 
		{
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\jakkul\\OneDrive - Capgemini\\Desktop\\SeleniumGrid\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();

			driver=new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
		} else
		{
			System.out.println("Invalid browser specified in config.properties");
			return;
		}
      String url=  prop.getProperty("app.url");
      driver.get(url);
		driver.manage().window().maximize();
 
	}
 
	public static void sleep(int msec) {
		try 
		{
			Thread.sleep(msec);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
 */
    /*public static WebDriver driver;

    @Before
    public void setUp() {
        String browser = PropertyReader.getProperty("browser");
        String url = PropertyReader.getProperty("app.url");

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }o*/


