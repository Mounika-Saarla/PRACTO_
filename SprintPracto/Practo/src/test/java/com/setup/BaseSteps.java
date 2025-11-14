package com.setup;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.parameters.PropertyReader;

public class BaseSteps {
	public static WebDriver driver;
	 public static Properties prop;
   public static void launchBrowser() {
       Properties prop = PropertyReader.readProperty();
       String browser = prop.getProperty("browserName");//chrome will come

       if (browser.equalsIgnoreCase("chrome")) 
       {
       	System.setProperty("webdriver.chrome.driver", "C:\\training\\java\\seleniumGrid\\chromedriver.exe");
       	driver = new ChromeDriver();//chrome will launch

       } 
       else if (browser.equalsIgnoreCase("firefox")) 
       {
           driver = new FirefoxDriver();//firebox will launch
       } 
       else if (browser.equalsIgnoreCase("edge")) 
       {
       	System.setProperty("webdriver.edge.driver", "C:\\Users\\vangas\\OneDrive - Capgemini\\Desktop\\Selenium Grid\\msedgedriver.exe");
           driver = new EdgeDriver();//edge will launch
       } 
       else 
       {
           System.out.println("Invalid browser specified in config.properties");
           return;
       }
       String url=prop.getProperty("source.url");
       driver.get(url);
       driver.manage().window().maximize();
   }
   public static void sleep(int msec) {//handling waits 
       try 
       {
           Thread.sleep(msec);
       } 
       catch (InterruptedException e) 
       {
           e.printStackTrace();//what is happening in execution it pulls all data
       }
   }
}

