package com.runner;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features/Profile.feature",
	    glue = {"com.stepDefinitionTestNG"},
        plugin = {"pretty:reports/PreetyReports.html", 
        		"html:target/cucumber-report.html",
        		"html:reports/HTMLReports.html",
    			"json:reports/json-report.json",
    			"junit:reports/junit_report.xml"}
 
	)
public class TestRunnerJunit {

}