package com.stepDefinitionTestNG;
 
import java.io.IOException;
 
import com.pages.ProfilePage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
 
public class Profile {
 
    ProfilePage profilePage;
 
    @Given("the user navigates to the Practo website")
    public void the_user_navigates_to_the_practo_website() {
        BaseSteps.driver.get("https://www.practo.com");
        System.out.println("Navigated to Practo website");
    }
 
    @When("the user opens the Find Doctors page")
    public void the_user_opens_the_find_doctors_page() {
        profilePage = new ProfilePage();
        profilePage.clickFindDoctors();
        System.out.println("Clicked on Find Doctors");
    }
 
    @When("the user searches for the Dentists")
    public void the_user_searches_for_the_dentists() throws IOException {
 
        // ✅ Read from Excel
//        String specialization = new ExcelReader(
//                ".\\src\\test\\resources\\ExcelData\\TestSpecialization.xlsx")
//                .getSpecializationFromExcel();
// 
//        profilePage = new ProfilePage();
// 
//        // Type Dentist in search bar
//        profilePage.enterSpecialization(specialization);
//        BaseSteps.sleep(2000);
// 
//        // Click the suggestion
//        //profilePage.selectSpecialization(specialization);
// 
//        System.out.println("Searched for " + specialization);

    			profilePage. enterSpecialization();//enterSpecializationFromExcel();
    			profilePage.clickCorrectSearchResult(ExcelReader.getSpecializationFromExcel());

    
    }
 
    @Then("matching doctors should be visible")
    public void matching_doctors_should_be_visible() {
 
        if (!profilePage.areDoctorResultsVisible()) {
            throw new AssertionError("Doctor results not visible!");
        }
 
        System.out.println("Doctor results are visible");
    }
    
    
   

}