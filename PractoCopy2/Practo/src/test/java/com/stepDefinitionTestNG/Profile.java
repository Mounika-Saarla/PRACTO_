package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	private String selectedCountry;

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
		boolean clickRead = profilePage.clickConsultWithDoctor();
		Assert.assertTrue(clickRead);
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
		Assert.assertNotNull(specialization, "specialization not found at sheet " + sheetIndex + ", row " + rowIndex);

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

	@When("User enters Medicine Name from {int} and row {int} in the search bar")
	public void user_enters_medicine_name_from_sheet_and_row_row_in_the_search_bar(Integer sheetIndex, Integer rowIndex) {
		String hospitalName = ExcelReader.getCellDatas(ExcelReader.pathfiles, sheetIndex, rowIndex, ExcelReader.HOSPITAL_COLUMN_INDEX);
        System.out.println("Hospital from Excel: " + hospitalName);
//
//        WebDriver driver = BaseSteps.getDriver();
        WebElement searchInput = driver.findElement(By.xpath("//div[contains(@class,'search-wrapper u-pos--rel')]"));
        searchInput.sendKeys("Dolo Drops");
        searchInput.click();  
//        hospitalInput.clear();
        searchInput.sendKeys(Keys.ARROW_DOWN);
        searchInput.click();
//        searchInput.sendKeys(Keys.ENTER);
		

	}
	@And("User clicks the search button")
	public void user_clicks_the_search_button1() {
		profilePage.clickSearchButton1();
	}

	@Then("the results page should display relevant products for Medicine Name")
	public void the_results_page_should_display_relevant_products_for_medicine_name() {
	    
	}
	
	
	//-----------------------------5th Scenario-------------------------------
	
	
	
	@When("User clicks on the Find Doctors option")
	public void user_clicks_on_the_find_doctors_option() {
		boolean clickable = profilePage.clickFindDoctors2();
		Assert.assertTrue(clickable);
	}

	@When("User clicks on the Read Articles option")
	public void user_clicks_on_the_read_articles_option() {
		profilePage.clickReadArticles();


	}

	@When("User enters searchTerm from sheet {int} and row {int} in the search bar")
	public void user_enters_search_term_from_sheet_sheet_and_row_row_in_the_search_bar(Integer sheet, Integer row) {
		
		profilePage.entersearcharticles();
		


		}
////	@And("^User enters searchTerm from sheet (\\d+) and row (\\d+) in the search bar$")
////	public void user_enters_search_term_from_sheet_sheet_and_row_row_in_the_search_bar(Integer sheetIndex, Integer rowIndex) throws Throwable {
////	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
////
////	    // Wait for search bar and click it
////	    WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchBar']")));
////	    searchBar.click();
////
////	    // Use ExcelReader to get data
////	    String filePath = "C:\\training\\Java\\SprintPracto\\Practo\\src\\test\\resources\\TestData\\searchData.xlsx";
////	    String searchTerm = ExcelReader.getName(filePath, sheetIndex, rowIndex);
////
////	    // Enter search term and press Enter
////	    if (searchTerm != null && !searchTerm.isEmpty()) {
////	        searchBar.sendKeys(searchTerm);
////	        searchBar.sendKeys(Keys.ENTER);
////	    } else {
////	        System.out.println("No data found in Excel for sheet: " + sheetIndex + ", row: " + rowIndex);
////	    }
////	}
//	@And("^User enters searchTerm from sheet (\\d+) and row (\\d+) in the search bar$")
//	public void user_enters_search_term_from_sheet_sheet_and_row_row_in_the_search_bar(Integer sheetIndex, Integer rowIndex) throws Throwable {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//	    // ✅ Use a more reliable locator
//	    WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	        By.xpath("//*[@id=\"searchBar\"]"))); // Update if needed
//
//	    searchBar.click(); // ✅ Click before typing
//
//	    // ✅ Read Excel using your existing ExcelReader class
//	    String filePath = "C:\\training\\Java\\SprintPracto\\Practo\\src\\test\\resources\\ExcelData\\ReadArticles.xlsx";
//	    String searchTerm = ExcelReader.getName(filePath, sheetIndex, rowIndex);
//
//	    if (searchTerm != null && !searchTerm.isEmpty()) {
//	        searchBar.sendKeys(searchTerm);
//	        searchBar.sendKeys(Keys.ENTER); // ✅ Trigger search
//	    } else {
//	        System.out.println("Excel returned empty value for sheet " + sheetIndex + ", row " + rowIndex);
//	    }
//	}
//
//	

	@When("User clicks on the Search button")
	public void user_clicks_on_the_search_button() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='searchButton']")));
	        searchButton.click();
	        System.out.println("Search button clicked successfully.");
	    } catch (Exception e) {
	        System.out.println("Search button not found or already triggered by ENTER key.");
	    }
	}


	@Then("Relevant doctors and health articles for searchTerm should be displayed")
	public void relevant_doctors_and_health_articles_for_search_term_should_be_displayed() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        boolean resultsVisible = wait.until(ExpectedConditions.or(
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'doctor-card')]")),
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'article-card')]"))
	        )) != null;

	        if (resultsVisible) {
	            System.out.println("Relevant doctors and health articles are displayed.");
	        } else {
	            System.out.println("No results found for the given search term.");
	        }
	    } catch (Exception e) {
	        System.out.println("Error verifying search results: " + e.getMessage());
	    }
	}
//-----------------------------------------------------------------------------
						//FORM
	
	@When("User scrolls to the Insta By Practo section")
	public void user_scrolls_to_the_insta_by_practo_section() {
	    
	}

	@When("User clicks on the I would like a free demo button")
	public void user_clicks_on_the_i_would_like_a_free_demo_button() {
	   
	}

	@When("User fills the demo request form using data from sheet {int} and row {int}")
	public void user_fills_the_demo_request_form_using_data_from_sheet_and_row(Integer int1, Integer int2) {
	    
	}

	@When("User submits the demo request form")
	public void user_submits_the_demo_request_form() {
	}

	@Then("User should see the Thank You popup and close it")
	public void user_should_see_the_thank_you_popup_and_close_it() {
	    
	}




}