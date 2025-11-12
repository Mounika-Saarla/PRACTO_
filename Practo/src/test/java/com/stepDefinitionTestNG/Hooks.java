



//package com.stepDefinitionTestNG;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.time.Duration;
//
//public class Hooks {
//
//	private static WebDriver driver;
//
//	@Before
//	public void setUp() {
//		// Set path to chromedriver if not in system PATH
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
//
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.manage().window().maximize();
//	}
//
//	@After
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
//
//	public static WebDriver getDriver() {
//		return driver;
//	}
//
//}