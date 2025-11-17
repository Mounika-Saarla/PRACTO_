//package com.setup;
//
//public class Reports {
//
//}
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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
 
public class Reports {
 
	public static void generateReport(WebDriver driver, ExtentTest test, Status status, String stepMessage) {
        if (status.equals(Status.PASS)) {
            test.log(status, stepMessage); //find in extendreports
        } else if (status.equals(Status.FAIL)) {
            // Take screenshot if status is FAIL
            String screenshotPath = captureScreenshot(driver, stepMessage);
            try {
                test.log(status, stepMessage,
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()); //to attach screenshot to extendreports
            } catch (WebDriverException e) {
                e.printStackTrace();
                test.log(status, stepMessage + " (Screenshot failed to attach)");
            }
        } else {
            test.log(status, stepMessage);
        }
    }

    public static String captureScreenshot(WebDriver driver, String fileLabel) {
    		//capture the screenshot and save in one location
        String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
        new File(folderPath).mkdirs(); //creating a folder
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss").format(new Date()); //to generate a unique name for screenshot and o/p is string
        String safeFileName = fileLabel.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timeStamp + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //capturing screenshot
        File destFile = new File(folderPath + safeFileName); //where we save our file
        try {
            FileUtils.copyFile(screenshot, destFile); //it will save the captured screenshot
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        //return "./screenshots/" + safeFileName; //here returning the folder with files
        return destFile.getAbsolutePath();
    }
}