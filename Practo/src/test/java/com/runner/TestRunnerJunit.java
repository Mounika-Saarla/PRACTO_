package com.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"com.stepDefinitionTestNG"},
        plugin = {"pretty:target/PrettyReports.html", 
        		"html:target/cucumber-report.html",
        		"pretty","html:reports/HTMLReports.html",
    			"json:reports/json-report.json",
    			"junit:reports/junit_report.xml"}
		//tags = "@secondScenario"
		
		
		)
public class TestRunnerJunit {

}