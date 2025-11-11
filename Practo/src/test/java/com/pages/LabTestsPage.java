package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LabTestsPage {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(text(),'Lipid Profile')]") // Adjust based on DOM
    WebElement lipidProfileLink;

    public LabTestsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLipidProfileLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(lipidProfileLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lipidProfileLink);
        lipidProfileLink.click();
    }
}