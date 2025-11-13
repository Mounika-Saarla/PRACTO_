package com.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.ExcelReader;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

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

//@FindBy(xpath = "//input[@class='c-search__input']")
@FindBy(css = "#omniSearch")
private WebElement searchForTests;
    
@FindBy(xpath = "//span[text()='Your Cart']")
private WebElement testVerify;


public HomePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Initialize wait
    PageFactory.initElements(driver, this);
}


    public void clickLabTests() {
    	wait.until(ExpectedConditions.elementToBeClickable(labTestsLink));
    	wait.until(ExpectedConditions.visibilityOf(labTestsLink));
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
    
    
    //Ts_03
    
    Map<String, String> formData;

    public void clickTests() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //By searchBoxLocator = By.xpath("//input[@id='omniSearch']");
        By searchBoxLocator =By.cssSelector("#omniSearch");
        
        WebElement searchBox = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(searchBoxLocator)));
        searchBox.click();
    }
    
//    public void enterTest(String testData) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        By searchBoxLocator = By.cssSelector("#omniSearch");
//        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(searchBoxLocator));
//        searchBox.clear();
//        searchBox.sendKeys(testData);
//        System.out.println("DEBUG: Sent to search box -> " + testData);
//    }
    public void enterTest(String[] TestName) throws IOException   {
   
    	//String[] path = ExcelReader.getRowData(sheet, row);
    	
    	// wait.until(ExpectedConditions.visibilityOf(searchForTests));
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 ((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchForTests);
    	 
    //   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(searchForTests));
        //searchBox.clear();
        searchBox.sendKeys(TestName);
        System.out.println("DEBUG: Sent to search box -> " + TestName);
    }
    public void verifyTest() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(testVerify));
        wait.until(ExpectedConditions.visibilityOf(testVerify)).isDisplayed();
    }
    /*
     * public boolean checkboxSecondLaptop(int sheetNo, int rowNum) throws IOException {
        boolean actResult = true;
        try {
        	String[] firstCheckboxXpath = ExcelReader.getRowData(sheetNo, rowNum); // Assuming row 3 = second checkbox
            wait.until(ExpectedConditions.visibilityOf(secondCheckbox));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", secondCheckbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", secondCheckbox);
            Reports.generateReport(driver, test, Status.PASS, "Clicked second checkbox for second laptop");
        }
        catch (TimeoutException | ElementClickInterceptedException e)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click second checkbox: " + e.getMessage());
        }
        return actResult;
    }
 
 
     */
//    public void clickTests() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(searchForTests));
//        wait.until(ExpectedConditions.elementToBeClickable(searchForTests)).click();
//    }
    
//    public void enterTest(String sheet,String row) throws InterruptedException
//    {
//    	wait.until(ExpectedConditions.visibilityOf(searchForTests));
//		 //  clickElement(trainingNeed);
//		   //trainingNeed.sendKeys(excelData.get(rowIndex)[2]);
//		   int rowNum = Integer.parseInt(row);
//		    formData = ExcelReader.getRowData(sheet, rowNum);
//		   searchForTests.sendKeys(formData.get("Tests"));
//    }
    
    
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

