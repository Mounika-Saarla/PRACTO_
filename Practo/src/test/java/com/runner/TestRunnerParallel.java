//package com.runner;
//import org.testng.annotations.DataProvider;
//
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
// 
// 
//@CucumberOptions(
// 
//		dryRun=false,
//		        features = "src/test/resources/com/features/Login.feature",   // ✅ Path to .feature files
//		        glue = {"com.stepDefinitionTestNG"},                           // ✅ Package where step defs exist
////		        tags="@service",
//		        plugin = {"pretty:reports/PreetyReports.html",
//		        		"html:target/cucumber-report.html",
//		        		"html:reports/HTMLReports.html",
//		    			"json:reports/json-report.json",
//		    			"junit:reports/junit_report.xml"})
//public class TestRunnerParallel extends AbstractTestNGCucumberTests {
// 
//	
//	@DataProvider(parallel=true)  // parallel run
//	public Object[][] scenarios()
// 
//	{
// 
//		return super.scenarios();
// 
//	}
// 
//}
package com.runner;
 
//public class TestRunnerParallel {
//
//}
 
 
import org.testng.annotations.DataProvider;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
 
import io.cucumber.testng.CucumberOptions;
 
 
@CucumberOptions(
 
		dryRun=false,
 
		        features = "src/test/resources//Features/Profile.feature",   // ✅ Path to .feature files
 
		        glue = {"com.stepDefinitionTestNG"},                           // ✅ Package where step defs exist
 
 
 
		        plugin = {"pretty:reports/PreetyReports.html",
 
		        		"html:target/cucumber-report.html",
 
		        		"html:reports/HTMLReports.html",
 
		    			"json:reports/json-report.json",
 
		    			"junit:reports/junit_report.xml"})
 
public class TestRunnerParallel extends AbstractTestNGCucumberTests {
 
//
//	@DataProvider(parallel=true)  // parallel run
//
//	public Object[][] scenarios()
//
//	{
//
//		return super.scenarios();
//
//	}
 
}
 
 
 