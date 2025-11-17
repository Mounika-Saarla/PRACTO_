package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/com/features/PractoProfile.feature",
	    glue = {"com.stepDefinitionTestNG"},
	    		 tags="@valid",
        plugin = {"pretty:reports/PrettyReports.html", 
        		"html:target/cucumber-report.html",
        		"html:reports/HTMLReports.html",
    			"json:reports/json-report.json",
    			"junit:reports/junit_report.xml"}

	)
 

public class TestRunnerJunit{
	
 
	
}
 
 