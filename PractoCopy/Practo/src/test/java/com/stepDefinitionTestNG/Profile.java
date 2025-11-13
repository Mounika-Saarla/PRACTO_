package com.stepDefinitionTestNG;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.ProfilePage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {

	WebDriver driver = BaseSteps.driver;
	ExtentTest test = Hooks.test;
	ProfilePage profilePage;
	Properties prop = PropertyReader.readProperty();

	@Given("the user navigates to the Practo website")
	public void the_user_navigates_to_the_practo_website() {
		BaseSteps.driver.get("https://www.practo.com");
		System.out.println("Navigated to Practo website");
	}

	@When("the user opens the Find Doctors page")
	public void the_user_opens_the_find_doctors_page() {
		profilePage = new ProfilePage(driver, test);
		profilePage.clickFindDoctors1();
		System.out.println("Clicked on Find Doctors");
	}
// 
	/*
	 * @And("the user searches for the Dentists") public void
	 * the_user_searches_for_the_dentists() throws IOException { String
	 * specialization = ExcelReader.getSpecializationFromExcel(); // Reads Dentist
	 * from Excel profilePage.enterSpecialization(specialization); // Types Dentist
	 * in search bar profilePage.clickCorrectSearchResult(specialization); // Clicks
	 * Dentist suggestion }
	 */

	@Then("matching doctors should be visible")
	public void matching_doctors_should_be_visible() {

		if (!profilePage.areDoctorResultsVisible()) {
			throw new AssertionError("Doctor results not visible!");
		}

		System.out.println("Doctor results are visible");
	}

	//------------------------------ 1st Scenario---------------------------------------------------

	@Given("User launches the Practo website")
	public void user_launches_the_practo_website() {
		profilePage = new ProfilePage(driver, test);

	}

//
	@When("User clicks on Find Doctors option")
	public void user_clicks_on_find_doctors_option() {
		boolean clickable = profilePage.clickFindDoctors1();
		Assert.assertTrue(clickable);

	}

//@And("User should be on the Find Doctors page")
//public void user_should_be_on_the_find_doctors_page() {
////	String clickable = profilePage.getCurrentUrl();
////	Assert.assertTrue(clickable);
//
//   
//}

	@And("User clicks on Consult with a doctor option")
	public void user_clicks_on_consult_with_a_doctor_option() {
		boolean clickconsult = profilePage.clickConsultWithDoctor();
		Assert.assertTrue(clickconsult);
	}

	@Then("User should be on the Consult with a doctor page")
	public void user_should_be_on_the_consult_with_a_doctor_page() {

	}

//--------------------------------2nd Scenario------------------------------------------------------------------

//@Given("User launches the Practo website")
//public void user_launches_the_practo_website3() {
//	profilePage = new ProfilePage(driver, test);
//	
//
//}

//@When("User clicks on Find Doctors option")
//public void user_clicks_on_find_doctors_option3() {
//boolean clickable = profilePage.clickFindDoctors1();
//Assert.assertTrue(clickable);
//
//
//}

//@And("the user selects Dermatologist from the popular searches section")
//public void the_user_selects_dermatologist_from_the_popular_searches_section() {
//	boolean selected = profilePage.selectPopularSearch("Dermatologist");
//    Assert.assertTrue("Dermatologist should be selectable from popular searches", selected);
//}

	@And("the user selects Dermatologist from the popular searches section")
	public void the_user_selects_dermatologist_from_the_popular_searches_section() {
		boolean selected = profilePage.selectPopularSearch("Dermatologist");
		if (selected) {
			test.pass("Successfully selected 'Dermatologist' from popular searches");
		} else {
			test.fail("Could not select 'Dermatologist' from popular searches");
		}
		Assert.assertTrue(selected);
	}
//
//@Then("the user should be navigated to the Dermatologist listing page")
//public void the_user_should_be_navigated_to_the_dermatologist_listing_page() {
//	String currentUrl = driver.getCurrentUrl();
//    Assert.assertTrue("User should be on Dermatologist listing page", currentUrl.contains("dermatologist"))
//}

	@Then("the user should be navigated to the Dermatologist listing page")
	public void the_user_should_be_navigated_to_the_dermatologist_listing_page() {
		String currentUrl = driver.getCurrentUrl();
		boolean isCorrectPage = currentUrl.toLowerCase().contains("dermatologist");
		if (isCorrectPage) {
			test.pass("User successfully navigated to Dermatologist listing page: " + currentUrl);
		} else {
			test.fail("Navigation failed. Current URL: " + currentUrl);
		}
		Assert.assertTrue(isCorrectPage);
	}

//-------------------------------3rdScenario Outline-----------------------------------------------

	@Given("the user launches the Practo website")
	public void the_user_launches_the_practo_website() {
		// driver.get("https://www.practo.com/");
		BaseSteps.driver.get("https://www.practo.com");

		System.out.println("Navigated to Practo website");
	}

	@And("navigates to the Find Doctors page")
	public void navigates_to_the_find_doctors_page() {
		// profilePage.clickFindDoctors();
		boolean clickable = profilePage.clickFindDoctors1();
		Assert.assertTrue(clickable);
	}

	@When("the user enters specialization from sheet {int} and row {int} in the search bar")

	public void the_user_enters_specialization_from_sheet_and_row_in_the_search_bar(Integer sheetIndex,
			Integer rowIndex) {

		// String specialization = profilePage.getCellData(sheetIndex, rowIndex, 0); //
		// Assuming colIndex = 0
		String excelPathSO = prop.getProperty("ExcelPath");

		// Fetch locality from specific sheet and row
		String specialization = ExcelReader.getName(excelPathSO, sheetIndex, rowIndex);
		Assert.assertNotNull(specialization, "pecialization not found at sheet " + sheetIndex + ", row " + rowIndex);

		profilePage.enterSpecialization(specialization);
	}

	@And("clicks the search button")
	public void clicks_the_search_button() {
		profilePage.clickSearchButton();
	}

	@Then("the results page should display doctors specialized in specialization")
	public void the_results_page_should_display_doctors_specialized_in_specialization() {
		//profilePage.verifyResults();
	}

	
	
	
	//--------------------------------4th Scenario--------------------------------------------------
	
	
	@When("User clicks on Order Medicines")
	public void user_clicks_on_order_medicines() {
		boolean clickOrder = profilePage.clickOrderMeds();
		Assert.assertTrue(clickOrder);
	}

	@When("User enters Medicine Name from <sheet> and row <row> in the search bar")
	public void user_enters_medicine_name_from_sheet_and_row_row_in_the_search_bar(Integer sheetIndex, Integer rowIndex) {
		String excelPath = prop.getProperty("Order");

//	    int sheetIndex = 0; // Replace with dynamic value if needed
//	    int rowIndex = 0;   // Replace with dynamic value if needed

	    String medicineName = ExcelReader.getName(excelPath, sheetIndex, rowIndex);
	    Assert.assertNotNull(medicineName, "Medicine name not found at sheet " + sheetIndex + ", row " + rowIndex);

	    ProfilePage medicinesPage = new ProfilePage(driver, test);
	    medicinesPage.searchMedicine(medicineName);

	}
	@And("clicks the search button")
	public void clicks_the_search_button1() {
		profilePage.clickSearchButton();
	}

	@Then("the results page should display relevant products for Medicine Name")
	public void the_results_page_should_display_relevant_products_for_medicine_name() {
	    
	}
}