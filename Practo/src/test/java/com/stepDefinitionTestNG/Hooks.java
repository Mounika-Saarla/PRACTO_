//package com.stepDefinitionTestNG;
// 
//import com.aventstack.extentreports.ExtentReports;
// 
//import com.aventstack.extentreports.ExtentTest;
////import com.aventstack.extentreports.gherkin.model.Scenario;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.setup.BaseSteps;
// 
//import io.cucumber.java.After;
//import io.cucumber.java.AfterAll;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeAll;
//import io.cucumber.java.Scenario;
// 
//public class Hooks extends BaseSteps {
// 
//	public static ExtentSparkReporter spark;                     // classes of extent reports what should be color of report& gui
//	public static ExtentReports extReports;                      // what to track on report (tester name , date etc..,)
//	public static ExtentTest test;                               // It will track the test cases
// 
//	@BeforeAll                                                   // it will run the code before feature file starts
//	public static void beforeAll() 
//	{
// 
//		spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");   //for extent report
//		extReports = new ExtentReports();
//		extReports.attachReporter(spark);
//	}
// 
//	@AfterAll                                                     // after feature file ends this will run
//	public static void afterAll() 
//	{
// 
//		extReports.flush();                                       // to generate extent report like commit method
//	}
// 
//	@Before                                                        // before every scenario   
//	public void beforeScenario(Scenario scenario) 
//	{
// 
//		test = extReports.createTest(scenario.getName());           // on the test track the name of scenario
//		launchBrowser();                                            //Fresh browser will launch
//	}
// 
// 
//	private void launchBrowser() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@After                                                         // after every scenario
//	public void afterScenario() 
//	{
// 
//		//        sleep(4000);
//		//        driver.quit();
////
//		if (driver != null) {
//			driver.quit(); // ✅ Close browser once after all scenarios
//		}
//
// 
// 
// 
//	}
 
 
