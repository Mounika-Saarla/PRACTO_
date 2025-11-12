//////package com.stepDefinitionTestNG;
//////
//////import com.aventstack.extentreports.ExtentReports;
//////import com.aventstack.extentreports.ExtentTest;
//////import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//////import com.setup.BaseSteps;
//////
//////import io.cucumber.java.After;
//////import io.cucumber.java.AfterAll;
//////import io.cucumber.java.Before;
//////import io.cucumber.java.BeforeAll;
//////import io.cucumber.java.Scenario;
//////
//////public class Hooks extends BaseSteps{
//////	
//////	
//////	public static ExtentSparkReporter spark;                     // classes of extent reports what should be color of report& gui
//////    public static ExtentReports extReports;                      // what to track on report (tester name , date etc..,)
//////    public static ExtentTest test;     
//////    
//////    // It will track the test cases
//////    @BeforeAll                                                   // it will run the code before feature file starts
//////    public static void beforeAll()
//////    {
//////        spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");   //for extent report
//////        extReports = new ExtentReports();
//////        extReports.attachReporter(spark);
//////    }
//////    @AfterAll                                                     // after feature file ends this will run
//////    public static void afterAll()
//////    {
//////        extReports.flush();                                       // to generate extent report like commit method
//////    }
////////    @Before                                                        // before every scenario   
////////    public void beforeScenario(Scenario scenario)
////////    {
////////        test = extReports.createTest(scenario.getName());           // on the test track the name of scenario
////////        BaseSteps.launchBrowser();                                            //Fresh browser will launch
////////    }
//////
//////    @After                                                         // after every scenario
//////    public void afterScenario()
//////    {
////////        sleep(4000);
////////        driver.quit();
//////    }
//////
//////    @Before
//////    public void setUp() {
//////        if (BaseSteps.getDriver() == null) {
//////            BaseSteps.launchBrowser();
//////        }
//////    }
//////
////////    @After
////////    public void tearDown() {
////////        // Do NOT close browser after each scenario
////////        // Browser will be closed after all tests in TestRunner
////////    	if(BaseSteps.getDriver() != null) {		//change this thine to 21
////////    		BaseSteps.getDriver().quit();
////////    	}
//////    }
////package com.stepDefinitionTestNG;
////
////import io.cucumber.java.Before;
////import io.cucumber.java.After;
////import com.setup.BaseSteps;
////
////public class Hooks extends BaseSteps {
////
////
//////	 @Before
//////	    public void setUp() {
//////	        launchBrowser();  // Initialize driver
//////	    }
////	@Before
////	public void setUp() {
////	    BaseSteps.launchBrowser();
////	    userPage = new UserPage(BaseSteps.getWebDriver());
////	}
////
////	    @After
////	    public void tearDown() {
////	        closeBrowser();   // Quit driver
////	    }
////
////}
//
//package com.stepDefinitionTestNG;
//
//import com.pages.userpage;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class Hooks {
//	public static userpage page;
//
//	@Before
//	public void setUp() {
//		BaseSteps.launchBrowser();
//		page = new userpage(BaseSteps.getDriver());
//	}
//
//	@After
//	public void tearDown() {
//		BaseSteps.closeBrowser();
//	}
//}
