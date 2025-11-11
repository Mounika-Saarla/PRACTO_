  package com.stepDefinitionTestNG;
 
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LabTestsPage;
import com.pages.LipidProfilePage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class Profile extends BaseSteps {
    HomePage homePage;
    LabTestsPage labTestsPage;
    LipidProfilePage  lipidProfilePage;
    
    @Given("user is on Practo Homepage")
    public void user_is_on_practo_homepage() {
        // Hooks already navigates to homepage
        homePage = new HomePage(driver);
    }
 
    @When("user clicks on Lab Tests link")
    public void user_clicks_on_lab_tests_link() {
        homePage.clickLabTestsLink();
        labTestsPage = new LabTestsPage(driver);
    }
 
    @Then("Lab Tests page should be displayed")
    public void lab_tests_page_should_be_displayed() {
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + actualUrl);
        Assert.assertTrue(actualUrl.contains("tests"),
                "Lab Tests page is not displayed correctly! Actual: " + actualUrl);
    }
 
    @When("user clicks on Lipid Profile link")
    public void user_clicks_on_lipid_profile_link() {
        driver.get(prop.getProperty("lipidprofile.url"));
    }
 
    @Then("Lipid Profile page should be displayed correctly")
    public void lipid_profile_page_should_be_displayed_correctly() {
        String expectedUrl = prop.getProperty("lipidprofile.url");
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl),
                "Lipid Profile page is not displayed correctly!");
    }
    @Given("user is on Lipid Profile page")
    public void user_is_on_lipid_profile_page() {
        driver.get(prop.getProperty("lipidprofile.url"));
        lipidProfilePage = new LipidProfilePage(driver);
    }

    @When("user clicks on the city search dropdown")
    public void user_clicks_on_city_search_dropdown() {
        lipidProfilePage.clickCityDropdown();
    }

    @When("user selects Hyderabad from the list")
    public void user_selects_hyderabad_from_the_list() {
        lipidProfilePage.selectHyderabad();
    }

    @Then("the page should update to show Hyderabad as the selected city")
    public void page_should_update_to_show_hyderabad() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("city=hyderabad"),
                "City was not updated to Hyderabad! Current URL: " + currentUrl);
    }
    
}