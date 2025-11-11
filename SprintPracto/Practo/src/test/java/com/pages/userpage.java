package com.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userpage {
    static WebDriver driver;

    public userpage(WebDriver driver) {
        this.driver = driver;
    }
    private static By filteredResults = By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");
    private static By footerSection = By.tagName("footer");
    private static By searchForClinicsLink = By.linkText("Search for clinics");
    private static By locationFilter = By.xpath("//input[@placeholder='Search location']");
    private static By specialityFilter = By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']");

    public WebElement getFooterSection() {
        return driver.findElement(footerSection);
    }

    public boolean isSearchForClinicsLinkVisible() {
        return driver.findElement(searchForClinicsLink).isDisplayed();
    }

    public void clickSearchForClinicsLink() {
        driver.findElement(searchForClinicsLink).click();
    }

    public void applyLocationFilter(String location) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for location input to be visible
        WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locationFilter));
        locationElement.clear();
        locationElement.sendKeys(location);
        // Wait for suggestion dropdown
        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(text(),'" + location + "')]")
        ));
        suggestion.click();
    }
    

    public void applySpecialityFilter(String speciality) {
        WebElement specialityElement = driver.findElement(specialityFilter);
        specialityElement.clear();
        specialityElement.sendKeys(speciality);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Retry mechanism for stale element
        for (int i = 0; i < 3; i++) {
            try {
                WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'" + speciality + "')]")
                ));
                suggestion.click();
                break; // Exit loop if click succeeds
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element detected. Retrying...");
            }
        }
    }

    public boolean isFilteredResultsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(filteredResults));
            return driver.findElements(filteredResults).size() > 0;
        } catch (TimeoutException e) {
            System.out.println("Results not loaded within timeout. Check selector or page behavior.");
            return false;
        }
    }
    

 // ---------------- Scenario 2 Methods ----------------

    private static By clinicDetailsHeader = By.xpath("//h1[contains(text(),'Clinic Details')]");
    private static By firstDoctorCard = By.xpath("//div[@class='doctor-card'][1]");
    private static By doctorDetailsHeader = By.xpath("//h1[contains(text(),'Doctor Details')]");
    private static By timeSlotButton = By.xpath("//button[contains(text(),'Morning Slot')]");
    private static By bookAppointmentButton = By.xpath("//button[contains(text(),'Book Appointment')]");
    private static By appointmentBookingHeader = By.xpath("//h1[contains(text(),'Appointment Booking')]");
    private static By selectedDoctorInfo = By.xpath("//div[@class='selected-doctor']");
    private static By selectedSlotInfo = By.xpath("//div[@class='selected-slot']");

    public boolean isClinicDetailsPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(clinicDetailsHeader)).isDisplayed();
    }

    public void selectDoctor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(firstDoctorCard)).click();
    }

    public boolean isDoctorDetailsPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(doctorDetailsHeader)).isDisplayed();
    }

    public void selectTimeSlot() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(timeSlotButton)).click();
    }

    public void proceedToAppointmentBooking() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(bookAppointmentButton)).click();
    }

    public boolean isAppointmentBookingPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(appointmentBookingHeader)).isDisplayed();
    }

    public boolean verifyDoctorAndTimeSlot() {
        return driver.findElement(selectedDoctorInfo).isDisplayed() &&
               driver.findElement(selectedSlotInfo).isDisplayed();
    }

}
