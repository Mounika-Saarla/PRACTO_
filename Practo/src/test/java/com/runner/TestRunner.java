//package com.runner;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import com.setup.BaseSteps;
//
//@CucumberOptions(
//        features = "src/test/resources/Features/Profile.feature",
//        glue = {"com.stepDefinitionTestNG"},
//        plugin = {
//                "pretty",
//                "html:target/cucumber-reports/cucumber.html",
//                "json:target/cucumber-reports/cucumber.json",
//                "rerun:target/rerun.txt" // For failed scenarios rerun
//        },
//        monochrome = true
//)
//public class TestRunner extends AbstractTestNGCucumberTests {
//
//}


package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
    features = "src/test/resources/feature", // Correct folder path
    glue = {"com.stepDefinitionTestNG"},     // Step definitions package
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
}

