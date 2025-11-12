//package com.stepDefinitionTestNG;
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class Hooks {
//    public static WebDriver driver;
//
//    @Before
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}

package com.stepDefinitionTestNG;

import com.setup.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp() {
        BaseSteps.initDriver();
    }

    @After
    public void tearDown() {
        BaseSteps.quitDriver();
    }
}