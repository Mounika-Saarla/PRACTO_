package com.pages;
 
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
 
public class LabTestsPage {
    WebDriver driver;
 
    @FindBy(xpath = "a[href*='/tests']") // Adjust based on DOM
    WebElement labTestsLink ;
 
    public LabTestsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void clickLipidProfileLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(labTestsLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", labTestsLink);
        labTestsLink.click();
    }
}