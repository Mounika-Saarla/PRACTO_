package com.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}














/*public class BasePage {
	
//    WebDriver driver;
//
//    public BasePage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    private By practoLogo = By.xpath("//img[@alt='Practo']"); // Adjust locator if needed
//
//    public boolean isHomePageDisplayed() {
//        return driver.findElement(practoLogo).isDisplayed();
//    }
	
    public WebDriver getDriver() {
        return BaseSteps.driver;   //  Always get updated driver
    }
 
    public String getPageTitle() {
        return getDriver().getTitle();
    }
 
    public String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }
    
}
*/