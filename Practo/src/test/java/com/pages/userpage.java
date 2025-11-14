package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;
////------------------------scenario 1-------------(correct)
//public class userpage  {
//	private WebDriver driver;
//	public static WebDriverWait wait;
//	private Properties prop;
//	
//	userpage page;
//	public userpage(WebDriver driver) {
//		this.driver = driver;
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		PageFactory.initElements(driver, this);
//	}
//	private static By filteredResults = By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");
//	private static By footerSection = By.tagName("footer");
//	private static By searchForClinicsLink = By.xpath("//span[text()='Search for clinics']");
//	private static By locationFilter =By.xpath("//input[@placeholder='Search location']");
////	private static By specialityFilter = By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']");
//
//	public WebElement getFooterSection() {
//
//		return driver. findElement (footerSection);
//	}
//	public boolean isSearchForClinicsLinkVisible() {
//		//return driver.findElement(searchForClinicsLink).isDisplayed();
//
//		WebElement link = driver.findElement(By.linkText("Search for clinics"));
//		return link.isDisplayed();
//
//	}
//	public void clickSearchForClinicsLink() {
////		driver.findElement(searchForClinicsLink).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		// Wait for location input to be visible
//		WebElement locationElement = wait.until(ExpectedConditions.el(searchForClinicsLink));
//
//		locationElement.click();
//
//		
//	}
//
//	public void applylocationFilter(String location) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		// Wait for location input to be visible
//		WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locationFilter));
//		locationElement.clear();
//		locationElement.click();
//		locationElement.sendKeys(location);
//		// Wait for suggestion dropdown
//		WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '" + location + "')]")));
//		suggestion.click();
//	}
//	public boolean verifyFilteredResults() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		try {
//			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(filteredResults));
//			return driver.findElements(filteredResults).size() > 0;
//		} catch (TimeoutException e) {
//			System.out.println("Results not loaded within timeout. Check selector or page behavior.");
//			return false;
//		}
//	}  
//
//
//	//------scenario2 (@firstclinic)--------------------- (correct)
//
//	// ✅ Page Factory Locators
//	@FindBy(xpath = "//a[contains(text(),'Clinics')]")
//	private WebElement clinicsLink;
//
//	@FindBy(xpath = "(//div[@class='info-section']//h2)[1]")
//	private WebElement firstClinic;
//
//	@FindBy(xpath = "//button[contains(text(),'View Profile')]")
//	private WebElement viewProfileBtn;
//
//	@FindBy(xpath = "//h1[contains(@class,'u-title-font')]")
//	private WebElement clinicName;
//
//	//	    @FindBy(xpath = "(//a[contains(@href,\"doctor\")])[1]")
//	@FindBy(xpath = "(//button[contains(text(),'View Profile')])[1]")
//	private WebElement firstDoctorLink;
//
//	@FindBy(xpath = "//h1[contains(@class,'u-title-font')]")
//	private WebElement doctorDetails;
//
//	/** Step 1: Click on Search Clinics link */
//	public void clickSearchClinicLink() {
//		wait.until(ExpectedConditions.elementToBeClickable(clinicsLink)).click();
//		System.out.println("Clicked on Search Clinics link.");
//	}
//
//	/** Step 2: Select first clinic */
//	public void selectFirstClinic() {
//		wait.until(ExpectedConditions.visibilityOf(firstClinic));
//		firstClinic.click();
//		System.out.println("Selected first clinic.");
//	}
//
//	/** Step 3: Click on View Profile of first clinic */
//	public void clickViewProfile() {
//		wait.until(ExpectedConditions.elementToBeClickable(viewProfileBtn)).click();
//		System.out.println("Clicked on View Profile button.");
//	}
//
//	/** Step 4: Verify clinic details page is displayed */
//	public boolean isClinicDetailsDisplayed() {
//		try {
//			wait.until(ExpectedConditions.visibilityOf(clinicName));
//			System.out.println("Clinic details page displayed successfully: " + clinicName.getText());
//			return true;
//		} catch (Exception e) {
//			//   System.out.println("Clinic details page not displayed: " + e.getMessage());
//			return false;
//		}
//	}
//
//	/** Step 5: Get doctor element dynamically */
//	public WebElement getDoctorElement() {
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
//		return wait.until(ExpectedConditions.elementToBeClickable(firstDoctorLink));
//	}
//
//	/** Step 6: Get doctor details */
//	public String getDoctorDetails() {
//		wait.until(ExpectedConditions.visibilityOf(doctorDetails));
//		//	        String details = doctorDetails.getText();
//		//	        System.out.println("Doctor details displayed: " + details);
//		return doctorDetails.getText();
//	}
//
//	//-------------- Scenario 3---------------------------------------------
//
//	
//
//	    @FindBy(xpath = "//div[text()='Clinics in Gopalapuram']")  
//	    private WebElement gopalapuramLink;
//
//	    @FindBy(xpath = "//button[contains(text(),'Call Clinic')]")
//		private WebElement callClinicButton;
//
//	public void clickGopalapuramLink() {
//		wait.until(ExpectedConditions.elementToBeClickable(gopalapuramLink)).click();
//	}
//
//	
//
//	public void clickCallClinic() {
//	    wait.until(ExpectedConditions.elementToBeClickable(callClinicButton)).click();
//	}
//
//
//
//	//---------------------scenario 4---------------------------(passed)
//
//
//
//	@FindBy(linkText = "Search for clinics")
//	private WebElement searchClinicLink;
//
//
//	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[2]/div[3]/div/div[2]/a[2]")
//	private WebElement anesthesiologyLink;
//
//	@FindBy(xpath = "//button[contains(text(),'View Profile')]")
//	private WebElement viewProfileBtn1;
//
//	//	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[2]")
//	//	private WebElement clinicDetail;
//	@FindBy(xpath = "//h1[@data-qa-id='clinic-name']")
//	private WebElement clinicDetail;
//
//	public userpage(WebDriver driver, Properties prop) {
//		this.driver = driver;
//		this.prop = prop;
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		PageFactory.initElements(driver, this);
//	}
//
//	public boolean clickSearchClinic() {
//		wait.until(ExpectedConditions.elementToBeClickable(searchClinicLink)).click();
//		System.out.println("Clicked on Search Clinic link.");
//		return searchClinicLink.isDisplayed();
//	}
//
//	public void clickAnesthesiologyLink() {
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
//		wait.until(ExpectedConditions.elementToBeClickable(anesthesiologyLink)).click();
//		System.out.println("Clicked on Anesthesiology Clinics link.");
//	}
//
//	public void clickViewProfile1() {
//		wait.until(ExpectedConditions.elementToBeClickable(viewProfileBtn)).click();
//		System.out.println("Clicked on View Profile button.");
//	}
//
//	public String getClinicDetails() {
//		wait.until(ExpectedConditions.visibilityOf(clinicDetail));
//		String name = clinicDetail.getText();
//		System.out.println("Clinic Name displayed: " + name);
//		return name;
//	}
//	
//	
//	//--------------------------scenario 5 (outline2)-------------------------
//
////	@FindBy(xpath = "//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
////	private WebElement specialityFilter;
////	
////	public void applyspecialityFilter(String speciality) {
////		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
////		// Wait for location input to be visible
////		WebElement specialityElement = wait.until(ExpectedConditions.visibilityOf(specialityFilter));
////		specialityElement.click();
////		specialityElement.clear();
////		
////		specialityElement.sendKeys(speciality);
////		// Wait for suggestion dropdown
////		WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']" + specialityFilter + "')]")));
////		suggestion.click();
////	}
//	
//}

//------------------------scenario 1-------------(correct)
public class userpage {
	private WebDriver driver;
	public static WebDriverWait wait;
	private Properties prop;
	
	userpage page;
	public userpage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	private static By filteredResults = By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");
	private static By footerSection = By.tagName("footer");
	private static By searchForClinicsLink = By.xpath("//span[text()='Search for clinics']");
	private static By locationFilter =By.xpath("//input[@placeholder='Search location']");
//	private static By specialityFilter = By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']");

	public WebElement getFooterSection() {

		return driver. findElement (footerSection);
	}
	public boolean isSearchForClinicsLinkVisible() {
		//return driver.findElement(searchForClinicsLink).isDisplayed();

		WebElement link = driver.findElement(By.linkText("Search for clinics"));
		return link.isDisplayed();

	}
	public void clickSearchForClinicsLink() {
		driver.findElement(searchForClinicsLink).click();
	}

	public void applylocationFilter(String location) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Wait for location input to be visible
		WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locationFilter));
		locationElement.clear();
		locationElement.click();
		locationElement.sendKeys(location);
		// Wait for suggestion dropdown
		WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '" + location + "')]")));
		suggestion.click();
	}
	public boolean verifyFilteredResults() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(filteredResults));
			return driver.findElements(filteredResults).size() > 0;
		} catch (TimeoutException e) {
			System.out.println("Results not loaded within timeout. Check selector or page behavior.");
			return false;
		}
	}  


	//------scenario2 (@firstclinic)--------------------- (correct)

	// ✅ Page Factory Locators
	@FindBy(xpath = "//a[contains(text(),'Clinics')]")
	private WebElement clinicsLink;

	@FindBy(xpath = "(//div[@class='info-section']//h2)[1]")
	private WebElement firstClinic;

	@FindBy(xpath = "//button[contains(text(),'View Profile')]")
	private WebElement viewProfileBtn;

	@FindBy(xpath = "//h1[contains(@class,'u-title-font')]")
	private WebElement clinicName;

	//	    @FindBy(xpath = "(//a[contains(@href,\"doctor\")])[1]")
	@FindBy(xpath = "(//button[contains(text(),'View Profile')])[1]")
	private WebElement firstDoctorLink;

	@FindBy(xpath = "//h1[contains(@class,'u-title-font')]")
	private WebElement doctorDetails;

	/** Step 1: Click on Search Clinics link */
	public void clickSearchClinicLink() {
		wait.until(ExpectedConditions.elementToBeClickable(clinicsLink)).click();
		System.out.println("Clicked on Search Clinics link.");
	}

	/** Step 2: Select first clinic */
	public void selectFirstClinic() {
		wait.until(ExpectedConditions.visibilityOf(firstClinic));
		firstClinic.click();
		System.out.println("Selected first clinic.");
	}

	/** Step 3: Click on View Profile of first clinic */
	public void clickViewProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(viewProfileBtn)).click();
		System.out.println("Clicked on View Profile button.");
	}

	/** Step 4: Verify clinic details page is displayed */
	public boolean isClinicDetailsDisplayed() {
		try {
			wait.until(ExpectedConditions.visibilityOf(clinicName));
			System.out.println("Clinic details page displayed successfully: " + clinicName.getText());
			return true;
		} catch (Exception e) {
			//   System.out.println("Clinic details page not displayed: " + e.getMessage());
			return false;
		}
	}

	/** Step 5: Get doctor element dynamically */
	public WebElement getDoctorElement() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		return wait.until(ExpectedConditions.elementToBeClickable(firstDoctorLink));
	}

	/** Step 6: Get doctor details */
	public String getDoctorDetails() {
		wait.until(ExpectedConditions.visibilityOf(doctorDetails));
		//	        String details = doctorDetails.getText();
		//	        System.out.println("Doctor details displayed: " + details);
		return doctorDetails.getText();
	}

	//-------------- Scenario 3---------------------------------------------

	

	    @FindBy(xpath = "//div[text()='Clinics in Gopalapuram']")  
	    private WebElement gopalapuramLink;

	    @FindBy(xpath = "//button[contains(text(),'Call Clinic')]")
		private WebElement callClinicButton;

	public void clickGopalapuramLink() {
		wait.until(ExpectedConditions.elementToBeClickable(gopalapuramLink)).click();
	}

	

	public void clickCallClinic() {
	    wait.until(ExpectedConditions.elementToBeClickable(callClinicButton)).click();
	}



	//---------------------scenario 4---------------------------(passed)



	@FindBy(linkText = "Search for clinics")
	private WebElement searchClinicLink;


	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[2]/div[3]/div/div[2]/a[2]")
	private WebElement anesthesiologyLink;

	@FindBy(xpath = "//button[contains(text(),'View Profile')]")
	private WebElement viewProfileBtn1;

	//	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[2]")
	//	private WebElement clinicDetail;
	@FindBy(xpath = "//h1[@data-qa-id='clinic-name']")
	private WebElement clinicDetail;

	public userpage(WebDriver driver, Properties prop) {
		this.driver = driver;
		this.prop = prop;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public boolean clickSearchClinic() {
		wait.until(ExpectedConditions.elementToBeClickable(searchClinicLink)).click();
		System.out.println("Clicked on Search Clinic link.");
		return searchClinicLink.isDisplayed();
	}

	public void clickAnesthesiologyLink() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
		wait.until(ExpectedConditions.elementToBeClickable(anesthesiologyLink)).click();
		System.out.println("Clicked on Anesthesiology Clinics link.");
	}

	public void clickViewProfile1() {
		wait.until(ExpectedConditions.elementToBeClickable(viewProfileBtn)).click();
		System.out.println("Clicked on View Profile button.");
	}

	public String getClinicDetails() {
		wait.until(ExpectedConditions.visibilityOf(clinicDetail));
		String name = clinicDetail.getText();
		System.out.println("Clinic Name displayed: " + name);
		return name;
	}
	
	
	//--------------------------scenario 5 (outline2)-------------------------

//	@FindBy(xpath = "//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
//	private WebElement specialityFilter;
//	
//	public void applyspecialityFilter(String speciality) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		// Wait for location input to be visible
//		WebElement specialityElement = wait.until(ExpectedConditions.visibilityOf(specialityFilter));
//		specialityElement.click();
//		specialityElement.clear();
//		
//		specialityElement.sendKeys(speciality);
//		// Wait for suggestion dropdown
//		WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']" + specialityFilter + "')]")));
//		suggestion.click();
//	}
	
}











