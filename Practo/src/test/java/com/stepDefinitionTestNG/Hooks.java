package com.stepDefinitionTestNG;
 
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
 
public class Hooks {
 
    @Before
    public void setup() {
        System.out.println(">>> Starting Browser <<<");
        BaseSteps.launchBrowser();
    }
 
    @After
    public void tearDown() {
        System.out.println(">>> Closing Browser <<<");
        if (BaseSteps.driver != null) {
            BaseSteps.driver.quit();
        }
    }
}
 