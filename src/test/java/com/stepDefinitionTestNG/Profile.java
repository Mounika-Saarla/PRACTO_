package com.stepDefinitionTestNG;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/*
public class Profile extends BaseSteps{
	
	BasePage basePage = new BasePage(); 
	
	
	@Given("User is on the Chrome")
	public void user_is_on_the_chrome() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//		PropertyReader.loadProperties();
//		openBrowser();
		
		PropertyReader.loadProperties();
        openBrowser();

	}

	@When("User clicks on the Practo url")
	public void user_clicks_on_the_practo_url() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//		   String expectedUrl = PropertyReader.get("sourceUrl");
//		    assertTrue(basePage.getCurrentURL().startsWith(expectedUrl));

		    openURL(); // ✅ Navigate to URL
        String expectedUrl = PropertyReader.get("sourceUrl");
        assertTrue(basePage.getCurrentURL().startsWith(expectedUrl));

		
		
	}

	@Then("User should in Practo page")
	public void user_should_in_practo_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//		String expectedTitle = PropertyReader.get("expectedTitle");
//		  assertTrue(basePage.getPageTitle().contains(expectedTitle));

//		String expectedTitle = PropertyReader.get("expectedTitle");
//        assertTrue(basePage.getPageTitle().contains(expectedTitle));

		

String expectedTitle = PropertyReader.get("expectedTitle").trim();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.titleContains("Practo")); // ✅ Stable keyword
    String actualTitle = driver.getTitle().trim();
    System.out.println("Actual Title: " + actualTitle);
    assertTrue(actualTitle.contains(expectedTitle),
        "Title mismatch! Expected: " + expectedTitle + ", Actual: " + actualTitle);

		
//		String expectedTitle = PropertyReader.get("expectedTitle");
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    wait.until(ExpectedConditions.titleContains(expectedTitle));
//    String actualTitle = driver.getTitle();
//    System.out.println("Actual Title: " + actualTitle);
//    assertTrue(actualTitle.contains(expectedTitle), 
//        "Title mismatch! Expected: " + expectedTitle + ", Actual: " + actualTitle);

	}
	
	/*@Given("User is on the Home page")
	public void user_is_on_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		WebDriverManager.chromedriver().setup();	// Automatically downloads and sets up the ChromeDriver binary
        driver = new ChromeDriver();	// Launch a new Chrome browser instance
	}

	@Given("User scrolls to the footer section")
	public void user_scrolls_to_the_footer_section() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	}

	@When("The footer should contain a visible link labeled {string}")
	public void the_footer_should_contain_a_visible_link_labeled(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User clicks the {string} link")
	public void user_clicks_the_link(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	*/

/*
	    @Given("User is on the Home page")
	    public void user_is_on_the_home_page() {
	        PropertyReader.loadProperties();
	        openBrowser();
	        openURL();
	    }

	    @Given("User scrolls to the footer section")
	    public void user_scrolls_to_the_footer_section() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    }

	    @When("The footer should contain a visible link labeled {string}")
	    public void footer_should_contain_visible_link(String linkText) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement footerLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
	        assertTrue(footerLink.isDisplayed(), "Footer link '" + linkText + "' is not visible");
	    }

	    @Then("User clicks the {string} link")
	    public void user_clicks_the_link(String linkText) {
	        WebElement footerLink = driver.findElement(By.linkText(linkText));
	        footerLink.click();
	        System.out.println("✅ Clicked on footer link: " + linkText);
	    }*/
	
	
	
	
	
//}
