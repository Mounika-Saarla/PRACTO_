 package com.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"com.stepDefinitionTestNG"},
        		//tags = "@Search",
        		//tags = "@Spz",
        		tags = "@Order",
       // tags="@Meds",
//        		tags="@India",
//        		tags="@Read",
        plugin = {
                "pretty",
                "html:target/Reports/CucumberReport.html",
                "json:target/Reports/CucumberReport.json"
        }
       
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
}