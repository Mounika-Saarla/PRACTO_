
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
        }
    }

    @After
    public void tearDown() {
        if (BaseSteps.driver != null) {
            BaseSteps.driver.quit();
        }
    }
}
//package com.stepDefinitionTestNG;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.parameters.PropertyReader;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//public class Hooks extends BaseSteps {
//
//    private static ExtentReports extentReports;
//
//    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
//
//    @Before
//
//    public void beforeScenario(Scenario scenario) {
//
//        // Initialize ExtentReports only once
//
//        if (extentReports == null) {
//
//            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
//
//            extentReports = new ExtentReports();
//
//            extentReports.attachReporter(spark);
//
//        }
//
//        // Create a new test for each scenario
//
//        ExtentTest test = extentReports.createTest(scenario.getName());
//
//        extentTest.set(test);
//
//        // Read browser name from properties
//
//        String browserName = PropertyReader.getProperty("browserName");
//
//        if (browserName == null || browserName.isEmpty()) {
//
//            throw new RuntimeException("Browser name is missing in config.properties!");
//
//        }
//
//        // Initialize WebDriver and navigate to URL
//
//        initializeBrowser(browserName);
//
//        driver.get(PropertyReader.getProperty("sourceUrl"));
//
//    }
//
//    @After
//
//    public void afterScenario(Scenario scenario) {
//
//        try {
//
//            if (scenario.isFailed()) {
//
//                // Capture screenshot as bytes for Cucumber report
//
//                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//
//                scenario.attach(screenshot, "image/png", "LabTestsNavigation");
//
//                // Capture screenshot as Base64 for Extent report
//
//                String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//
//                extentTest.get().addScreenCaptureFromBase64String(base64Screenshot, "LabTestsNavigation.png");
//
//                extentTest.get().fail("Scenario failed: " + scenario.getName());
//
//            } else {
//
//                extentTest.get().pass("Scenario passed: " + scenario.getName());
//
//            }
//
//        } catch (Exception e) {
//
//            extentTest.get().warning("Error during afterScenario: " + e.getMessage());
//
//        }
//
//        finally {
//
//            if (driver != null) {
//
//                driver.quit();
//
//            }
//
//            extentReports.flush();
//
//        }
//
//    }
//
//}
 