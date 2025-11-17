package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.aventstack.extentreports.Status;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;

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
	@FindBy(xpath="//*[@id=\"root\"]/div/div/footer/div/div[1]/div[2]/div[2]/a[3]/span")
	private WebElement searchHospitalsLink;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div[3]/div/div[3]/a[1]")
	private WebElement searchServiceLink;

public void clickSearchForHospitals() throws Exception {
	searchHospitalsLink.click();
//    driver.findElement(By.xpath(PropertyReader.getProperty("profile.properties", "searchHospitalsLink"))).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.urlContains("/hospitals"));
}
public void clickService() throws Exception {
	
	searchServiceLink.click();
//    driver.findElement(By.xpath(PropertyReader.getProperty("profile.properties", "searchServiceLink"))).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.urlContains("/hospitals"));
}


}





