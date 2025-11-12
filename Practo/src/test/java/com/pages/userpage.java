package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class userpage {
    private WebDriver driver;
	private WebDriverWait wait;
    public userpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
        for (int i = 0; i < 3; i++) {				// Retry mechanism for stale element
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
   

//------scenario2
private By clinicsLink = By.xpath("//a[contains(text(),'Clinics')]");
    private By firstClinic = By.xpath("(//div[@class='info-section']//h2)[1]");
    private By viewProfileBtn = By.xpath("//button[contains(text(),'View Profile')]");
    private By clinicName = By.xpath("//h1[@data-qa-id='clinic-name']");

   

    public void selectFirstClinic() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.info-section")));
        WebElement firstClinicElement = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("(//h2[contains(@class,'u-title-font')])[1]"))
        );
        firstClinicElement.click();
    }

    public void user_clicks_on_view_profile_of_first_clinic() {
        wait.until(ExpectedConditions.elementToBeClickable(viewProfileBtn)).click();
    }

    public boolean isClinicDetailsDisplayed() {
        try {
            WebElement clinicElement = wait.until(ExpectedConditions.visibilityOfElementLocated(clinicName));
            System.out.println("Clinic details page displayed successfully: " + clinicElement.getText());
            return true;
        } catch (Exception e) {
            System.out.println("Clinic details page not displayed: " + e.getMessage());
            return false;
        }
    }

//---------------scenario3-------------------------

 // ----- scenario3 -----

//    private By searchClinicsLink = By.linkText("Search for Clinics");
//       private By locationField = By.id("location");
//       private By specialityField = By.id("speciality");
//       private By searchButton = By.id("search");
//       private By firstDoctorCard = By.cssSelector(".doctor-card");
//       private By bookClinicVisitBtn = By.xpath("//button[contains(text(),'Book clinic visit')]");
//       private By mobileField = By.id("mobile");
//       private By continueBtn = By.xpath("//button[contains(text(),'Continue')]");
//       private By errorMessageElement = By.cssSelector(".error-message");
//
//
//       public void clickFooterLink(String linkText) {
//              wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText))).click();
//          }
//       public void enterLocation(String location) {
//             wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location"))).sendKeys(location);
//         }
//public void enterSpeciality(String speciality) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("speciality"))).sendKeys(speciality);
//    }
//       public void clickSearch() {
//           wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
//       }
//public void selectDoctorFromResults() {
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".doctor-card"))).click();
//    }
//
//
////       public void clickButton(String buttonText) {
////           if (buttonText.equalsIgnoreCase("Book clinic visit")) {
////               wait.until(ExpectedConditions.elementToBeClickable(bookClinicVisitBtn)).click();
////           } else if (buttonText.equalsIgnoreCase("Continue")) {
////               wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
////           }
////       }
//
//public void clickButton(String buttonText) {
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'" + buttonText + "')]"))).click();
//    }
//
//
////       public void selectTimeSlot(String timeSlot) {
////           WebElement slot = wait.until(ExpectedConditions.elementToBeClickable(
////               By.xpath("//span[contains(text(),'" + timeSlot + "')]")));
////           slot.click();
////       }
//
//public void selectTimeSlot(String timeSlot) {
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + timeSlot + "')]"))).click();
//    }
//
//
////       public void enterMobileNumber(String mobile) {
////           wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField)).sendKeys(mobile);
////       }
////
////       public String getErrorMessage() {
////           return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageElement)).getText();
////       }
//
//
//public void enterInvalidMobile(String mobile) {
//       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileField"))).sendKeys(mobile);
//   }
//
//   public String getErrorMessage() {
//       return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message"))).getText();
//   }

// private By searchForClinicsLink = By.linkText("Search for Clinics");
    private By locationField = By.id("location");
    private By specialityField = By.id("speciality");
    private By searchButton = By.id("search");
    private By firstDoctorCard = By.cssSelector(".doctor-card");
    private By mobileField = By.id("mobileField");
    private By errorMessageElement = By.cssSelector(".error-message");

//    public UserPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }

    public WebElement getFooterSection1() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(searchForClinicsLink));
    }
//
   
//    public void enterLocation(String location) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locationField));
//        ((WebElement) driver).sendKeys(location);
//    }
//
//    public void enterSpeciality(String speciality) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(specialityField)).sendKeys(speciality);
//    }

    public void clickSearchForClinicsLink1() {
        WebElement footerLink = wait.until(ExpectedConditions.presenceOfElementLocated(searchForClinicsLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerLink);
        wait.until(ExpectedConditions.elementToBeClickable(searchForClinicsLink)).click();
    }


    public void selectDoctorFromResults() {
           wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".doctor-card"))).click();
       }



    public void clickButton(String buttonText) {
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'" + buttonText + "')]"))).click();
       }


    public void selectTimeSlot(String timeSlot) {
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'" + timeSlot + "')]"))).click();
       }


    public void enterInvalidMobile(String mobile) {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileField"))).sendKeys(mobile);
       }


    public String getErrorMessage() {
           return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-message"))).getText();
       }


    public void applyCityFilter(String city) {
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'" + city + "')]"))).click();
       }

public void applyRoleFilter(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'" + role + "')]"))).click();
    }




}


