package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class HomePage extends BaseSteps {
	
public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//    WebDriver driver;
//
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//    }


public void clickSearchForHospitals() throws Exception {
    driver.findElement(By.xpath(PropertyReader.getProperty("home.properties", "searchHospitalsLink"))).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.urlContains("/hospitals"));
}

}