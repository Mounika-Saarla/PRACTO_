package com.stepDefinitionTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	userpage page;
	ExcelReader reader = new ExcelReader();
	String location;
	String speciality;
	String City;
	String Role;

	userpage UserPage = new userpage(driver); // PageFactory initialized in UserPage constructor

	//
	//	ClinicSearchPage clinicSearchPage;
	//	DoctorProfilePage doctorProfilePage;
	//	AppointmentPage appointmentPage;



	//-----------Scenario 1-----------------------
	@Given("User is on the Home page")
	public void user_is_on_the_home_page() {
		BaseSteps.launchBrowser();
		driver = BaseSteps.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		page = new userpage(driver);
	}

	@And("User scrolls to the footer section")
	public void user_scrolls_to_the_footer_section() {
		WebElement footer = page.getFooterSection();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
	}

	@When("The footer should contain a visible link labeled {string}")
	public void footer_should_contain_a_visible_link_labeled(String linkText) {
		Assert.assertTrue(page.isSearchForClinicsLinkVisible(), "Link with text '" + linkText + "' is not visible in the footer.");
	}

	@And("User clicks the {string} link")
	public void user_clicks_the_link(String linkText) {
		page.clickSearchForClinicsLink();

	}

	@And("User applies a location filter {int}")
	public void user_applies_location_filter(Integer rowIndex) throws Exception {
		location = reader.getLocation(rowIndex);
		page.applyLocationFilter(location);
		System.out.println("Applied Location filter: " + location);
	}

	@And("User applies a speciality filter {int}")
	public void user_applies_speciality_filter(Integer rowIndex) throws Exception {
		speciality = reader.getSpeciality(rowIndex);
		page.applySpecialityFilter(speciality);
		System.out.println("Applied Speciality filter: " + speciality);
	}

	@Then("Filtered clinic results should be displayed")
	public void filtered_clinic_results_should_be_displayed() {
		Assert.assertTrue(page.isFilteredResultsDisplayed(), "Filtered clinic results are not displayed.");
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Page Source snippet: " + driver.getPageSource().substring(0, 500));
	}

	// ---------------- Scenario 2 Steps ----------------

	@Given("user launch practo website")
	public void user_launch_practo_website() {
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
		WebElement viewProfileBtn = driver.findElement(By.xpath("//button[contains(text(),'View Profile')]"));
		viewProfileBtn.click();
	}

	@Then("clinic details shouls be displayed")
	public void clinic_details_shouls_be_displayed() {
		// Verify clinic details page is displayed
		WebElement clinicName = driver.findElement(By.xpath("//h1[@data-qa-id='clinic-name']"));
		if (clinicName.isDisplayed()) {
			System.out.println("Clinic details page displayed successfully: " + clinicName.getText());
		} else {
			throw new AssertionError("Clinic details page not displayed");
		}
		driver.quit();
	}

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

@When("user applies a City filter from test data")
    public void user_applies_a_city_filter_from_test_data() throws Exception {
        String sheetName = PropertyReader.getProperty("excelSheetName");
        String city = ExcelReader.getCellData(sheetName, 1, 0);
        page.applyCityFilter(city);
        System.out.println("Applied City filter: " + city);
    }



@When("User applies a Role filter from test data")
  public void user_applies_a_role_filter_from_test_data() throws Exception {
      String sheetName = PropertyReader.getProperty("excelSheetName");
      String role = ExcelReader.getCellData(sheetName, 1, 1);
      page.applyRoleFilter(role);
      System.out.println("Applied Role filter: " + role);
  }



@And("user select a doctor from the search results")
   public void user_select_doctor() {
       page.selectDoctorFromResults();
   }



@And("user click on the {string} button")
    public void user_click_on_button(String buttonText) {
        page.clickButton(buttonText);
    }

    @And("user select a time slot from test data")
    public void user_select_time_slot() throws Exception {
        String sheetName = PropertyReader.getProperty("excelSheetName");
        String timeSlot = ExcelReader.getCellData(sheetName, 1, 2);
        page.selectTimeSlot(timeSlot);
    }



@And("user enter an invalid mobile number from test data")
    public void user_enter_invalid_mobile() throws Exception {
        String sheetName = PropertyReader.getProperty("excelSheetName");
        String invalidMobile = ExcelReader.getCellData(sheetName, 1, 3);
        page.enterInvalidMobile(invalidMobile);
    }

    @Then("user should see an error message in next page from test data")
    public void user_should_see_error_message() throws Exception {
        String sheetName = PropertyReader.getProperty("excelSheetName");
        String expectedError = ExcelReader.getCellData(sheetName, 1, 4);
        String actualError = page.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Error message mismatch!");
        BaseSteps.closeBrowser();
    }

}




