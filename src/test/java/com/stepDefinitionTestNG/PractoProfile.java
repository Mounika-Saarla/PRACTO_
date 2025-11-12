package com.stepDefinitionTestNG;


import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;
import com.pages.BookingPage;
import com.pages.HomePage;
import com.pages.HospitalListPage;
import com.pages.SearchPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PractoProfile {
	WebDriver driver;

	@Given("user launches Practo application")
    public void launchApp() throws Exception {
        BaseSteps.initDriver();
    }

	@When("user clicks on Search for hospitals link on homepage")
    public void clickSearchForHospitals() throws Exception {
        new HomePage(BaseSteps.driver).clickSearchForHospitals();
    }

    @And("user enters city name from Excel and selects suggestions")
    public void enterSearchData() throws Exception {
        String city = ExcelReader.getCellData("Search", 1, 0);
        String hospital = ExcelReader.getCellData("Search", 1, 1);
        SearchPage search = new SearchPage(BaseSteps.driver);
        search.enterCity(city);
//        search.enterHospital(hospital);

//        String city = ExcelReader.getCellData("Search", 1, 0);
//         String hospital = ExcelReader.getCellData("Search", 1, 1);

         // Call combined method
//         SearchPage searchPage = new SearchPage(BaseSteps.driver);
//         searchPage.enterCityAndHospital(city, hospital);


//        String city = excelReader.getCellData("City");
//           String hospital = excelReader.getCellData("Hospital");
//           searchPage.enterCityAndHospital(city, hospital);

    }

    @Then("user verifies hospital list page is displayed")
    public void verifyHospitalList() throws Exception {
        new HospitalListPage(BaseSteps.driver).verifyHospitalListDisplayed();
    }

    @When("user selects a hospital from the list")
    public void selectHospital() throws Exception {
//        new HospitalListPage(BaseSteps.driver).selectHospital();
    }

    @And("user clicks on Book Hospital Visit")
    public void clickBookHospital() throws Exception {
        new BookingPage(BaseSteps.driver).clickBookHospital();
    }
    @When("user click on clinic button")
    public void clickClinic() throws Exception {
        new BookingPage(BaseSteps.driver).clickClinic();
    }

    @Then("user enters booking details from Excel and confirms booking")
    public void enterBookingDetails() throws Exception {
        String name = ExcelReader.getCellData("Booking", 1, 0);
        String phone = ExcelReader.getCellData("Booking", 1, 1);
        BookingPage booking = new BookingPage(BaseSteps.driver);
        booking.enterDetails(name, phone);
        booking.clickConfirm();
    }
    @Then("user looks contact details")
    public void verifyCallList() throws Exception {
    	new HospitalListPage(BaseSteps.driver).verifyCallDisplayed();
    }

//    @Then("user enters invalid booking details from Excel and verifies error message")
//    public void enterInvalidBookingDetails() throws Exception {
//        String name = ExcelReader.getCellData("Booking", 2, 0);
//        String phone = ExcelReader.getCellData("Booking", 2, 1);
//        BookingPage booking = new BookingPage(BaseSteps.driver);
//        booking.enterDetails(name, phone);
//        booking.clickConfirm();
//        booking.verifyErrorMessage();
//    }
    
    
    

    @Then("user clicks hospital card so user see details")
public void clickHospitalCard() throws Exception {
    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
	 new HospitalListPage(BaseSteps.driver).clickHospitalCard();
	
}
    ////////////////////////////////// /////
   
    

//        @When("user enters city name {string} and selects suggestions")
//        public void user_enters_city_name_and_selects_suggestions(String city) throws InterruptedException {
//            WebElement cityInput = driver.findElement(By.xpath("//input[@placeholder='Search city']"));
//            cityInput.sendKeys(city);
//            Thread.sleep(2000); // Wait for suggestions
//            driver.findElement(By.xpath("//div[contains(text(),'" + city + "')]")).click();
//        }


//    @When("user enters city name {string} and selects suggestions")
//    public void user_enters_city_name_and_selects_suggestions(String city) throws InterruptedException {
//        WebElement cityInput = driver.findElement(By.xpath("//input[@placeholder='Enter city']"));
//        cityInput.clear();
//        cityInput.sendKeys(city);
//        Thread.sleep(2000); // Wait for suggestions
//        driver.findElement(By.xpath("//div[contains(text(),'" + city + "')]")).click();
//        System.out.println("City selected: " + city);
//    }
//    @When("user enters city name {string} and selects suggestions")
//    public void user_enters_city_name_and_selects_suggestions(String city) throws InterruptedException {
//        WebElement cityInput = driver.findElement(By.xpath("//input[@placeholder='Enter city']"));
//        cityInput.clear();
//        cityInput.sendKeys(city);
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[contains(text(),'" + city + "')]")).click();
//    }

//    @When("user enters city name {string} and selects suggestions")
//    public void user_enters_city_name_and_selects_suggestions(String city) throws InterruptedException {
//        WebElement cityInput = driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input"));
//        cityInput.clear();
//        cityInput.sendKeys(city);
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[contains(text(),'" + city + "')]")).click();
//    }

//    @When("user enters city name {string} and selects suggestions")
//    public void user_enters_city_name_and_selects_suggestions(String city) throws InterruptedException {
//        WebElement cityInput = driver.findElement(By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input"));
//        cityInput.clear();
//        cityInput.sendKeys(city);
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[contains(text(),'" + city + "')]")).click();
//    }
//    @When("user enters city name {string} and selects suggestions")
//    public void user_enters_city_name_and_selects_suggestions(String city) throws InterruptedException {
//        WebElement cityInput = Hooks.driver.findElement(By.xpath("//input[@placeholder='Enter city']"));
//        cityInput.clear(); // Clears existing value
//        cityInput.sendKeys(city); // Enter new city
//        Thread.sleep(2000); // Wait for suggestions
//        Hooks.driver.findElement(By.xpath("//div[contains(text(),'" + city + "')]")).click();
//    }
//    /////////////////////////////////////////////////////////////////
   
    /*
    @When("user enters city name {string} and selects suggestions")
    public void user_enters_city_name_and_selects_suggestions(String city) {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-qa-id='omni-searchbox-locality']")));
        cityInput.clear();
        cityInput.sendKeys(city);

        WebElement suggestion = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'" + city + "')]")));
        suggestion.click();
    }*/

//    ///////////////////////////////////////////////////////////////////////

//    private String cityName;
//    @And("user enters city name from sheet {int} and row {int} and selects suggestions")
//    public void enterCityNameFromExcel(int sheetIndex, int rowIndex) {
//        cityName = ExcelReader.getCity(ExcelReader.FILE_PATH, sheetIndex, rowIndex);
//        System.out.println("Entering city: " + cityName);
//        // Selenium code to enter cityName
//    }
//    /////////////////////////

//    @And("user enters city name from sheet {int} and row {int} and selects suggestions")
//    public void enterCityNameFromExcel(int sheetIndex, int rowIndex) {
//        cityName = ExcelReader.getCellData(ExcelReader.FILE_PATH, sheetIndex, rowIndex, ExcelReader.CITY_COLUMN_INDEX);
//        System.out.println("Entering city: " + cityName);
//        // Selenium code to enter city and select suggestion 
//    }

//@When("user enters city name {string} and selects suggestions")
//
//public void enterCity(String city) throws IOException {
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//    // Get city input locator from properties
//    String cityInputXpath = PropertyReader.getProperty("profile.properties", "cityInput");
//    WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityInputXpath)));
//    cityInput.clear();
//    cityInput.sendKeys(city);

//    String suggestionXpath = PropertyReader.getProperty("profile.properties", "citySuggestion").replace("${city}", city);
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(suggestionXpath))).click();
//}



    @When("user clicks on clinic button")
    public void user_clicks_on_clinic_button() {
        driver.findElement(By.xpath("//button[contains(text(),'Clinic')]")).click();
        System.out.println("Clinic button clicked");
    }

    
   /* @And("user enters city name from sheet {int} and row {int} and selects suggestions")
    public void enterCityNameFromExcel(int sheetIndex, int rowIndex) {
        String cityName = ExcelReader.getCity(ExcelReader.FILE_PATH, sheetIndex, rowIndex);
        System.out.println("City from Excel: " + cityName);

        WebElement cityInput = driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-locality']")); // Use correct locator
        cityInput.click(); // Focus on the field
        cityInput.clear(); // ✅ Clears default value
        cityInput.sendKeys(cityName); // ✅ Enters Excel-driven city
        // Optionally wait and select suggestion
        cityInput.sendKeys(Keys.ARROW_DOWN);
        cityInput.sendKeys(Keys.ENTER);
    }*/
    
    
    @And("user enters city name from sheet {int} and row {int} and selects suggestions")
    public void enterCityNameFromExcel(int sheetIndex, int rowIndex) throws Exception {
        String cityName = ExcelReader.getCellData(ExcelReader.FILE_PATH, sheetIndex, rowIndex, ExcelReader.CITY_COLUMN_INDEX);
        System.out.println("City from Excel: " + cityName);

//      String cityInputXpath = PropertyReader.getProperty("profile.properties", "cityInput");
//      FluentWait<WebDriver> wait = null;
//	  WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cityInputXpath)));
        WebDriver driver = BaseSteps.getDriver(); // ✅ Always fetch from DriverManager
        WebElement cityInput = driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-locality']"));
        cityInput.click();
        cityInput.clear(); // ✅ Clear default city
        cityInput.sendKeys(cityName);
        cityInput.sendKeys(Keys.ARROW_DOWN);
        cityInput.sendKeys(Keys.ENTER);
    }
    
//    @And("user enters city name from sheet {int} and row {int} and selects suggestions")
//    public void enterCityNameFromExcel(int sheetIndex, int rowIndex) {
//        String cityName = ExcelReader.getCellData(ExcelReader.FILE_PATH, sheetIndex, rowIndex, ExcelReader.CITY_COLUMN_INDEX);
//        System.out.println("City from Excel: " + cityName);
//
//        WebElement cityInput = driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-locality']"));
//        cityInput.sendKeys(cityName);
//        cityInput.sendKeys(Keys.ARROW_DOWN);
//        cityInput.sendKeys(Keys.ENTER);
//    }

}













