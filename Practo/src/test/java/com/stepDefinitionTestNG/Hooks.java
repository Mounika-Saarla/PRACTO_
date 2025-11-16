package com.stepDefinitionTestNG;
//
//import com.pages.userpage;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//public class Hooks {
//    public static userpage userPage;
//
//    @Before
//    public void beforeScenario(Scenario scenario) {
//        BaseSteps.launchBrowser();
//        userPage = new userpage(BaseSteps.getDriver());
//        System.out.println("Starting Scenario: " + scenario.getName());
//    }
//
//    @After
//    public void afterScenario() {
////        BaseSteps.closeBrowser();
//        System.out.println("Browser closed after scenario.");
//    }
//}
import org.openqa.selenium.WebDriver;

/*

import io.cucumber.java.After;

import io.cucumber.java.Before;

import io.cucumber.java.Scenario;

import com.setup.BaseSteps;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import java.io.File;

import java.nio.file.Files;

public class Hooks {

    @Before

    public void startTest() throws Exception {

        BaseSteps.initDriver();

    }

    @After

    public void endTest(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) BaseSteps.driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failed Screenshot");

        }

//        BaseSteps.quitDriver();

    }

}

package com.stepDefinitionTestNG;

 */

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//import com.aventstack.extentreports.gherkin.model.Scenario;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends BaseSteps {


	public static WebDriver driver;

	public Hooks() {

	//	super(null); // or handle driver initialization differently

	}	

	public Hooks(WebDriver driver) {

	//	super(driver);

		// TODO Auto-generated constructor stub

	}


	public static ExtentSparkReporter spark;

	public static ExtentReports extReports;

	public static ExtentTest test;

	@BeforeAll

	public static void beforeAll() {

		spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");

		extReports = new ExtentReports();

		extReports.attachReporter(spark);

	}

	@AfterAll

	public static void afterAll() {

		//after feature file ends this will run

		//to generate extent report like commit method

		extReports.flush();

	}

	@Before

	public void beforeScenario(Scenario scenario) throws Exception {

		System.out.println("hi...");//before every scenario

		//on the test track the name of the scenario

		//Fresh browser will launch

		test = extReports.createTest(scenario.getName());

		//       launchBrowser();

	//	initDriver();

	}

	@After

	public void afterScenario() throws InterruptedException  {

		//    	try {

		//			BaseSteps.tearDown();

		//		} catch (Exception e) {

		//			// TODO Auto-generated catch block

		//			e.printStackTrace();

		//		}

	//	BaseSteps.tearDown();


		//        sleep(4000);

		//        driver.quit();   //after every scenario

		//    	if (driver != null) {

		//			driver.quit(); // ✅ Close browser once after all scenarios

		//		}

	}


}


