package com.stepDefinitionTestNG;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.setup.BaseSteps;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.nio.file.Files;

public class Hooks {

    @Before
    public void startTest() throws Exception {
        BaseSteps.initDriver();
    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) BaseSteps.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
//        BaseSteps.quitDriver();
    }
}