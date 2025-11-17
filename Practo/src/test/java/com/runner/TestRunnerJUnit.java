
package com.runner;
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/com/feature",		
		glue = "com.stepDefinitionTestNG",
		tags="@lipidProfilePage",
	       plugin = {"pretty",
	    		   "pretty:reports/PrettyReports.html",
	    		   "html:Reports/cucumber-reports.html" , //report is generated in reports folder and the html file namwe will be cucumber-reports
	               "json:reports/json-report.json",
		        	"junit:reports/junit_report.xml"}
	       
		)
public class TestRunnerJUnit {
	
	
 
}