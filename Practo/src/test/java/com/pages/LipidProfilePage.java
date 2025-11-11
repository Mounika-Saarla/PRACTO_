package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LipidProfilePage {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'u-cursor--pointer')]") // City dropdown
    private WebElement cityDropdown;

    @FindBy(xpath = "//li[contains(text(),'Hyderabad')]") // Hyderabad option
    private WebElement hyderabadOption;

    public LipidProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCityDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(cityDropdown));
        ((JavascriptExecutor) driver ).executeScript("arguments[0].scrollIntoView(true);", dropdown);
        dropdown.click();
    }

    public void selectHyderabad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(hyderabadOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
        option.click();
    }
}