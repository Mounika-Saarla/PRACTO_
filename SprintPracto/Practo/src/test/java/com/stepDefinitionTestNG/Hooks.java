
package com.stepDefinitionTestNG;

import com.setup.BaseSteps;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    @Before
    public void setUp() {
        if (BaseSteps.driver == null) {
            //BaseSteps.driver = new ChromeDriver();
            //BaseSteps.driver.manage().window().maximize();
        }
    }

    @After
    public void tearDown() {
        if (BaseSteps.driver != null) {
            BaseSteps.driver.quit();
        }
    }
}
