

package com.pages;
 
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.ExcelReader;
import com.setup.BaseSteps;
 
public class ProfilePage {
 
    private By findDoctorsLink = By.linkText("Find Doctors");
    private By searchField = By.xpath("//input[@data-qa-id='omni-searchbox-keyword']");
    private By doctorResults = By.xpath("//div[contains(@data-qa-id,'doctor-card')]");
 
    public void clickFindDoctors() {
        WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findDoctorsLink)).click();
    }
 
    public void enterSpecialization() throws IOException {

        String specialization = ExcelReader.getSpecializationFromExcel(); // Reads "Dentist" from Excel
        

        WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(10));
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        box.clear();
        box.sendKeys(specialization);
    }
 
 
    public void clickCorrectSearchResult(String specialization) {
    	 
        WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(10));
     
        String dynamicXpath =
            "//div[@class='c-omni-suggestion-item']//div[@data-qa-id='omni-suggestion-main' and normalize-space()='" 
            + specialization + "']/ancestor::div[@class='c-omni-suggestion-item']";
     
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath))).click();
    }
 
    public boolean areDoctorResultsVisible() {
        WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(10));
        List<WebElement> results =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(doctorResults));
        return results.size() > 0;
    }
}
 