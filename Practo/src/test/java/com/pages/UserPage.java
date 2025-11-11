package com.pages;
 
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;
 
public class UserPage {

	private static WebDriver driver;
    private static WebDriverWait wait;

    static ExtentTest test;

    private static By LabTests=By.xpath("//div[text()='Lab Tests']");
	private static By LipidTests=By.xpath("//a[text()='Lipid Profile']");

	public UserPage(WebDriver driver, ExtentTest test) 

	{
		this.driver=driver;
		this.test=test;	
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public static boolean verifyLabTests()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LabTests));
            Reports.generateReport(driver, test, Status.PASS, "LabTests Functionality is displayed");
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "LabTests Functionality is not displayed");
        }
        return actResult;
	}
	public static boolean click_Lab_Tests()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LabTests));
            Reports.generateReport(driver, test, Status.PASS, "LabTests path is found");
            driver.findElement(LabTests).click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "LabTests path is not found");
        }
        return actResult;
	}
	public boolean click_Lipid_Tests()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LipidTests));
            Reports.generateReport(driver, test, Status.PASS, "LipidTests Page is opened");
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "LipidTests Page is not opened");
        }
        return actResult;
	}
}

 