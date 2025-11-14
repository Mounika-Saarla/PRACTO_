package com.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import com.setup.BaseSteps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Features/Profile.feature",
    glue = {"com.stepDefinitionTestNG"},
   // tags="@sidesearch",
     // Runs both Scenario 1 (@search) and Scenario 2 (@booking)
    dryRun = false,		//chane this temporarily
    plugin = {
        "pretty", "html:reports/cucumber-reports.html",
        "html:target/cucumber-report.html",
		   "json:reports/join-report.json",
		   "junit:reports/junit-report.xml"
//        "html:target/cucumber-reports/cucumber-html-report.html",
//        "json:target/cucumber-reports/CucumberTestReport.json"
        
    }
)

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
    // No custom code needed unless you want to override TestNG behavior

}
