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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
 
public class Reports {
	public static void generateReport(WebDriver driver, ExtentTest test, Status status, String stepMessage) 
	{
        if (status.equals(Status.PASS)) 
        {
            test.log(status, stepMessage);		//it will find in Extent Report
            String screenshotPath = captureScreenshot(driver, stepMessage);
            try 
            {
                test.log(status, stepMessage,
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());	//to attach Ss to ExtentReport
            } 
            catch (WebDriverException e) 
            {
                e.printStackTrace();
                test.log(status, stepMessage + " (Screenshot failed to attach)");
            }
        } 
        else if (status.equals(Status.FAIL)) 
        {
            // Take screenshot if testCase is FAIL
            String screenshotPath = captureScreenshot(driver, stepMessage);
            try 
            {
                test.log(status, stepMessage,
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());	//to attach Ss to ExtentReport
            } 
            catch (WebDriverException e) 
            {
                e.printStackTrace();
                test.log(status, stepMessage + " (Screenshot failed to attach)");
            }
        } 
        else 
        {
            test.log(status, stepMessage);	//when something is skipped it will be here
        }
    } 
    public static String captureScreenshot(WebDriver driver, String fileLabel) 
    {
        String folderPath = System.getProperty("user.dir") + "/src/test/resources/ExtentReportFile/screenshots/";		//Screenshot location
        new File(folderPath).mkdirs();		//Creating a folder making directory
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss").format(new Date());		//To generate unique name for Ss and giving date frmt
        String safeFileName = fileLabel.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timeStamp + ".png";		//replacing char with '_'
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		//Capturing screenshot in FILE form
        File destFile = new File(folderPath + safeFileName);		//destination where we want to save screenshot
        try 
        {
            FileUtils.copyFile(screenshot, destFile);	//saving capturing screenshot in destination file
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
         return "./screenshots/" + safeFileName;		//returning Ss folder with files      for testNG we r genarating emailable,index.html,extentrepot 
    }                                                                                          // junit -> pretty report //failed test scenarios //negative serianrious
}




 