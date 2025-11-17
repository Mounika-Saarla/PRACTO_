
package com.pages;


import org.openqa.selenium.*;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import org.testng.Assert;

public class BookingPage extends BaseSteps{

	public BookingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickBookHospital() throws Exception {
        driver.findElement(By.xpath(PropertyReader.getProperty("profile.properties", "bookButton"))).click();

        
    }
	public void clickBookClinic() throws Exception {
		boolean suggest =driver.findElement(By.xpath(PropertyReader.getProperty("profile.properties", "bookButtonHos"))).isDisplayed();
		Assert.assertTrue(suggest, "Error message not displayed for invalid suugest");
	}
	
	
    public void clickClinic() throws Exception {
        driver.findElement(By.xpath(PropertyReader.getProperty("profile.properties", "clickClinicButton"))).click();
    }

    public void enterDetails(String name, String phone) throws Exception {
        driver.findElement(By.xpath(PropertyReader.getProperty("profile.properties", "nameField"))).sendKeys(name);
        driver.findElement(By.xpath(PropertyReader.getProperty("profile.properties", "phoneField"))).sendKeys(phone);
    }

    public void clickConfirm() throws Exception {
        driver.findElement(By.xpath(PropertyReader.getProperty("profile.properties", "confirmButton"))).click();
    }

    public void verifyErrorMessage() throws Exception {
        boolean errorDisplayed = driver.findElement(By.xpath(PropertyReader.getProperty("profile.properties", "errorMessage"))).isDisplayed();
        Assert.assertTrue(errorDisplayed, "Error message not displayed for invalid booking");
    }
}







