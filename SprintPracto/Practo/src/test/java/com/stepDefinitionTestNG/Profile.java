package com.stepDefinitionTestNG;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.setup.BaseSteps;
import com.pages.userpage;
import com.parameters.ExcelReader;

import io.cucumber.java.en.*;

public class Profile extends BaseSteps {
    WebDriver driver;
    userpage page;
    ExcelReader reader = new ExcelReader();
    String location;
    String speciality;
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


    @Given("user is on Clinic Details page")
    public void user_is_on_clinic_details_page() {
        driver = BaseSteps.getDriver();
        if (driver == null) {
            BaseSteps.launchBrowser();
            driver = BaseSteps.getDriver();
        }

        // Navigate to Clinic Details page using property
        BaseSteps.navigateToClinicDetailsUrl();
        page = new userpage(driver);

        // Debug logs
        System.out.println("Navigated to Clinic Details URL: " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        // Wait for page load
        new WebDriverWait(driver, Duration.ofSeconds(30))
            .until(webDriver -> ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState").equals("complete"));

        Assert.assertTrue(page.isClinicDetailsPageDisplayed(), "Clinic Details page is not displayed.");
    }

    @When("user selects a doctor and navigates to Doctor Details page")
    public void user_selects_a_doctor_and_navigates_to_doctor_details_page() {
        page.selectDoctor();
        Assert.assertTrue(page.isDoctorDetailsPageDisplayed(), "Doctor Details page is not displayed.");
    }

    @And("user chooses a time slot and proceeds to Appointment Booking page")
    public void user_chooses_a_time_slot_and_proceeds_to_appointment_booking_page() {
        page.selectTimeSlot();
        page.proceedToAppointmentBooking();
        Assert.assertTrue(page.isAppointmentBookingPageDisplayed(), "Appointment Booking page is not displayed.");
    }

    @Then("booking page should display selected doctor and time slot")
    public void booking_page_should_display_selected_doctor_and_time_slot() {
        Assert.assertTrue(page.verifyDoctorAndTimeSlot(), "Doctor and time slot details are incorrect on booking page.");
    }

}