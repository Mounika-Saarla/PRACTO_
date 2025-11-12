package com.stepDefinitionTestNG;

import com.pages.HomePage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class Profile {
    HomePage homepage;

    @Given("user is on Practo Homepage")
    public void user_is_on_practo_homepage() {
        BaseSteps.driver.get(PropertyReader.getProperty("base.url"));
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


}
//package com.stepDefinitionTestNG;
//
//import com.pages.HomePage;
//import com.parameters.PropertyReader;
//import com.setup.BaseSteps;
//import io.cucumber.java.en.*;
//import org.testng.Assert;
//
//public class Profile {
//    HomePage homepage;
//
//    @Given("user is on Practo Homepage")
//    public void user_is_on_practo_homepage() {
//        BaseSteps.driver.get(PropertyReader.getProperty("base.url"));
//        homepage = new HomePage(BaseSteps.driver);
//    }
//
//    @When("user clicks on Lab Tests link")
//    public void user_clicks_on_lab_tests_link() {
//        homepage.clickLabTests();
//    }
//
//    @Then("Lab Tests page should be displayed")
//    public void lab_tests_page_should_be_displayed() {
//        Assert.assertTrue(BaseSteps.driver.getCurrentUrl().contains("tests"));
//    }
//    @And("select Bangalore city")
//    public void select_bangalore_city() {
//        homepage.selectCity("Bangalore");
//    }
//    @When("user clicks on Lipid Profile link")
//    public void user_clicks_on_lipid_profile_link() {
//        homepage.clickLipidProfile();
//    }
//
//    @Then("verify Lipid Profile page URL")
//    public void verify_lipid_profile_page_url() {
//        String actualUrl = BaseSteps.driver.getCurrentUrl();
//        String expectedUrl = PropertyReader.getProperty("expected.lipidprofile.url");
//        Assert.assertEquals(actualUrl, expectedUrl, "Lipid Profile URL mismatch!");
//    }
//}