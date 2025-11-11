package com.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.time.Duration;
import com.parameters.PropertyReader;
import org.testng.Assert;

public class HospitalListPage {
    WebDriver driver;
    WebDriverWait wait;

    public HospitalListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyHospitalListDisplayed() throws Exception {
        By listLocator = By.xpath(PropertyReader.getProperty("hospitalList.properties", "hospitalListSection"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listLocator));
        Assert.assertTrue(driver.findElement(listLocator).isDisplayed(), "Hospital list page not displayed");
    }
    public void verifyCallDisplayed() throws Exception {
        By listLocators = By.xpath(PropertyReader.getProperty("hospitalList.properties", "call"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listLocators));
        Assert.assertTrue(driver.findElement(listLocators).isDisplayed(), "Hospital list page not displayed");
    }
    public void selectHospital() throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("hospitalList.properties", "selectHospital"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalLocator));
        driver.findElement(hospitalLocator).click();
    }
    
//    public void verifyHospitalListPage() throws IOException {
//        String hospitalListXpath = PropertyReader.getProperty("search.properties", "hospitalListHeader");
//        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hospitalListXpath)));
//        Assert.assertTrue(header.isDisplayed(), "Hospital list page is not displayed");
//    }
}
















/*
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.parameters.PropertyReader;

public class HospitalListPage {
    WebDriver driver;

    public HospitalListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyHospitalListDisplayed() throws Exception {
        boolean isDisplayed = driver.findElement(By.xpath(PropertyReader.getProperty("hospitalList.properties", "hospitalListSection"))).isDisplayed();
        Assert.assertTrue(isDisplayed, "Hospital list page not displayed");
    }

//    public void selectHospital() throws Exception {
//        driver.findElement(By.xpath(PropertyReader.getProperty("hospitalList.properties", "selectHospital"))).click();
//    }
    public void selectHospital() throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("hospitalList.properties", "selectHospital"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalLocator));
        driver.findElement(hospitalLocator).click();
    }
}*/

/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.parameters.PropertyReader;
import org.testng.Assert;

public class HospitalListPage {
    WebDriver driver;
    WebDriverWait wait;

    public HospitalListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void verifyHospitalListDisplayed() throws Exception {
        By listLocator = By.xpath(PropertyReader.getProperty("hospitalList.properties", "hospitalListSection"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(listLocator));
        boolean isDisplayed = driver.findElement(listLocator).isDisplayed();
        Assert.assertTrue(isDisplayed, "Hospital list page not displayed");
    }

    public void selectHospital() throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("hospitalList.properties", "selectHospital"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalLocator));
        driver.findElement(hospitalLocator).click();
    }
}*/
