package com.stepDefinitionTestNG;


import com.setup.BaseSteps;
import com.pages.*;
import com.parameters.ExcelReader;
import io.cucumber.java.en.*;

public class PractoProfile {

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
        new HospitalListPage(BaseSteps.driver).selectHospital();
    }

    @And("user clicks on Book Hospital Visit")
    public void clickBookHospital() throws Exception {
        new BookingPage(BaseSteps.driver).clickBookHospital();
    }
    @And("user click on clinic button")
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
}













