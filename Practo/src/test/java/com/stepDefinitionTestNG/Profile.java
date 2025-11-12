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


//------------------Scenario-outline------------------------------



package com.stepDefinitionTestNG;

import io.cucumber.java.en.*;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Map;

public class Profile {
	WebDriver driver;
	UserPage userPage;
	Map<String, String> rowData;

	@Given("user launches the Practo website")
	public void user_launches_the_practo_website() {
		BaseSteps.initializeDriver();
		driver = BaseSteps.getDriver();
		userPage = new UserPage(driver);
		System.out.println("App URL from properties: " + PropertyReader.getProperty("Appurl"));
		System.out.println("Practo website launched");
	}

	@When("user navigates to Health Packages section")
	public void user_navigates_to_health_packages_section() {
		userPage.navigateToHealthPackages();
	}

	@And("user clicks on a package to view details")
	public void user_clicks_on_a_package_to_view_details() throws IOException {
		rowData = ExcelReader.getRowData("src/test/resources/Excel/TestData.xlsx", 1);
		userPage.clickOnPackage(rowData.get("packageName"));
	}

	@Then("verify package details page displays correct info")
	public void verify_package_details_page_displays_correct_info() {
		boolean status = userPage.verifyPackageDetails(rowData.get("packageName"));
		System.out.println("Package details verified: " + status);
	}

	@And("user clicks on Book Now button")
	public void user_clicks_on_book_now_button() {
		userPage.clickBookNow();
	}

	@And("user enters details from row {int}")
	public void user_enters_details_from_row(Integer rowIndex) throws IOException {
		rowData = ExcelReader.getRowData("src/test/resources/Excel/TestData.xlsx", rowIndex);

		UserPage userPage = new UserPage(BaseSteps.getDriver());
		userPage.enterBookingDetails(rowData);
	}



	@And("user submits booking details")
	public void user_submits_booking_details() {
		userPage.submitBooking();
	}

	@Then("validate expected result from row {int}")
	public void validate_expected_result_from_row(Integer rowIndex) throws IOException {
		rowData = ExcelReader.getRowData("src/test/resources/Excel/TestData.xlsx", rowIndex);

		String expectedResult = rowData.get("expectedResult");
		UserPage userPage = new UserPage(BaseSteps.getDriver());
		boolean status = userPage.validateBookingResult(expectedResult);
		System.out.println("Validation Status: " + status);

	}
}
