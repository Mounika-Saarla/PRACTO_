package com.runner;



import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	 
			dryRun=false,
			        features = "src/test/resources/Features",
			        glue = {"com.stepDefinitionTestNG"},
			        plugin = {"pretty:target/PrettyReports.html", 
			        		"html:target/cucumber-report.html",
			        		"pretty","html:reports/HTMLReports.html",
			    			"json:reports/json-report.json",
			    			"junit:reports/junit_report.xml"}
					//tags = "@FirstScenario"
			)
public class TestRunnerParallel extends AbstractTestNGCucumberTests {
	 
		
		@DataProvider(parallel=true)  // parallel run
		public Object[][] scenarios()
		{
			return super.scenarios();
		}
	 
	}
	 
	 

