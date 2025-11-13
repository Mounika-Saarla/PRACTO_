package com.stepDefinitionTestNG;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.HomePage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;

public class LabTest {
    HomePage homepage=new HomePage(BaseSteps.driver);;
    Properties prop = PropertyReader.readProperty();
    //ExcelReader reader = new ExcelReader("src\\test\\resources\\Excel\\PractoTestSc1.xlsx");
     
    
    @Given("user is on Practo Homepage")
    public void user_is_on_practo_homepage() {
        
    	 BaseSteps.launchBrowser();
    	    homepage = new HomePage(BaseSteps.driver);
    }

    @When("user clicks on Lab Tests link")
    public void user_clicks_on_lab_tests_link() {
        homepage.clickLabTests();
    }

    @Then("Lab Tests page should be displayed")
    public void lab_tests_page_should_be_displayed() {
        Assert.assertTrue(BaseSteps.driver.getCurrentUrl().contains("tests"));
    }

    @And("select Bangalore city")
    public void select_bangalore_city() {
        homepage.selectCity("Bangalore");
    }

    @When("user clicks on Lipid Profile link")
    public void user_clicks_on_lipid_profile_link() {
        homepage.clickLipidProfile();
    }

    @Then("verify Lipid Profile page URL")
    public void verify_lipid_profile_page_url() {
        String actualUrl = BaseSteps.driver.getCurrentUrl();
        String expectedUrl = PropertyReader.getProperty("expected.lipidprofile.url");
        Assert.assertEquals(actualUrl, expectedUrl, "Lipid Profile URL mismatch!");
    }
    
    @And("click on Add to Cart button")
    public void click_on_add_to_cart_button() {
        homepage.clickAddToCart();
    }


@Then("verify item is added to cart")
    public void verify_item_is_added_to_cart() {
        Assert.assertTrue(homepage.isItemAddedToCart(), "Item was not added to cart!");
    }

@Then("click on search")
public void click_on_search() {
   homepage.clickTests();
}

String enteredTestName; // Declare globally in LabTest

@Then("Enter the Test from {int} and {int} in Lipid Profile page for search")
public void enter_the_test_from_and_in_lipid_profile_page_for_search(Integer sheet, Integer row) throws InterruptedException, IOException {

   String[] testData = ExcelReader.getRowData(sheet, row); // Column 0 = TestName
    //Assert.assertFalse(testData.trim().isEmpty(), "Test Data is blank at sheet " + sheetIndex + ", row " + rowIndex);
    homepage.enterTest(testData);
//    enteredTestName = testData; // Store for verification
    System.out.println("DEBUG: Excel Data -> " + testData);
    
}
@Then("verify Test results for SearchBox")
public void verify_test_results_for_search_box() {
   homepage.verifyTest();
}

@Then("click Entered Test in search")
public void click_entered_test_in_search() {
	homepage.clickTests();
}
}
