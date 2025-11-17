package com.setup;


import java.io.File;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static void generateReport(WebDriver driver, ExtentTest test, Status status, String stepMessage) 

	{

		if (status.equals(Status.PASS)) 

		{

			test.log(status, stepMessage);                 // it will find in extent report

		} 

		else if (status.equals(Status.FAIL))

		{

			// Take screenshot if status is FAIL

			String screenshotPath = captureScreenshot(driver, stepMessage);  // if test case fails it takes screenshot

			try 

			{

				test.log(status, stepMessage, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); // to attach screenshot to extent report

			} 

			catch (WebDriverException e) 

			{

				e.printStackTrace();

				test.log(status, stepMessage + " (Screenshot failed to attach)");

			}

		} 

		else 

		{

			test.log(status, stepMessage);

		}

	}


	public static String captureScreenshot(WebDriver driver, String fileLabel) 

	{

		String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";  // capture the screenshot and save in one location

		new File(folderPath).mkdirs();            // creating a folder

		String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss").format(new Date());   //To generate a unique name for Screenshot //o/p is string

		String safeFileName = fileLabel.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timeStamp + ".png"; //Characters will replaced by _

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);   //capturing screenshot

		File destFile = new File(folderPath + safeFileName);  //where we save our file

		try 

		{

			FileUtils.copyFile(screenshot, destFile);

			// it will save the captured screenshot

		} catch (Exception e) 

		{

			e.printStackTrace();

		}


		return "./screenshots/" + safeFileName;           //returning the screenshot folder with files
		

	}

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);

        }
               return extent;
           }
       }




}

 
