package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/com/features/Login.feature",   // ✅ Path to .feature files
        glue = {"com.stepDefinitionTestNG"},                           // ✅ Package where step defs exist
        plugin = {"pretty", "html:target/cucumber-report.html",
        		"pretty","html:reports/HTMLReports.html",
    			"json:reports/json-report.json",
    			"junit:reports/junit_report.xml"},
        monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}
	
