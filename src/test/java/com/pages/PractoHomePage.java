package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PractoHomePage {
    WebDriver driver;

    public PractoHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By practoLogo = By.xpath("//img[@alt='Practo']"); // Adjust locator if needed

    public boolean isHomePageDisplayed() {
        return driver.findElement(practoLogo).isDisplayed();
    }
}