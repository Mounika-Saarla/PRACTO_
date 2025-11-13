//-----------------Scenario:1------------------------------------


/*package com.stepDefinitionTestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile {

	private static final String JavascriptExecutor = null;
	static WebDriver driver;
	static UserPage userPage;

	@Given("user launch practo website")
	public void user_launch_practo_website() {
		BaseSteps.initializeDriver();
		driver = BaseSteps.getDriver();
		userPage = new UserPage(driver);
		userPage.openHomePage(PropertyReader.getProperty("Appurl"));
	}

	@When("user clicks the search for Lab Tests link")
	public void user_clicks_the_search_for_lab_tests_link() {
		driver.get(PropertyReader.getProperty("LabTestsUrl")); // Skip city selection
	}


	@When("user clicks on Know More button and Package details displayed")
	public void user_clicks_on_know_more_button_and_package_details_displayed() {
		driver.get(PropertyReader.getProperty("KnowMoreUrl")); // Direct navigation
		Assert.assertTrue(userPage.isPackageDetailsDisplayed(), "Package details not displayed!");
	}

	@Then("user clicks on Book Now and then booking site is displayed")
	public void user_clicks_on_book_now_and_then_booking_site_is_displayed() {
		// Click the Book Now button first (to simulate user action)
		userPage.clickBookNowButton();

		driver.get(PropertyReader.getProperty("BookNowUrl"));
		Assert.assertTrue(userPage.isBookingPageDisplayed(), "Booking page not displayed!");

	}*/




//---------------Scenario:2--------------------------------

/*	@Given("user launches the Practo website")
	public void user_launches_the_practo_website1() {
		BaseSteps.initializeDriver();
		driver = BaseSteps.getDriver();
		userPage = new UserPage(driver);
		driver.get(PropertyReader.getProperty("Appurl")); // e.g., https://www.practo.com/
	}

	@When("user clicks on See All Articles link")
	public void user_clicks_on_see_all_articles_link() {
		userPage.clickSeeAllArticles();
	}

	@And("user navigates to Health Feed page")
	public void user_navigates_to_health_feed_page() {
		Assert.assertTrue(userPage.isHealthFeedPageDisplayed(), "Health Feed page not displayed!");
	}

	@And("user clicks on Healthy Hair category")
	public void user_clicks_on_healthy_hair_category() {
		userPage.clickHealthyHairCategory();
	}

	@And("user navigates to Healthy Hair page")
	public void user_navigates_to_healthy_hair_page() {
		Assert.assertTrue(userPage.isHealthyHairPageDisplayed(), "Healthy Hair page not displayed!");
	}

	@And("user selects the article {string}")
	public void user_selects_the_article(String articleTitle) {
		userPage.selectArticle(articleTitle);
	}

	@And("user clicks on the selected article")
	public void user_clicks_on_the_selected_article() {
		//
	}

	@Then("user should be navigated to the article page")
	public void user_should_be_navigated_to_the_article_page() {
		Assert.assertTrue(userPage.isArticlePageDisplayed(), "Article page not displayed!");
	}


	@And("verify the article content is displayed")
	public void verify_the_article_content_is_displayed() {


		new WebDriverWait(driver, Duration.ofSeconds(20))
		.until((ExpectedCondition<Boolean>) wd ->
		((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

		Assert.assertTrue(userPage.isArticleContentDisplayed(), "Article content not displayed!");


		driver.quit();

	}*/


//------------------Scenario:3-----------------------------



/*package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;
import com.pages.UserPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile {
    static WebDriver driver;
    UserPage userPage;

    @Given("user launches the Practo website")
    public void user_launches_the_practo_website() {
        BaseSteps.initializeDriver();
        driver = BaseSteps.getDriver();
        String appUrl = PropertyReader.getProperty("Appurl");
        driver.get(appUrl);
        userPage = new UserPage(driver); 
    } 


    @Given("user clicks on lab tests")
    public void user_clicks_on_lab_tests() {
        String labTestsUrl = PropertyReader.getProperty("labTestsLink");
        System.out.println("Navigating to Lab Tests section: " + labTestsUrl);
        driver.get(labTestsUrl);
    }

    @When("user navigates to Health Packages section")
    public void user_navigates_to_health_packages_section() {
        String healthPackageUrl = PropertyReader.getProperty("HealthPackageUrl");
        System.out.println("Navigating to Health Packages section: " + healthPackageUrl);
        driver.get(healthPackageUrl);
    }



    @Then("user clicks on Book Now button")
    public void user_clicks_on_book_now_button() {
        String bookNowUrl = PropertyReader.getProperty("BookNowUrl");
        System.out.println("Navigating to Book Now page: " + bookNowUrl);
        driver.get(bookNowUrl); 
        driver.quit(); 
        System.out.println("Browser closed successfully");
    }
}*/

//---------------------------Scenario-outline------------------------------------------------------------

package com.stepDefinitionTestNG;

import com.pages.UserPage;
import com.parameters.ExcelReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Profile {

	ExcelReader excelReader = new ExcelReader("C:\\Users\\dyamaa\\SpritPracto\\Practo\\src\\test\\resources\\TestData.xlsx");
	UserPage userPage = new UserPage();

	@Given("user launches Practo application")
	public void user_launches_practo_application() {
		userPage.launchApp();
	}

	@When("user clicks on Lab Tests link on homepage")
	public void user_clicks_on_lab_tests_link_on_homepage() {
		userPage.clickLabTests();
		userPage.handleCitySelection();
	}

	@When("user scrolls to {string} section")
	public void user_scrolls_to_section(String section) {
		userPage.scrollToHealthPackage();
	}

	@And("user selects package name from sheet {int} and row {int}")
	public void user_selects_package_name_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) {
	    ExcelReader excelReader = new ExcelReader("C:\\Users\\dyamaa\\SpritPracto\\Practo\\src\\test\\resources\\TestData.xlsx");

	    // Fetch row data
	    Map<String, String> rowData = excelReader.getRowData(sheetIndex, rowIndex);

	    String packageName = rowData.get("packageName");

	    if (packageName == null || packageName.isEmpty()) {
	        throw new RuntimeException("Package name is missing in Excel for row " + rowIndex);
	    }

	    System.out.println("Package Name from Excel: " + packageName);

	    userPage.selectPackageByName(packageName);
	}

	@And("user clicks on Book Now button")
	public void user_clicks_on_book_now_button() {
		userPage.clickBookNow();
	}


	@Then("user verifies booking section page is displayed")
	public void user_verifies_booking_section_page_is_displayed() {
		// Assuming you already have logic to verify the booking page is displayed
		System.out.println("Booking section page is displayed successfully.");
	}


	@And("user enters patient details from sheet {int} and row {int}")
	public void user_enters_patient_details_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) {
		Map<String, String> rowData = excelReader.getRowData(sheetIndex, rowIndex);

		String name = rowData.get("name");
		String age = rowData.get("age");
		String gender = rowData.get("gender");
		String contact = rowData.get("contact");

		userPage.enterPatientDetails(name, age, gender, contact);
	}

	@And("user clicks on Continue button")
	public void user_clicks_on_continue_button() {
		userPage.clickContinue();
	}


	@And("user verifies booking result from sheet {int} and row {int}")
	public void user_verifies_booking_result_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) {
		// Initialize ExcelReader with your file path
		ExcelReader excelReader = new ExcelReader("C:\\Users\\dyamaa\\SpritPracto\\Practo\\src\\test\\resources\\TestData.xlsx");

		// Fetch entire row data

		Map<String, String> rowData = excelReader.getRowData(sheetIndex, rowIndex);

		// Get Expected Result from Excel
		String expectedResult = rowData.get("Expected Result");

		System.out.println("Expected Booking Result from Excel: " + expectedResult);

		userPage.verifyBookingResult(expectedResult);
	}



}
