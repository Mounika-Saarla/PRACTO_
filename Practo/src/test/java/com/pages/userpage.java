package com.pages;

import java.time.Duration;
import java.util.List;

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
import com.setup.Reports;

import io.cucumber.plugin.event.SnippetsSuggestedEvent.Suggestion;
//------------------------scenario 1-------------(correct)
public class userpage {
	private WebDriver driver;
	private static WebDriverWait wait;
	public userpage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	private static By filteredResults = By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");
	private static By footerSection = By.tagName("footer");
	private static By searchForClinicsLink = By.linkText("Search for clinics");
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


	//------scenario2  (correct)
//
//	// Locators
//	private By clinicsLink = By.xpath("//a[contains(text(),'Clinics')]");
//	private By firstClinic = By.xpath("(//div[@class='info-section']//h2)[1]");
//	private By viewProfileBtn = By.xpath("//button[contains(text(),'View Profile')]");
//	private By clinicName = By.xpath("//h1[@data-qa-id='clinic-name']");
//	private By firstDoctorLink = By.xpath("By.xpath(\"//a[contains(@href,'doctor') and contains(text(),'Dr. Arunachalam')]\")"); // Dynamic doctor link
//	private By doctorDetails = By.xpath("//h1[contains(@class,'u-title-font')]");
//
//
//	public void clickSearchClinicLink() {
//		wait.until(ExpectedConditions.elementToBeClickable(clinicsLink)).click();
//		System.out.println("Clicked on Search Clinics link.");
//	}
//
//	
//
//	public void selectFirstClinic() {
//		//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.info-section")));
//		//		WebElement firstClinicElement = wait.until(
//		//				ExpectedConditions.elementToBeClickable(By.xpath("(//h2[contains(@class,'u-title-font')])[1]"))
//		//				);
//		//		firstClinicElement.click();
//
//		wait.until(ExpectedConditions.presenceOfElementLocated(firstClinic));
//		driver.findElement(firstClinic).click();
//		System.out.println("Selected first clinic.");
//
//	}
//
//	public void clickViewProfile() {
//		wait.until(ExpectedConditions.elementToBeClickable(viewProfileBtn)).click();
//		System.out.println("Clicked on View Profile button.");
//	}
//
//	//	public void scenario2Doctor() {
//	//		wait.until(ExpectedConditions.elementToBeClickable(scenario2Doctor)).click();
//	//	}
//	public boolean isClinicDetailsDisplayed() {
//		try {
//			WebElement clinicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(clinicName));
//			System.out.println("Clinic details page displayed successfully: " + clinicElement.getText());
//			return true;
//		} catch (Exception e) {
//			System.out.println("Clinic details page not displayed: " + e.getMessage());
//			return false;
//		}
//	}
//
//	private By firstDoctorLink = By.xpath("(//a[contains(@href,'doctor')])[1]");
//
//	public WebElement getDoctorElement() {
//	    return wait.until(ExpectedConditions.presenceOfElementLocated(firstDoctorLink));
//	}
////	public String firstDoctorLink() {
////		//		WebElement doctorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(doctorDetails));
////		//		return doctorElement.getText();
////
////		WebElement doctorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstDoctorLink));
////		String details = doctorElement.getText();
////		System.out.println("Doctor details displayed: " + details);
////		return details;
////
////	}
//
//	 /** Get doctor details */
//	    public String getDoctorDetails() {
//	        WebElement doctorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(doctorDetails));
//	        String details = doctorElement.getText();
//	        System.out.println("Doctor details displayed: " + details);
//	        return details;
//	    }
//
////	public WebElement getDoctorElement() {
////	    // Scroll first to ensure doctor section loads
////	    WebElement doctorElement = wait.until(ExpectedConditions.presenceOfElementLocated(
////	            By.xpath("(//div[contains(@class,'doctor-card')]//a[contains(@href,'doctor')])[1]")));
////	    return doctorElement;
////	}
//


	  // ✅ Page Factory Locators
	    @FindBy(xpath = "//a[contains(text(),'Clinics')]")
	    private WebElement clinicsLink;

	    @FindBy(xpath = "(//div[@class='info-section']//h2)[1]")
	    private WebElement firstClinic;

	    @FindBy(xpath = "//button[contains(text(),'View Profile')]")
	    private WebElement viewProfileBtn;

	    @FindBy(xpath = "//h1[@data-qa-id='clinic-name']")
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

	

	//---------------scenario3-------------------------


	//    private By searchClinicsLink = By.linkText("Search for Clinics");
	//       private By locationField = By.id("location");
	//       private By specialityField = By.id("speciality");
	//       private By searchButton = By.id("search");
	//       private By firstDoctorCard = By.cssSelector(".doctor-card");
	//       private By bookClinicVisitBtn = By.xpath("//button[contains(text(),'Book clinic visit')]");
	//       private By mobileField = By.id("mobile");
	//       private By continueBtn = By.xpath("//button[contains(text(),'Continue')]");
	//       private By errorMessageElement = By.cssSelector(".error-message");
	//
	//
	//       public void clickFooterLink(String linkText) {
	//              wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText))).click();
	//          }
	//       public void enterLocation(String location) {
	//             wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location"))).sendKeys(location);
	//         }
	//public void enterSpeciality(String speciality) {
	//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("speciality"))).sendKeys(speciality);
	//    }
	//       public void clickSearch() {
	//           wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	//       }
	//public void selectDoctorFromResults() {
	//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".doctor-card"))).click();
	//    }
	//
	//
	////       public void clickButton(String buttonText) {
	////           if (buttonText.equalsIgnoreCase("Book clinic visit")) {
	////               wait.until(ExpectedConditions.elementToBeClickable(bookClinicVisitBtn)).click();
	////           } else if (buttonText.equalsIgnoreCase("Continue")) {
	////               wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
	////           }
	////       }
	//
	//public void clickButton(String buttonText) {
	//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'" + buttonText + "')]"))).click();
	//    }
	//
	//
	////       public void selectTimeSlot(String timeSlot) {
	////           WebElement slot = wait.until(ExpectedConditions.elementToBeClickable(
	////               By.xpath("//span[contains(text(),'" + timeSlot + "')]")));
	////           slot.click();
	////       }
	//
	//public void selectTimeSlot(String timeSlot) {
	//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + timeSlot + "')]"))).click();
	//    }
	//
	//
	////       public void enterMobileNumber(String mobile) {
	////           wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField)).sendKeys(mobile);
	////       }
	////
	////       public String getErrorMessage() {
	////           return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageElement)).getText();
	////       }
	//
	//
	//public void enterInvalidMobile(String mobile) {
	//       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileField"))).sendKeys(mobile);
	//   }
	//
	//   public String getErrorMessage() {
	//       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message"))).getText();
	//   }

	// private By searchForClinicsLink = By.linkText("Search for Clinics");
	private By locationField = By.id("location");
	private By specialityField = By.id("speciality");
	private By searchButton = By.id("search");
	private By firstDoctorCard = By.cssSelector(".doctor-card");
	private By mobileField = By.id("mobileField");
	private By errorMessageElement = By.cssSelector(".error-message");

	//    public UserPage(WebDriver driver) {
	//        this.driver = driver;
	//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//    }

	public WebElement getFooterSection1() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(searchForClinicsLink));
	}
	//

	//    public void enterLocation(String location) {
	//        wait.until(ExpectedConditions.visibilityOfElementLocated(locationField));
	//        ((WebElement) driver).sendKeys(location);
	//    }
	//
	//    public void enterSpeciality(String speciality) {
	//        wait.until(ExpectedConditions.visibilityOfElementLocated(specialityField)).sendKeys(speciality);
	//    }

	public void clickSearchForClinicsLink1() {
		WebElement footerLink = wait.until(ExpectedConditions.presenceOfElementLocated(searchForClinicsLink));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerLink);
		wait.until(ExpectedConditions.elementToBeClickable(searchForClinicsLink)).click();
	}

	public void applyCityFilter(String city) {
		By cityLocator = By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input");
		wait.until(ExpectedConditions.elementToBeClickable(cityLocator)).click();
		System.out.println("Applied City Filter: " + city);
	}


	public void applyRoleFilter(String role) {
		By roleLocator = By.xpath("//label[contains(text(),'" + role + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(roleLocator)).click();
		System.out.println("Applied Role Filter: " + role);
	}

	// Select Doctor from Search Results
	public void selectDoctor() {
		By doctorLocator = By.cssSelector("div[data-qa-id='doctor-card']");
		wait.until(ExpectedConditions.elementToBeClickable(doctorLocator)).click();
		System.out.println("Doctor selected from search results");
	}

	// Click Button (Book clinic visit / Continue)
	public void clickButton(String buttonText) {
		By buttonLocator = By.xpath("//button[contains(text(),'" + buttonText + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(buttonLocator)).click();
		System.out.println("Clicked button: " + buttonText);
	}
	// Select Time Slot
	public void selectTimeSlot(String timeSlot) {
		By timeSlotLocator = By.xpath("//span[contains(text(),'" + timeSlot + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(timeSlotLocator)).click();
		System.out.println("Selected Time Slot: " + timeSlot);
	}

	// Enter Invalid Mobile Number
	public void enterInvalidMobile(String mobileNumber) {
		By mobileInputLocator = By.cssSelector("input[data-qa-id='mobile-input']");
		WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileInputLocator));
		mobileInput.clear();
		mobileInput.sendKeys(mobileNumber);
		System.out.println("Entered Invalid Mobile Number: " + mobileNumber);
	}

	// Get Error Message
	public String getErrorMessage() {
		By errorLocator = By.cssSelector("div.error-message");
		String errorText = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator)).getText();
		System.out.println("Error Message Displayed: " + errorText);
		return errorText;
	}
	//-------------- Scenario 4---------------------------------------------

	// Locators (dynamic where needed)
	private By clinicsLink1 = By.xpath("//a[contains(text(),'Clinics')]");
	private By searchBox = By.xpath("//input[@placeholder='Search for clinics']");
	private By searchButton1 = By.xpath("//button[contains(text(),'Search')]");
	private By clinicResults = By.xpath("//div[contains(@class,'clinic-card')]");
	private By genderFilterSection = By.xpath("//label[contains(text(),'Gender')]");
	private By applyFilterButton = By.xpath("//button[contains(text(),'Apply')]");
	private By doctorNames = By.xpath("//div[@class='doctor-card']//h2");

	// Navigate to Clinics page
	public void navigateToClinicsPage() {
		WebElement clinicsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/bangalore/clinics']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clinicsLink);
		clinicsLink.click();
	}

	// Enter role and search
	public void enterRoleAndSearch(String role) {
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='search']")));
		searchBox.clear();
		searchBox.sendKeys(role);
		searchBox.sendKeys(Keys.ENTER);
	}

	// Verify clinic results
	public boolean isClinicResultsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".u-border-top"))).isDisplayed();
	}

	// Select gender filter
	public void selectGenderFilter(String gender) {
		WebElement genderOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='gender' and @value='" + gender + "']/following-sibling::label")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderOption);
		genderOption.click();
	}

	// Apply filter
	public void applyGenderFilter() {
		WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-qa-id='apply-filter']")));
		applyButton.click();
	}

	// Get selected gender
	public String getSelectedGender() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='gender']:checked"))).getAttribute("value");
	}

	// Verify doctors match selected gender
	public boolean verifyDoctorsGender(String expectedGender) {
		List<WebElement> doctorNames = driver.findElements(By.cssSelector(".doctor-card"));
		for (WebElement doctor : doctorNames) {
			String doctorGender = doctor.findElement(By.cssSelector(".u-color--gray")).getText();
			if (!doctorGender.equalsIgnoreCase(expectedGender)) {
				return false;
			}
		}
		return true;
	}

	// Check if gender filter persists after refresh
	public boolean isGenderFilterStillApplied(String expectedGender) {
		String persistedGender = getSelectedGender();
		return persistedGender.equalsIgnoreCase(expectedGender);
	}

}





