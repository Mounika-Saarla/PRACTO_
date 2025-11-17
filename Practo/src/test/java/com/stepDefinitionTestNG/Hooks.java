package com.stepDefinitionTestNG;
 
import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
 
	public static ExtentSparkReporter spark;                     
	public static ExtentReports extReports;                      
	public static ExtentTest test;                              
 
	@BeforeAll                                                   
	public static void beforeAll() 
	{
 		spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");   
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
	}
 
	@AfterAll                                                  
	public static void afterAll() 
	{
 
		extReports.flush();                                      
	}
 
	@Before                                                          
	public void beforeScenario(Scenario scenario) 
	{
 
		test = extReports.createTest(scenario.getName());    
		extReports.createTest(scenario.getName());
		launchBrowser();                                            
	}
 
 
	private void launchBrowser() {
		// TODO Auto-generated method stub
		
	}

	@After
	public void afterScenario(Scenario scenario) {
	    try {
	        if (scenario.isFailed() && driver != null) {
	            try {
	                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	                test.addScreenCaptureFromPath(screenshot.getAbsolutePath());
	            } catch (Exception e) {
	                System.out.println("Screenshot failed: " + e.getMessage());
	            }
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	
	    }
	    	finally {
	    	    try {
	    	        Thread.sleep(5000);
	    	    } catch (InterruptedException e) {
	    	        e.printStackTrace();
	    	    }
	    	    BaseSteps.quitDriver();
	    	}
	}
}
 
 
 
	
 
 
