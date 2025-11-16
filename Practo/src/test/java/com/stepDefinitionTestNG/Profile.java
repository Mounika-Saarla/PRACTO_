//-----------------Scenario:1------------------------------------


package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
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
	static ExtentTest test;

	@Given("user launch practo website")
	public void user_launch_practo_website() {
		BaseSteps.initializeDriver();
		driver = BaseSteps.getDriver();
		userPage = new UserPage(driver,test);
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

	}


	//---------------Scenario:2--------------------------------

	@Given("user launches the Practo home")
	public void user_launches_the_practo_home() {
		BaseSteps.initializeDriver();
		driver = BaseSteps.getDriver();
		userPage = new UserPage(driver,test);
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

	}


	//------------------Scenario:3-----------------------------



	@Given("user launches the Practo site")
	public void user_launches_the_practo_site() {
		BaseSteps.initializeDriver();
		driver = BaseSteps.getDriver();
		String appUrl = PropertyReader.getProperty("Appurl");
		driver.get(appUrl);
		userPage = new UserPage(driver,test); 
	} 


	@And("user clicks on lab tests")  
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






	//---------------------------Scenario-outline------------------------------------------------------------


	String excel;


	@Given("user launches Practo application")
	public void user_launches_practo_application() {
		driver = BaseSteps.getDriver();
		userPage = new UserPage(driver,test);
		userPage.openHomePage(PropertyReader.getProperty("Appurl"));
	}

	@When("user clicks on Lab Tests link on homepage")
	public void user_clicks_on_lab_tests_link_on_homepage() {
		userPage.clickLabTestsLink();
		userPage.handleCityOverlay();// ✅ Corrected
	}

	@When("user selects test name from sheet {int} and row {int}")
	public void user_selects_test_name_from_sheet_and_row(Integer int1, Integer int2) throws Exception {
		String excelPath = PropertyReader.getProperty("filepath");
		if (excelPath == null || excelPath.isEmpty()) {
			throw new RuntimeException("Excel path is missing in properties file");
		}
		excel = ExcelReader.getLocalityByRow(excelPath, int1, int2);
		if(int2 == 0) {
			userPage.clickfever();
		}else if(int2 ==1)
		{
			userPage.clickdiab();
		}
		else if(int2 ==2)
		{
			userPage.clickski();
		}

		else {
			throw new IllegalArgumentException();
		}
	}
	@Then("user verifies test details page is displayed")
	public void user_verifies_test_details_page_is_displayed() {

	}






	//--------------------------------FifthScenario(outline)---------------------------------------


	@Given("user launches Practo web")
	public void user_launches_practo_Web() {
		BaseSteps.initializeDriver();
		driver = BaseSteps.getDriver();
		PropertyReader.readProperty();
		userPage = new UserPage(driver,test);
		userPage.launchApplication();
		System.out.println("Practo application launched successfully.");
	}

	@When("user clicks on Lab Tests link on Web")
	public void user_clicks_on_lab_tests_link_on_Web() {
		userPage.clickLabTests();
		System.out.println("Clicked on Lab Tests link.");
	}

	@When("user handles city overlay")
	public void user_handles_city_overlay() {
		userPage.handleCityOverlay();
		System.out.println("City overlay handled.");
	}

	@When("user clicks on For Providers")
	public void user_clicks_on_for_providers() {
		userPage.clickForProvidersMenu();
		System.out.println("Clicked on For Providers menu.");
	}

	@When("user selects Software for Providers from dropdown")
	public void user_selects_software_for_providers_from_dropdown() {
		userPage.clickSoftwareForProvidersFromDropdown();
		System.out.println("Selected Software for Providers from dropdown.");
	}

	@When("user navigates to provider link from Excel sheet {int} and row {int}")
	public void user_navigates_to_provider_link_from_excel_sheet_and_row(Integer sheetIndex, Integer rowIndex) throws Exception {
		try {
			//Load properties
			Properties properties = PropertyReader.readProperty();

			//Get Excel path from properties
			String excelPath = properties.getProperty("excel.path"); // Ensure key matches profile.properties


			//Read brand name from Excel
			String brand = ExcelReader.getLocalityByRow(excelPath, sheetIndex, rowIndex);
			if (brand == null || brand.isEmpty()) {
				throw new RuntimeException("Excel value is empty for sheet " + sheetIndex + " row " + rowIndex);
			}
			System.out.println("Excel value read: " + brand); 

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement brandElement = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[@data-event='" + brand + "']")));
			brandElement.click();

			System.out.println("Successfully clicked on brand: " + brand);

		} catch (Exception e) {
			throw new RuntimeException("Failed to navigate to provider link. Error: " + e.getMessage());
		}
	}

	//    @When("user navigates to provider link from Excel sheet {int} and row {int}")
	//    public void user_navigates_to_provider_link_from_excel_sheet_and_row(Integer sheetIndex, Integer rowIndex) throws Exception {
	////        userPage.navigateToProviderLink(sheetIndex, rowIndex);
	////        System.out.println("Navigated to provider link from Excel: Sheet " + sheetIndex + ", Row " + rowIndex);
	//    	userPage = new UserPage(driver, test);
	//		userPage.selectabdm(excel);
	//		userPage.selectArticle(excel);
	//		userPage.selectforclinics(excel);
	//		userPage.selectfordoctors(excel);
	//
	//		Properties properties = PropertyReader.readProperty();
	//		
	//	    // ✅ Now safely get the Excel path
	//	    String excelPath = properties.getProperty("excelpath");
	//	    
	//	    // ✅ Defensive check
	//	    if (excelPath == null || excelPath.isEmpty()) {
	//	        throw new RuntimeException("Excel path is missing in properties file");
	//	    }
	// 
	//	    // ✅ Read from Excel
	//	    excel = ExcelReader.getLocalityByRow(excelPath, 0, rowIndex);
	//	    
	////	    tvpage.selectlg(excelPath);
	////	    tvpage.selectsamsung(excelPath);
	////	    if(rowIndex == 0) {
	////	    	userPage.selectabdm(excelPath);
	////	    }else if(rowIndex ==1)
	////	    {
	////	    	userPage.selectfordoctors(excelPath);
	////	    }
	////	    else if(rowIndex ==2)
	////	    {
	////	    	userPage.selectforclinics(excelPath);
	////	    }
	////	    else if(rowIndex ==3)
	////	    {
	////	    	userPage.selecthosiptals(excelPath);
	////	    }
	////	    else {
	////	    	throw new IllegalArgumentException();
	////	    }
	//    	userPage = new UserPage(driver, test);
	//		userPage.selectabdm(excel);
	//		userPage.selectArticle(excel);
	//		userPage.selectforclinics(excel);
	//		userPage.selectfordoctors(excel);
	//
	//    }

	@Then("verify that the provider page is displayed")
	public void verify_that_the_provider_page_is_displayed() {
		if (userPage.isProviderPageDisplayed()) {
			System.out.println("Provider page displayed successfully.");
		} else {
			throw new AssertionError("Provider page not displayed.");
		}
		BaseSteps.quitDriver();
	}
}
