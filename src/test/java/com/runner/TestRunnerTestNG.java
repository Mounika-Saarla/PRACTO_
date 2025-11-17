package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = { "com.stepDefinitionTestNG" },
		// tags = "@Search",
		// tags = "@Spz",
		// tags = "@Order",
		// tags="@Meds",
		// tags="@Read",
		//tags = "@form",
		// tags="@Module2",
		plugin = { "pretty", "html:Reports/cucumber-reports.html",
				"html:reports/HTMLReports.html",
				"json:reports/json-report.json", 
				"junit:reports/junit_report.xml" }

)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

}