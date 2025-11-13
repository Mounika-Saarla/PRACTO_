package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	WebDriverWait wait;
	userpage page;
	ExcelReader reader = new ExcelReader();

	String location;
	String speciality;
	String City;
	String Role;
	String gender;
	userpage UserPage = new userpage(BaseSteps.getDriver()); // PageFactory initialized in UserPage constructor

	//-----------Scenario 1-----------------------

	@Given("User is on the Home page")
	public void user_is_on_the_home_page() {
		BaseSteps. launchBrowser() ;

		driver = BaseSteps.getDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

	@And("User clicks on the {string} link")
	public void user_clicks_on_the_link(String linkText) {
		page.clickSearchForClinicsLink();
		System.out.println("Clicked on link: " + linkText);
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


	// ---------------- Scenario 2 Steps ----------------

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


	


	//-----------------------scenario 3-------------------------


	//
	//
	//@Given("user on the homepage")
	//    public void user_on_the_homepage() {
	//        BaseSteps.launchBrowser(); // initializes driver
	//        page = new UserPage(BaseSteps.getWebDriver()); // initialize page object
	//    }
	//
	//    @When("user click on the {string} footer link")
	//    public void user_click_on_footer_link(String linkText) {
	//        WebElement footer = page.getFooterSection();
	//        ((JavascriptExecutor) BaseSteps.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", footer);
	//        page.clickSearchForClinicsLink();
	//    }
	//
	//    @And("user enter a valid location and speciality from test data")
	//    public void user_enter_location_speciality() throws Exception {
	//        String location = ExcelReader.getCellData("Sheet1", 1, 0);
	//        String speciality = ExcelReader.getCellData("Sheet1", 1, 1);
	//        page.enterLocation(location);
	//        page.enterSpeciality(speciality);
	//        page.clickSearch();
	//    }
	//
	//    @And("user select a doctor from the search results")
	//    public void user_select_doctor() {
	//        page.selectDoctorFromResults();
	//    }
	//
	//    @And("user click on the {string} button")
	//    public void user_click_on_button(String buttonText) {
	//        page.clickButton(buttonText);
	//    }
	//
	//    @And("user select a time slot from test data")
	//    public void user_select_time_slot() throws Exception {
	//        String timeSlot = ExcelReader.getCellData("Sheet1", 1, 2);
	//        page.selectTimeSlot(timeSlot);
	//    }
	//
	//    @And("user enter an invalid mobile number from test data")
	//    public void user_enter_invalid_mobile() throws Exception {
	//        String invalidMobile = ExcelReader.getCellData("Sheet1", 1, 3);
	//        page.enterInvalidMobile(invalidMobile);
	//    }
	//
	//    @Then("user should see an error message in next page from test data")
	//    public void user_should_see_error_message() throws Exception {
	//        String expectedError = ExcelReader.getCellData("Sheet1", 1, 4);
	//        String actualError = page.getErrorMessage();
	//        Assert.assertEquals("Error message mismatch!", expectedError, actualError);
	//    }


	@Given("user on the homepage")
	public void user_on_the_homepage() {
		BaseSteps.launchBrowser();
		page = new userpage(BaseSteps.getDriver());
	}



	@When("user click on the {string} footer link")
	public void user_click_on_footer_link(String linkText) {
		page.clickSearchForClinicsLink();
	}


	//	@And("user enter a valid location and speciality from test data")
	//	public void user_enter_location_speciality() throws Exception {
	//			    /*    String location = ExcelReader.getCellData("Sheet2", 1, 0);
	//			        String speciality = ExcelReader.getCellData("Sheet2", 1, 1);
	//			        UserPage.enterLocation(location);
	//			        UserPage.enterSpeciality(speciality);
	//			        Hooks.page.enterLocation(location);
	//			        Hooks.page.enterSpeciality(speciality);
	//		Hooks.page.clicksearch();*/
	//		String City = ExcelReader.getCellData("Search", 1, 0);
	//		String Role = ExcelReader.getCellData("Search", 1, 1);
	//		userpage search = new userpage(BaseSteps.driver);
	//		search.enterSpeciality(location);
	//	}

	@And("user applies a City filter from test data")
	public void user_applies_a_city_filter_from_test_data() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
		String sheetName = PropertyReader.getProperty("excelSheetName");
		String city = ExcelReader.getCellDataByColumnName(sheetName, 1, "City"); // Row 1 for test data
		page.applylocationFilter(city);
		System.out.println("Applied City filter: " + city);
	}



	@And("user applies a Role filter from test data")
	public void user_applies_a_role_filter_from_test_data() throws Exception {

		String sheetName = PropertyReader.getProperty("excelSheetName");
		String role = ExcelReader.getCellDataByColumnName(sheetName, 1, "Role");
		System.out.println("Role from Excel: " + role);
		page.applyRoleFilter(role);

	}



	@And("user select a doctor from the search results")
	public void user_select_doctor() {
		page.selectDoctor();
	}



	@And("user click on the {string} button")
	public void user_click_on_button(String buttonText) {
		page.clickButton(buttonText);
	}


	@And("user select a time slot from test data")
	public void user_select_time_slot() throws Exception {
		String sheetName = PropertyReader.getProperty("excelSheetName");
		String timeSlot = ExcelReader.getCellDataByColumnName(sheetName, 1, "TimeSlot");
		System.out.println("TimeSlot from Excel: " + timeSlot);
		page.selectTimeSlot(timeSlot);
	}


	@And("user enter an invalid mobile number from test data")
	public void user_enter_invalid_mobile() throws Exception {
		String sheetName = PropertyReader.getProperty("excelSheetName");
		String invalidMobile = ExcelReader.getCellDataByColumnName(sheetName, 1, "InvalidMobile");
		System.out.println("InvalidMobile from Excel: " + invalidMobile);
		page.enterInvalidMobile(invalidMobile);
	}


	@Then("user should see an error message in next page from test data")
	public void user_should_see_error_message() throws Exception {
		String sheetName = PropertyReader.getProperty("excelSheetName");
		String errorMessage = ExcelReader.getCellDataByColumnName(sheetName, 1, "ErrorMessage");
		String actualError = page.getErrorMessage();
		System.out.println("Expected Error: " + errorMessage);
		System.out.println("Actual Error: " + actualError);
		Assert.assertEquals(actualError, errorMessage, "Error message mismatch!");
		BaseSteps.closeBrowser();
	}

	//-------------------------scenario 4----------------------------------------
	@Given("User is on the Practo homepage")
	public void user_is_on_the_practo_homepage() {

		BaseSteps.launchBrowser();
		page = new userpage(BaseSteps.getDriver());

	}
	@And("User navigates to the Search for Clinics page")
	public void user_navigates_to_the_search_for_clinics_page() {

		UserPage.navigateToClinicsPage();
	}
	@And("User enters a valid role and clicks search")
	public void user_enters_a_valid_role_and_clicks_search() {
		// Role comes from properties file (no hardcoding)
		String role = PropertyReader.getProperty("search.role");
		Assert.assertNotNull(role, "Role must be set in properties file");
		UserPage.enterRoleAndSearch(role);
	}

	@And("Clinic results are displayed")
	public void clinic_results_are_displayed() {
		Assert.assertTrue(UserPage.isClinicResultsDisplayed(), "Clinic results are not displayed!");
	}

	@When("User selects a gender in the Gender filter")
	public void user_selects_a_gender_in_the_gender_filter() {

		// Gender comes from properties file (no hardcoding)
		String gender = PropertyReader.getProperty("filter.gender");
		Assert.assertNotNull(gender, "Gender must be set in properties file");
		UserPage.selectGenderFilter(gender);
	}

	@And("User applies the filter")
	public void user_applies_the_filter() {
		UserPage.applyGenderFilter();
	}

	@Then("All displayed doctors should match the selected gender")
	public void all_displayed_doctors_should_match_the_selected_gender() {

		String selectedGender = UserPage.getSelectedGender();
		Assert.assertTrue(UserPage.verifyDoctorsGender(selectedGender),
				"Not all doctors match the selected gender: " + selectedGender);

	}

	@And("Gender filter should remain applied after page refresh")
	public void gender_filter_should_remain_applied_after_page_refresh() {

		driver.navigate().refresh();
		String selectedGender = UserPage.getSelectedGender();
		Assert.assertTrue(UserPage.isGenderFilterStillApplied(selectedGender),
				"Gender filter did not persist after refresh!");
	}

}




