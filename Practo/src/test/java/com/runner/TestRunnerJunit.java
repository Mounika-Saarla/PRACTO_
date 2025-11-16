package com.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"com.stepDefinitionTestNG"},
		plugin = {"pretty","html:target/JUnit-Cucumber-Report.html"}
		//tags = "@secondScenario"
		
		
		)
public class TestRunnerJunit {

}