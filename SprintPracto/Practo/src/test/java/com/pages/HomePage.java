package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;

WebDriverWait wait;

    // Constructor
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        PageFactory.initElements(driver, this);
//    }

    @FindBy(linkText = "Lab Tests")
    private WebElement labTestsLink;

    // Locator for current city (header)
    @FindBy(xpath = "//span[contains(@class,'u-text--bold')]")
    private WebElement currentCity;

    @FindBy(xpath = "//a[contains(@href,'lipid-profile-blood')]")
    private WebElement lipidProfileLink;

    
 // Locator for Add to Cart button on Lipid Profile page
    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/div/div")
    private WebElement addToCartButton;

    // Locator for cart item count or confirmation (adjust based on Practo UI)
    @FindBy(xpath = "//span[contains(text(),'1 item')]")
    private WebElement cartItemCount;
    
    @FindBy(xpath = "//span[text()='Your Cart']")
    private WebElement goToCartButton;


@FindBy(xpath = "//input[@placeholder='Search for Tests, Packages and Profiles']")
private WebElement searchBox;

@FindBy(xpath = "//*[@id=\"root-app\"]/div/div/div[2]/div/div[2]/div/div/div")
private WebElement searchResultsContainer;

@FindBy(xpath = "//input[@id='omniSearch']")
private WebElement searchForTests;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLabTests() {
        labTestsLink.click();
    }
    

    public void selectCity(String cityName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
     
        // Click city in header
        WebElement currentCityElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[3]/div/div/div/div/div/div/div/div[3]/ul/li[1]/div[2]")));
        currentCityElement.click();

    }

    public void clickLipidProfile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'lipid-profile-blood')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lipidProfileLink);
        wait.until(ExpectedConditions.elementToBeClickable(lipidProfileLink)).click();
    }
    

    public void clickAddToCart() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(addToCartButton));
         wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
     }
    
    public boolean isItemAddedToCart() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         wait.until(ExpectedConditions.visibilityOf(goToCartButton));
        return wait.until(ExpectedConditions.visibilityOf(goToCartButton)).isDisplayed();
    }

    public void clickTests() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchForTests));
        wait.until(ExpectedConditions.elementToBeClickable(searchForTests)).click();
    }

//public void searchInLipidProfile(String searchItem) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    wait.until(ExpectedConditions.visibilityOf(searchBox)).clear();
//    searchBox.sendKeys(searchItem);
//    searchBox.sendKeys(Keys.ENTER);
//}
//
//public boolean isSearchResultDisplayed(String searchItem) {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    return wait.until(ExpectedConditions.textToBePresentInElement(searchResultsContainer, searchItem));
//}


}

