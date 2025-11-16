package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.userpage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	WebDriver driver;
	//	WebDriverWait wait;
	userpage page;
	//   private userpage userPage; // ✅ Declare at class level
	ExcelReader reader = new ExcelReader();
	String location;
	String speciality;
	String City;
	String Role;
	//	userpage UserPage = new userpage(BaseSteps.getDriver()); // PageFactory initialized in UserPage constructor

	userpage userPage = new userpage(BaseSteps.getDriver());
	Properties prop = PropertyReader.readProperty();
	WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), Duration.ofSeconds(10));


	//-----------Scenario 1----------------------- (passed)

	@Given("User is on the Home page")
	public void user_is_on_the_home_page() {
		BaseSteps. launchBrowser() ;
		driver = BaseSteps.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		page = new userpage(driver);
	}

	@And("User scrolls to the footer section")
	public void user_scrolls_to_the_footer_section() {

		WebElement footer = page.getFooterSection();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
	}

	@When("The footer should contain a visible link labeled Search for clinics")
	public void the_footer_should_contain_a_visible_link_labeled_search_for_clinics() {
		Assert.assertTrue(page.isSearchForClinicsLinkVisible(),
				"Link labeled 'Search for clinics' is not visible in the footer.");
	}

	@And("User clicks on the Search for clinics link")
	public void user_clicks_on_the_link() {

		page.clickSearchForClinicsLink();
		System.out.println("Clicked on link: " );
	}


	@And("User applies a location filter from sheet {int} at RowIndex {int}")
	public void user_applies_a_location_filter_from_sheet_at_row_index(Integer sheetIndex, Integer rowIndex) throws Exception {
		String location = reader.getCellData(sheetIndex, rowIndex, 0);
		page.applylocationFilter(location);
		System.out.println("Applied Location filter: " + location);
	}

	@Then("Filtered clinic results should be displayed")
	public void filtered_clinic_results_should_be_displayed() {
		Assert.assertTrue(page.verifyFilteredResults(), "Filtered clinic results are not displayed.");
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Page Source snippet: " + driver.getPageSource().substring(0, 500));
	}


	// ---------------- Scenario 2 Steps (@firstclinic) ----------------(passed)

	@Given("user launch practo website")
	public void user_launch_practo_website() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		BaseSteps.launchBrowser();
		driver = BaseSteps.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		page = new userpage(driver);
	}

	@When("user clicks the search for clinics link")
	public void user_clicks_the_search_for_clinics_link() {
		// Write code here that turns the phrase above into concrete actions
		//throw new io.cucumber.java.PendingException();
		page.clickSearchForClinicsLink();
	}

	@And("user clicks on view profile of first clinic")
	public void user_clicks_on_view_profile_of_first_clinic() {
		// Click on 'View Profile' button
		//		page.selectFirstClinic();
		//		page.clickViewProfile();
		WebElement viewProfileBtn = driver.findElement(By.xpath("//button[contains(text(),'View Profile')]"));
		viewProfileBtn.click();
	}


	@And("clinic details shouls be displayed")
	public void clinic_details_shouls_be_displayed() {
		//		// Verify clinic details page is displayed
		WebElement clinicName = driver.findElement(By.xpath("//h1[@data-qa-id='clinic-name']"));
		if (clinicName.isDisplayed()) {
			System.out.println("Clinic details page displayed successfully: " + clinicName.getText());
		} else {
			throw new AssertionError("Clinic details page not displayed");
		}

		//		 boolean isDisplayed = page.isClinicDetailsDisplayed();
		//		        if (!isDisplayed) {
		//		            throw new AssertionError("Clinic details page not displayed!");
		//		        }

		//		driver.quit();
	}
	@Then("user select the doctor in that clinic")
	public void user_select_the_doctor_in_that_clinic() {
		WebElement firstDoctorLink = page.getDoctorElement();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", firstDoctorLink);
		firstDoctorLink.click();
		System.out.println("Doctor selected successfully.");
	}



	//	  @Then("doctor details should be displayed")
	//	    public void doctor_details_should_be_displayed() {
	//	        String doctorName = page.getDoctorDetails();
	//	        System.out.println("Doctor details displayed: " + doctorName);
	//	        BaseSteps.closeBrowser();
	//	    }

	//	@Then("doctor details should be displayed")
	//	public void doctor_details_should_be_displayed() {
	//		//		WebElement doctorDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(
	//		//				By.xpath("//h1[contains(@class,'u-title-font')]")));
	//		//		System.out.println("Doctor details displayed: " + doctorDetails.getText());
	//
	//		String doctorName = page.doctorName();  // ✅ Use page object method
	//		System.out.println("Doctor details displayed: " + doctorName);
	//		BaseSteps.closeBrowser();


	//-------------------------scenario 3 (@clinicinGopalapuram)--------------------------(passed)

	@And("User clicks on Clinics in Gopalapuram link")
	public void user_clicks_on_clinics_in_gopalapuram_link() {
		page.clickGopalapuramLink();
		// Assertion: URL should contain 'gopalapuram'
		Assert.assertTrue(driver.getCurrentUrl().contains("gopalapuram"), "Failed to navigate to Gopalapuram clinics page");
	}
	@Then("User click on Call Clinic")
	public void user_click_on_call_clinic() {
		page.clickCallClinic();
		// Assertion: Verify that the call popup or confirmation appears
		Assert.assertTrue(driver.getPageSource().contains("Call"), "Call Clinic action did not trigger correctly");
	}
	//----------------------------scenario 4 (@Anesthesiologists)------------------------


	@When("user clicks on Qure Ortho Clinic link")
	public void user_clicks_on_qure_ortho_clinic_link() {
	//	String expectedUrl = BaseSteps.prop.getProperty("QureOrthoCliniclink");
		userPage.QureOrthoCliniclink();
//		BaseSteps.sleep(2000);
	//	String actualUrl = BaseSteps.getDriver().getCurrentUrl();
	//	Assert.assertEquals("Qure Ortho Clinic URL mismatch!", expectedUrl, actualUrl);
	}



	@Then("user clicks on Anesthesiologist in Chennai link in footer")
	public void user_clicks_on_anesthesiologist_in_chennai_link_in_footer() {
	//	String expectedUrl = BaseSteps.prop.getProperty("Anesthesiologistslink");
		userPage.Anesthesiologistslink();
//		BaseSteps.sleep(2000);
	//	String actualUrl = BaseSteps.getDriver().getCurrentUrl();
	//	Assert.assertEquals("Anesthesiologist URL mismatch!", expectedUrl, actualUrl);
//		System.out.println("Links found: " + BaseSteps.getDriver()
//		.findElements(By.xpath("//a[contains(@href,'qure-ortho-clinic')]")).size());

	}

	//---------------------------scenario 5 (@outline2) ---------------------
	//
	//@And("User applies a speciality filter from sheet {int} at RowIndex {int}")
	//public void user_applies_a_speciality_filter_from_sheet_at_row_index(Integer sheetIndex, Integer rowIndex) throws Exception {
	//	String speciality = reader.getCellData(sheetIndex, rowIndex, 0);
	//	
	//	page.applylocationFilter(speciality);
	//	System.out.println("Applied speciality filter: " + speciality);
	//}
	//@When("User clicks on the Search for clinics link")
	//public void user_clicks_on_the_search_for_clinics_link() {
	////	page.applyspecialityFilter(speciality);
	////	System.out.println("Clicked on link " );
	//}
	@And("User applies a speciality filter from sheet {int} at RowIndex {int}")
	public void user_applies_a_speciality_filter_from_sheet_at_row_index(Integer sheetIndex, Integer rowIndex) throws Exception {
		//	System.out.println("Reading from sheet: " + sheetIndex + ", row: " + (rowIndex + 1));
		//	String speciality = reader.getCellData1(sheetIndex, rowIndex, 0);
		//	System.out.println("Speciality from Excel: '" + speciality + "'");
		//    String speciality = reader.getCellData1(sheetIndex, rowIndex, 0); // rowIndex is logical (0 = first data row)
		//    page.applyspecialityFilter(speciality);
		//    System.out.println("Applied speciality filter: " + speciality);
		String hospitalName = ExcelReader.getCellDatas(ExcelReader.FILE_PATH2, sheetIndex, rowIndex, ExcelReader.HOSPITAL_COLUMN_INDEX);
		System.out.println("Hospital from Excel: " + hospitalName);
		//
		WebDriver driver = BaseSteps.getDriver();
		WebElement hospitalInput = driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input"));

		hospitalInput.click();
		hospitalInput.clear();
		hospitalInput.sendKeys(hospitalName);
		hospitalInput.sendKeys(Keys.ARROW_DOWN);
		hospitalInput.sendKeys(Keys.ENTER);
	}


}


