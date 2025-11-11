package com.stepDefinitionTestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.setup.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BaseSteps {

    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        if (extentReports == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(spark);
        }

        ExtentTest test = extentReports.createTest(scenario.getName());
        extentTest.set(test);

        initializeDriver(); // From BaseSteps
        navigateTo("homepage.url"); // From BaseSteps

        extentTest.get().info("Browser launched and navigated to: " + prop.getProperty("homepage.url"));
    }

    @After
    public void afterScenario(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failure Screenshot");

                String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                extentTest.get().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot");

                extentTest.get().fail("Scenario failed: " + scenario.getName());
            } else {
                extentTest.get().pass("Scenario passed: " + scenario.getName());
            }
        } catch (Exception e) {
            extentTest.get().warning("Error during afterScenario: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
            extentReports.flush();
        }
    }
}