package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"com.stepDefinitionTestNG"},
        plugin = {"pretty:target/PrettyReports.html", 
        		"html:target/cucumber-report.html",
        		"pretty","html:reports/HTMLReports.html",
    			"json:reports/json-report.json",
    			"junit:reports/junit_report.xml"},
        tags = "@NegativeScenario",
        		
       

        monochrome = false
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

   
}


