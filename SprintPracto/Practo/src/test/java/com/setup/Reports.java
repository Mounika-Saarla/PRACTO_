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
        return "./screenshots/" + safeFileName;		//returning Ss folder with files
    }
}








//package com.setup;
// 
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
// 
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
// 
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
// 
//public class Reports {
// 
//	public static void generateReport(WebDriver driver, ExtentTest test, Status status, String stepMessage) {
//		//driver is used to open website
//		//ExtentTest is used to generate reports
//		//status is a class 
//		//test is a testcase 
//		//stepMessage is description(buttons is not visible etc...)
//		if (status.equals(Status.PASS)) 
//		{
//			test.log(status, stepMessage);   
//		} 
//		else if (status.equals(Status.FAIL)) 
//		{
//			// Take screenshot if status is FAIL
//			String screenshotPath = captureScreenshot(driver, stepMessage);//if testcase fails it will take SS
//			try 
//			{
//				test.log(status, stepMessage,
//						MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//			} 
//			catch (WebDriverException e) 
//			{
//				e.printStackTrace();
//				test.log(status, stepMessage + " (Screenshot failed to attach)");//attaching ss in extent reports
//			}
//		} 
//		else 
//		{
//			test.log(status, stepMessage);//to check log status...skipping test cases only(not pass and not fail test case)
//		}
//	}
// 
//	public static String captureScreenshot(WebDriver driver, String fileLabel) {
//		String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";//capture the SS with name and save it one loaction
//		new File(folderPath).mkdirs();//creating a floder
//		String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss").format(new Date());//to generate unique name for screenshot and capture the dd-MM-yyyy_HH_mm_ss //output is string
//		String safeFileName = fileLabel.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timeStamp + ".png";//chracters will replace with _underscore
//		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//ss is file form and saving into filr variable 
//		File destFile = new File(folderPath + safeFileName);//where we want to save in folder with file name
//		try 
//		{
//			FileUtils.copyFile(screenshot, destFile);//Fileutils is a class and (capture the SS,des folder)
//		} 
//		catch (IOException e) {
//			e.printStackTrace();
//		}
// 
//		return "./screenshots/" + safeFileName;//returning the SS folder with files
//	}
//}

 