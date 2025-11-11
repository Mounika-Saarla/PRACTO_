package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"com.stepDefinitionTestNG", "com.pages"},
//    tags = "@search or @booking", // Runs both Scenario 1 (@search) and Scenario 2 (@booking)
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-html-report.html",
        "json:target/cucumber-reports/CucumberTestReport.json"
    }
)


public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
    // No custom code needed unless you want to override TestNG behavior
}


//package com.runner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//    features = "src/test/resources/Features", // Path to your feature files
//    glue = {"com.stepDefinitionTestNG", "com.pages"}, // Step definitions and page objects
//    tags = "@search or @booking", // Runs both Scenario 1 (@search) and Scenario 2 (@booking)
//    plugin = {
//        "pretty",
//        "html:target/cucumber-reports/cucumber-html-report.html",
//        "json:target/cucumber-reports/CucumberTestReport.json",
//        "rerun:target/rerun.txt" // Optional: for failed scenarios rerun
//    },
//    monochrome = true // Makes console output readable
//)
//public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
//    // No custom code needed unless you want to override TestNG behavior
//}