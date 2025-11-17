package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/com/features/PractoProfile.feature",   // ✅ Path to .feature files
        glue = {"com.stepDefinitionTestNG"},                           // ✅ Package where step defs exist
//        tags="@negative",
//        		  tags="@valid",
//        		  tags="@overview",
        		  tags="@city",
//        tags="@hospital",
//        tags="@service",
//        tags="@negative",
        plugin = {"pretty:reports/PrettyReports.html", 
        		"html:target/cucumber-report.html",
        		"html:reports/HTMLReports.html",
    			"json:reports/json-report.json",
    			"junit:reports/junit_report.xml"},
        monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

	
}
	
