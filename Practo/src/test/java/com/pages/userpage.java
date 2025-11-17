package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//------------------------scenario 1-------------(correct)
public class userpage {
	private static WebDriver driver;
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
	private static By hospitalInput=By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");
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
			return true;
//			return driver.findElements(filteredResults).size() > 0;
		} catch (TimeoutException e) {
			System.out.println("Results not loaded within timeout. Check selector or page behavior.");
			return false;
		}
	}  


	//------scenario2 (@firstclinic)--------------------- (correct)

	// ✅ Page Factory Locators
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/ol/div/h1")
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

//----------------------------scenario 4 (@Anesthesiologists)-----------------------
//	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[1]/ol/li[5]/div/div[2]/div[1]/a")
//	private WebElement QureOrthoCliniclink;
//	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div/div[3]/div/div/div/div/div[2]/div/a")
//	private WebElement Anesthesiologistslink;
	@FindBy(xpath = "//div[@id='container']//ol/li[5]//a")
	private static WebElement QureOrthoCliniclink;

	@FindBy(xpath = "(//*[@id=\"container\"]/div/div[3]/div/div[2]/div[1]/div[1]/div/div[2]")
	private static WebElement FractureTreatment;
	

//	public void clickQureOrthoClinicLink() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'qure-ortho-clinic')]")));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", QureOrthoCliniclink);
//	    wait.until(ExpectedConditions.elementToBeClickable(QureOrthoCliniclink)).click();
//	}
//	public void clickQureOrthoClinicLink() {
//    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//    int count = driver.findElements(By.xpath("(//div[contains(@class,'c-estb-card')])[5]")).size();
//    System.out.println("Links found: " + count);
//    if (count == 0) {
//        throw new RuntimeException("Qure Ortho Clinic link not found on page!");
//    }
//    wait.until(ExpectedConditions.elementToBeClickable(QureOrthoCliniclink)).click();
//}
	public static boolean QureOrthoCliniclink()
	{
		boolean actResult = true;
        try
        {
            WebElement clickmenubutton = wait.until(ExpectedConditions.elementToBeClickable(QureOrthoCliniclink));
           // Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
            clickmenubutton.click();
            
        }
        catch (TimeoutException te)
        {
            actResult = false;
         //   Reports.generateReport(driver, test, Status.FAIL, "menuBar is not found and clickable");
        }
        return actResult;
	}


//	public void clickAnesthesiologistsLink() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'anesthesiologist')]")));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Anesthesiologistslink);
//	    wait.until(ExpectedConditions.elementToBeClickable(Anesthesiologistslink)).click();
//	}
//	public static boolean Anesthesiologistslink()
//	{
//		boolean actResult = true;
//        try
//        {
//            WebElement clicklink = wait.until(ExpectedConditions.elementToBeClickable(FractureTreatment));
//           // Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clicklink);
//            clicklink.click();
//            
//        }
//        catch (TimeoutException te)
//        {
//            actResult = false;
//         //   Reports.generateReport(driver, test, Status.FAIL, "menuBar is not found and clickable");
//        }
//        return actResult;
	//}

	
	
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
	public static boolean specialityfilter(String hospitalName)
	{
		boolean actResult = true;
        try
        {
            WebElement clicklink = wait.until(ExpectedConditions.elementToBeClickable(hospitalInput));
            WebElement hospital=driver.findElement(hospitalInput);
            hospital.click();
            hospital.clear();
            (hospital).sendKeys(hospitalName);
    		(hospital).sendKeys(Keys.ARROW_DOWN);
    		hospital.sendKeys(Keys.ENTER);
    		
           // Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
           
            
        }
        catch (TimeoutException te)
        {
            actResult = false;
         //   Reports.generateReport(driver, test, Status.FAIL, "menuBar is not found and clickable");
        }
        return actResult;
	}
	
	//----------scenario 6------------
	public void applylocationFilter1(String location1) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Wait for location input to be visible
		WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locationFilter));
		locationElement.clear();
		locationElement.click();
		locationElement.sendKeys(location1);
		// Wait for suggestion dropdown
		WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), '" + location1 + "')]")));
		suggestion.click();
	}
	
}











