package com.stepDefinitionTestNG;
 
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.ProfilePage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class Profile extends BaseSteps {
	
 
	WebDriver driver = BaseSteps.driver;
	ExtentTest test = Hooks.test;
    ProfilePage profilePage;
 
  @Given("the user navigates to the Practo website")
    public void the_user_navigates_to_the_practo_website() {
       BaseSteps.driver.get("https://www.practo.com");
        System.out.println("Navigated to Practo website");
 }

    @When("the user opens the Find Doctors page")
    public void the_user_opens_the_find_doctors_page() {
        profilePage = new ProfilePage(driver, test);
        profilePage.clickFindDoctors1();
        System.out.println("Clicked on Find Doctors");
    }
// 
    @And("the user searches for the Dentists")
    public void the_user_searches_for_the_dentists() throws IOException {
        String specialization = ExcelReader.getSpecializationFromExcel(); // Reads Dentist from Excel
        profilePage.enterSpecialization(specialization); // Types Dentist in search bar
       profilePage.clickCorrectSearchResult(specialization); // Clicks Dentist suggestion
    }
 
    @Then("matching doctors should be visible")
    public void matching_doctors_should_be_visible() {
 
        if (!profilePage.areDoctorResultsVisible()) {
            throw new AssertionError("Doctor results not visible!");
        }
 
        System.out.println("Doctor results are visible");
    }
    
    
    // 2nd Scenario

    @Given("User launches the Practo website")
    public void user_launches_the_practo_website() {
    	profilePage = new ProfilePage(driver, test);
    	
    
   }
//
@When("User clicks on Find Doctors option")
public void user_clicks_on_find_doctors_option() {
	boolean clickable = profilePage.clickFindDoctors1();
	Assert.assertTrue(clickable);
	
   
}
    
    
   

//@And("User should be on the Find Doctors page")
//public void user_should_be_on_the_find_doctors_page() {
////	String clickable = profilePage.getCurrentUrl();
////	Assert.assertTrue(clickable);
//
//   
//}

@And("User clicks on Consult with a doctor option")
public void user_clicks_on_consult_with_a_doctor_option() {
	boolean clickconsult = profilePage.clickConsultWithDoctor();
	Assert.assertTrue(clickconsult);
}

@Then("User should be on the Consult with a doctor page")
public void user_should_be_on_the_consult_with_a_doctor_page() {
	
}
 


//3rd Scenario


//@Given("User launches the Practo website")
//public void user_launches_the_practo_website3() {
//	profilePage = new ProfilePage(driver, test);
//	
//
//}

//@When("User clicks on Find Doctors option")
//public void user_clicks_on_find_doctors_option3() {
//boolean clickable = profilePage.clickFindDoctors1();
//Assert.assertTrue(clickable);
//
//
//}

//@And("the user selects Dermatologist from the popular searches section")
//public void the_user_selects_dermatologist_from_the_popular_searches_section() {
//	boolean selected = profilePage.selectPopularSearch("Dermatologist");
//    Assert.assertTrue("Dermatologist should be selectable from popular searches", selected);
//}

@And("the user selects Dermatologist from the popular searches section")
public void the_user_selects_dermatologist_from_the_popular_searches_section() {
    boolean selected = profilePage.selectPopularSearch("Dermatologist");
    if (selected) {
        test.pass("Successfully selected 'Dermatologist' from popular searches");
    } else {
        test.fail("Could not select 'Dermatologist' from popular searches");
    }
    Assert.assertTrue(selected);
}
//
//@Then("the user should be navigated to the Dermatologist listing page")
//public void the_user_should_be_navigated_to_the_dermatologist_listing_page() {
//	String currentUrl = driver.getCurrentUrl();
//    Assert.assertTrue("User should be on Dermatologist listing page", currentUrl.contains("dermatologist"))
//}


@Then("the user should be navigated to the Dermatologist listing page")
public void the_user_should_be_navigated_to_the_dermatologist_listing_page() {
    String currentUrl = driver.getCurrentUrl();
    boolean isCorrectPage = currentUrl.toLowerCase().contains("dermatologist");
    if (isCorrectPage) {
        test.pass("User successfully navigated to Dermatologist listing page: " + currentUrl);
    } else {
        test.fail("Navigation failed. Current URL: " + currentUrl);
    }
    Assert.assertTrue(isCorrectPage);
}

}