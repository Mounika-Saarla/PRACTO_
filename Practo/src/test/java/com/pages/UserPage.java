//package com.pages;
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.setup.Reports;
//
//public class UserPage {
//    private static WebDriver driver;
//    private static WebDriverWait wait;
//    static ExtentTest test;
//
//    private static By labTestsLink = By.cssSelector("a[href*='/tests']");
//    private static By popupContainer = By.xpath("/html/body/div[5]/div/div/div/div/div/div/div");
//    private static By cityInput = By.xpath("/html/body/div[5]/div/div/div/div/div/div/div/div[2]/div/input");
//    private static By applyButton = By.xpath("//button[contains(text(),'Apply')]");
//    private static By topBookedSection = By.xpath("//h2[contains(text(),'Top Booked Diagnostic Tests')]");
//    private static By addToCartButton = By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std");
//
//    public UserPage(WebDriver driver, ExtentTest test) {
//        UserPage.driver = driver;
//        UserPage.test = test;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    public static boolean clickLabTestsLink() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(labTestsLink)).click();
//            Reports.generateReport(driver, test, Status.PASS, "Lab Tests link clicked successfully");
//            return true;
//        } catch (TimeoutException e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Lab Tests link not clickable");
//            return false;
//        }
//    }
//
//    public static boolean selectCityFromPopup(String cityName) {
//        try {
//            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupContainer));
//            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput));
//            input.clear();
//            input.sendKeys(cityName);
//
//            wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
//            wait.until(ExpectedConditions.invisibilityOf(popup));
//
//            Reports.generateReport(driver, test, Status.PASS, "City selected: " + cityName);
//            return true;
//        } catch (TimeoutException e) {
//            Reports.generateReport(driver, test, Status.FAIL, "City selection failed");
//            return false;
//        }
//    }
//
//    public static boolean verifyCity(String expectedCity) {
//        try {
//            String actualCity = driver.findElement(By.id("locationInput")).getAttribute("value");
//            if (!actualCity.equalsIgnoreCase(expectedCity)) {
//                Reports.generateReport(driver, test, Status.FAIL, "City mismatch! Expected: " + expectedCity + ", Actual: " + actualCity);
//                return false;
//            }
//            Reports.generateReport(driver, test, Status.PASS, "City verified: " + actualCity);
//            return true;
//        } catch (Exception e) {
//            Reports.generateReport(driver, test, Status.FAIL, "City verification failed");
//            return false;
//        }
//    }
//
//    public static boolean clickDiagnosticTest(String testName) {
//        try {
//            WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(topBookedSection));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
//
//            WebElement testLink = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//a[.//div[text()='" + testName + "']]")));
//            testLink.click();
//
//            Reports.generateReport(driver, test, Status.PASS, "Clicked on diagnostic test: " + testName);
//            return true;
//        } catch (Exception e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Diagnostic test not found: " + testName);
//            return false;
//        }
//    }
//
//    public static boolean clickAddToCart() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
//            Reports.generateReport(driver, test, Status.PASS, "Add to Cart clicked successfully");
//            return true;
//        } catch (TimeoutException e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Add to Cart button not found");
//            return false;
//        }
//    }
//
//    public static boolean verifyBookingPage() {
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
//            Reports.generateReport(driver, test, Status.PASS, "Booking page verified successfully");
//            return true;
//        } catch (TimeoutException e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Booking page verification failed");
//            return false;
//        }
//    
//}}


//package com.pages;
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.setup.Reports;
//
//public class UserPage {
//    private static WebDriver driver;
//    private static WebDriverWait wait;
//    static ExtentTest test;
//
//    // Locators
//    private static By labTestsLink = By.cssSelector("a[href*='/tests']");
//    private static By popupContainer = By.xpath("/html/body/div[5]/div/div/div/div/div/div/div");
//    private static By cityInput = By.xpath("/html/body/div[5]/div/div/div/div/div/div/div/div[2]/div/input");
//    private static By applyButton = By.xpath("//button[contains(text(),'Apply')]");
//    private static By locationDisplay = By.id("locationInput");
//    private static By topBookedSection = By.xpath("//h2[contains(text(),'Top Booked Diagnostic Tests')]");
//    private static By addToCartButton = By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std");
//
//    public UserPage(WebDriver driver, ExtentTest test) {
//        UserPage.driver = driver;
//        UserPage.test = test;
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    // Click Lab Tests link
//    public static boolean clickLabTestsLink() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(labTestsLink)).click();
//            Reports.generateReport(driver, test, Status.PASS, "Lab Tests link clicked successfully");
//            return true;
//        } catch (TimeoutException e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Lab Tests link not clickable");
//            return false;
//        }
//    }
//
//    // Select city from popup
//    public static boolean selectCityFromPopup(String cityName) {
//        try {
//            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupContainer));
//            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput));
//            input.clear();
//            input.sendKeys(cityName);
//
//            wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
//            wait.until(ExpectedConditions.invisibilityOf(popup));
//
//            Reports.generateReport(driver, test, Status.PASS, "City selected: " + cityName);
//            return true;
//        } catch (TimeoutException e) {
//            Reports.generateReport(driver, test, Status.FAIL, "City selection failed");
//            return false;
//        }
//    }
//
//    // Verify city after popup closes
//    public static boolean verifyCity(String expectedCity) {
//        try {
//            String actualCity = wait.until(ExpectedConditions.visibilityOfElementLocated(locationDisplay))
//                                    .getAttribute("value");
//            if (!actualCity.equalsIgnoreCase(expectedCity)) {
//                Reports.generateReport(driver, test, Status.FAIL, "City mismatch! Expected: " + expectedCity + ", Actual: " + actualCity);
//                return false;
//            }
//            Reports.generateReport(driver, test, Status.PASS, "City verified: " + actualCity);
//            return true;
//        } catch (Exception e) {
//            Reports.generateReport(driver, test, Status.FAIL, "City verification failed");
//            return false;
//        }
//    }
//
//    // Scroll and click diagnostic test
//    public static boolean clickDiagnosticTest(String testName) {
//        try {
//            WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(topBookedSection));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
//
//            WebElement testLink = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//a[.//div[text()='" + testName + "']]")));
//            testLink.click();
//
//            Reports.generateReport(driver, test, Status.PASS, "Clicked on diagnostic test: " + testName);
//            return true;
//        } catch (Exception e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Diagnostic test not found: " + testName);
//            return false;
//        }
//    }
//
//    // Click Add to Cart
//    public static boolean clickAddToCart() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
//            Reports.generateReport(driver, test, Status.PASS, "Add to Cart clicked successfully");
//            return true;
//        } catch (TimeoutException e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Add to Cart button not found");
//            return false;
//        }
//    }
//
//    // Verify booking page
//    public static boolean verifyBookingPage() {
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
//            Reports.generateReport(driver, test, Status.PASS, "Booking page verified successfully");
//            return true;
//        } catch (TimeoutException e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Booking page verification failed");
//            return false;
//        }
//    }
//}


//
//package com.pages;
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class UserPage {
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    // Locators
//    private By labTestsLink = By.cssSelector("a[href*='/tests']");
//    private By labTestsHeader = By.xpath("//h1[contains(text(),'Lab Tests')]");
//    private By diagnosticTestHeader = By.xpath("//h1[contains(text(),'Diagnostic Test')]");
//    private By bookingPageElement = By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std");
//
//    public UserPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    // Navigate to Lab Tests page
//    public boolean navigateToLabTestsPage() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(labTestsLink)).click();
//            wait.until(ExpectedConditions.visibilityOfElementLocated(labTestsHeader));
//            System.out.println("Navigated to Lab Tests page successfully.");
//            return true;
//        } catch (TimeoutException e) {
//            System.out.println("Failed to navigate to Lab Tests page.");
//            return false;
//        }
//    }
//
//    // Verify Diagnostic Test details page
//    public boolean verifyDiagnosticTestPage() {
//        try {
//            String currentUrl = driver.getCurrentUrl();
//            if (!currentUrl.contains("/tests/")) {
//                System.out.println("Not on Diagnostic Test details page!");
//                return false;
//            }
//            wait.until(ExpectedConditions.visibilityOfElementLocated(diagnosticTestHeader));
//            System.out.println("Navigated to Diagnostic Test details page successfully.");
//            return true;
//        } catch (TimeoutException e) {
//            System.out.println("Diagnostic Test details page verification failed.");
//            return false;
//        }
//    }
//
//    // Verify Booking page
//    public boolean verifyBookingPage() {
//        try {
//            WebElement bookingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(bookingPageElement));
//            if (bookingElement.isDisplayed()) {
//                System.out.println("Navigated to Booking page successfully.");
//                return true;
//            }
//            return false;
//        } catch (TimeoutException e) {
//            System.out.println("Booking page not displayed.");
//            return false;
//        }
//    }
//}



//package com.pages;
//import java.time.Duration;
// 
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
// 
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.setup.Reports;
//public class UserPage {
// 
//	private static WebDriver driver;
//    private static WebDriverWait wait;
// 
//    static ExtentTest test;
// 
//    private static By LabTests=By.xpath("//div[text()='Lab Tests']");
//	private static By LipidTests=By.xpath("//a[text()='Lipid Profile']");
// 
//	public UserPage(WebDriver driver, ExtentTest test)
// 
//	{
//		this.driver=driver;
//		this.test=test;	
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	}
//	public static boolean verifyLabTests()
//	{
//		boolean actResult = true;
//        try 
//        {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(LabTests));
//            Reports.generateReport(driver, test, Status.PASS, "LabTests Functionality is displayed");
//        } 
//        catch (TimeoutException te) 
//        {
//            actResult = false;
//            Reports.generateReport(driver, test, Status.FAIL, "LabTests Functionality is not displayed");
//        }
//        return actResult;
//	}
//	public static boolean click_Lab_Tests()
//	{
//		boolean actResult = true;
//        try 
//        {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(LabTests));
//            Reports.generateReport(driver, test, Status.PASS, "LabTests path is found");
//            driver.findElement(LabTests).click();
//        } 
//        catch (TimeoutException te) 
//        {
//            actResult = false;
//            Reports.generateReport(driver, test, Status.FAIL, "LabTests path is not found");
//        }
//        return actResult;
//	}
//	public boolean click_Lipid_Tests()
//	{
//		boolean actResult = true;
//        try 
//        {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(LipidTests));
//            Reports.generateReport(driver, test, Status.PASS, "LipidTests Page is opened");
//        } 
//        catch (TimeoutException te) 
//        {
//            actResult = false;
//            Reports.generateReport(driver, test, Status.FAIL, "LipidTests Page is not opened");
//        }
//        return actResult;
//	}
//}
// 


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
	private static By diagnosticTestHeader=By.xpath("//h1[contains(text(),'Diagnostic Test')]");
 
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
	public boolean click__Tests()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LabTests));
            Reports.generateReport(driver, test, Status.PASS, "LabTests Page is opened");
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "LabTests Page is not opened");
        }
        return actResult;
	}
}
 
