package com.pages;


import org.openqa.selenium.*;
import com.parameters.PropertyReader;
import org.testng.Assert;

public class BookingPage extends BasePage{
//    WebDriver driver;

//    public BookingPage(WebDriver driver) {
//        this.driver = driver;
//    }

    public BookingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickBookHospital() throws Exception {
        driver.findElement(By.xpath(PropertyReader.getProperty("booking.properties", "bookButton"))).click();
    }
    public void clickClinic() throws Exception {
        driver.findElement(By.xpath(PropertyReader.getProperty("booking.properties", "clickButton"))).click();
    }

    public void enterDetails(String name, String phone) throws Exception {
        driver.findElement(By.xpath(PropertyReader.getProperty("booking.properties", "nameField"))).sendKeys(name);
        driver.findElement(By.xpath(PropertyReader.getProperty("booking.properties", "phoneField"))).sendKeys(phone);
    }

    public void clickConfirm() throws Exception {
        driver.findElement(By.xpath(PropertyReader.getProperty("booking.properties", "confirmButton"))).click();
    }

    public void verifyErrorMessage() throws Exception {
        boolean errorDisplayed = driver.findElement(By.xpath(PropertyReader.getProperty("booking.properties", "errorMessage"))).isDisplayed();
        Assert.assertTrue(errorDisplayed, "Error message not displayed for invalid booking");
    }
}







