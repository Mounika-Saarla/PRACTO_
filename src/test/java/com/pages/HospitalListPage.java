package com.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.time.Duration;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import org.testng.Assert;

public class HospitalListPage extends BaseSteps{
	
    WebDriverWait wait;
public HospitalListPage(WebDriver driver) {
		super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// TODO Auto-generated constructor stub
	}
//    WebDriver driver;
//
//    public HospitalListPage(WebDriver driver) {
//        this.driver = driver;
//    }

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
    public void clickHospitalCard() throws Exception {
        By hospitalCard = By.xpath(PropertyReader.getProperty("hospitalList.properties", "hospitalLink"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalCard));
        driver.findElement(hospitalCard).click();
    }
    public void verifyHospitalDetailsDisplayed() throws Exception {
        By detailsLocator = By.xpath(PropertyReader.getProperty("hospitalList.properties", "hospitalDetails"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(detailsLocator));
        Assert.assertTrue(driver.findElement(detailsLocator).isDisplayed(), "Hospital Deatils page not displayed");
    }
    public void verifyDetailOverviewDisplayed() throws IOException  {
    	 driver.findElement(By.xpath(PropertyReader.getProperty("hospitalList.properties", "hospitalDetails"))).click();
    }
    
    

}







