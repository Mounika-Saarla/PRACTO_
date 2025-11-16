
//package com.stepDefinitionTestNG;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.BeforeAll;
//import io.cucumber.java.Scenario;
//
//public class Hooks {
//	
//	public static ExtentSparkReporter spark;
//	public static ExtentReports extReports; //what to track on report (tester name,data etc...,)
//	public static ExtentTest test;
//	@BeforeAll                                  //before feature starts it should run
//	public static void beforeAll() {
//		spark = new ExtentSparkReporter("src\\test\\resources\\ExtentReportFile\\ExtentReport.html");
//		extReports = new ExtentReports();
//		extReports.attachReporter(spark); 
//	}
//
//    @Before
//    public void setUp(Scenario scenario) {
//    	test = extReports.createTest(scenario.getName());
//        if (BaseSteps.driver == null) {
//        }
//    }
//
//    @After
//    public void tearDown() {
//        if (BaseSteps.driver != null) {
//            BaseSteps.driver.quit();
//        }
//    }
//}

package com.stepDefinitionTestNG;
import com.setup.BaseSteps;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
 
public class Hooks extends BaseSteps{
	public static ExtentSparkReporter spark;	//take care of color, GUI
    public static ExtentReports extReports;		//take care of ProjectName, Testers name, date...
    public static ExtentTest test;			//tracks test cases, descriptions
    @BeforeAll
    public static void beforeAll() {		//code triggers before feature file starts
        spark = new ExtentSparkReporter(".\\src\\test\\resources\\ExtentReportFile\\ExtentReport.html");	//for extent report
        extReports = new ExtentReports();
        extReports.attachReporter(spark);
    }
    @AfterAll
    public static void afterAll() {			//code runs after feature file ends 
        extReports.flush();		//to generate the report
    }
    @Before									//runs before every scenario
    public void beforeScenario(Scenario scenario) {
    		test = extReports.createTest(scenario.getName());	//on test track name of scenario appears
    		launchBrowser();			//Fresh browser launches
    }
    @After									//runs after every scenario
    public void afterScenario() {
        sleep(4000);
        driver.quit();
    }
}