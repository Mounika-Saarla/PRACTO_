package com.runner;
 
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Features/Profile.feature", // Path to your .feature files
    glue = {"com.stepDefinitionTestNG"},      // Package containing step definitions
    plugin = {
        "pretty",                             // Prints Gherkin steps in console
        "html:target/cucumber-reports/cucumber-html-report.html", // HTML report
        "json:target/cucumber-reports/CucumberTestReport.json",
        "junit:reports/junit_report.xml"// JSON report
    }                          // Set true to check mapping without running
)
public class TestRunnerJunit {
    // No code needed here; annotations handle everything
}