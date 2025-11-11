//package com.stepDefinitionTestNG;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.setup.BaseSteps;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Profile {
//	static WebDriver driver;
//
//	@Given("user is on Practo Homepage")
//	public void user_is_on_practo_homepage() {
//
//
//		BaseSteps.initializeDriver();
//		driver = BaseSteps.getDriver();
//
//		driver.get("https://www.practo.com");
//	}
//
//
//	@When("user clicks on Lab Tests Link")
//	public void user_clicks_on_lab_tests_link() {
//		driver.findElement(By.cssSelector("a[href*='/tests']")).click();
//	}
//
//
//	@And("user selects a city from the popup")
//	public void user_selects_a_city_from_the_popup() {
//
//		WebElement cityInput = driver.findElement(By.id("locationInput"));
//		cityInput.clear();
//		CharSequence cityName = null;
//		cityInput.sendKeys(cityName );
//		cityInput.sendKeys(Keys.ENTER);
//	}
//
//	@Then("Lab Tests page for the selected city should be displayed")
//	public void lab_tests_page_for_the_selected_city_should_be_displayed() {
//
//		String actualCity = driver.findElement(By.id("locationInput")).getAttribute("value");
//		String expectedCity = null;
//		Assert.assertEquals(actualCity, expectedCity , "City mismatch!");
//
//	}
//
//	@When("user clicks on a diagnostic test named {string} from Top Booked Diagnostic Tests section")
//	public void user_clicks_on_a_diagnostic_test_named(String testName) {
//		WebElement section = driver.findElement(By.xpath("//h2[contains(text(),'Top Booked Diagnostic Tests')]"));
//		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
//
//		// Click on the test by its name dynamically
//		WebElement testLink = driver.findElement(By.xpath("//a[.//div[text()='" + testName + "']]"));
//		testLink.click();
//	}
//
//
//	@And("user clicks on Book Now or Add to Cart")
//	public void user_clicks_on_book_now_or_add_to_cart() {
//		// Locate the Add to Cart button dynamically using its class
//		WebElement addToCartButton = driver.findElement(By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std"));
//
//		// Click the button
//		addToCartButton.click();
//	}
//
//
//	@Then("the booking page for the selected test should be displayed")
//	public void the_booking_page_for_the_selected_test_should_be_displayed() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement bookingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std"))); // Example: Add to Cart button
//		if (!bookingElement.isDisplayed()) {
//			throw new AssertionError("Booking page element not found!");
//		}
//		System.out.println("Booking page verified successfully.");
//	}
//
//
//
//
//
//
//
//}

//
//package com.stepDefinitionTestNG;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.parameters.ExcelReader;
//import com.setup.BaseSteps;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Profile {
//    static WebDriver driver;
//
//    @Given("user is on Practo Homepage")
//    public void user_is_on_practo_homepage() {
//        BaseSteps.initializeDriver();
//        driver = BaseSteps.getDriver();
//        driver.get("https://www.practo.com");
//    }
//
//    public void user_clicks_on_lab_tests_link() {
//        driver.findElement(By.cssSelector("a[href*='/tests']")).click();
//    }
//
//    @And("user selects a city from the popup")
//    public void user_selects_a_city_from_the_popup() throws Exception {
//        // Read city name from Excel
//        String cityName = ExcelReader.getCellData("src/test/resources/TestData.xlsx", "LabTests", 1, 0);
//        WebElement cityInput = driver.findElement(By.id("locationInput"));
//        cityInput.clear();
//        cityInput.sendKeys(cityName);
//        cityInput.sendKeys(Keys.ENTER);
//    }
//
//    @Then("Lab Tests page for the selected city should be displayed")
//    public void lab_tests_page_for_the_selected_city_should_be_displayed() throws Exception {
//        String expectedCity = ExcelReader.getCellData("src/test/resources/TestData.xlsx", "LabTests", 1, 0);
//        String actualCity = driver.findElement(By.id("locationInput")).getAttribute("value");
//        Assert.assertEquals(actualCity, expectedCity, "City mismatch!");
//    }
//
//    @When("user clicks on a diagnostic test from the list")
//    public void user_clicks_on_a_diagnostic_test_from_the_list() throws Exception {
//        String testName = ExcelReader.getCellData("src/test/resources/TestData.xlsx", "LabTests", 1, 1);
//        WebElement section = driver.findElement(By.xpath("//h2[contains(text(),'Top Booked Diagnostic Tests')]"));
//        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
//
//        WebElement testLink = driver.findElement(By.xpath("//a[.//div[text()='" + testName + "']]"));
//        testLink.click();
//    }
//
//    @And("user clicks on Book Now or Add to Cart")
//    public void user_clicks_on_book_now_or_add_to_cart() {
//        WebElement addToCartButton = driver.findElement(By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std"));
//        addToCartButton.click();
//    }
//
//    @Then("the booking page for the selected test should be displayed")
//    public void the_booking_page_for_the_selected_test_should_be_displayed() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement bookingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std")));
//        if (!bookingElement.isDisplayed()) {
//            throw new AssertionError("Booking page element not found!");
//        }
//        System.out.println("Booking page verified successfully.");
//    }
//}



//package com.stepDefinitionTestNG;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.setup.BaseSteps;
//import com.parameters.ExcelReader;
//
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Profile {
//	static WebDriver driver;
//
//	@Before
//	public void setUp() {
//		driver = new ChromeDriver(); // or whichever driver you're using
//	}
//
//
//	@Given("user is on Practo Homepage")
//	public void user_is_on_practo_homepage() {
//		BaseSteps.initializeDriver();
//		driver.get("https://www.practo.com");
//	}
//
//	@When("user clicks on Lab Tests Link")
//	public void user_clicks_on_lab_tests_link() {
//		driver.findElement(By.cssSelector("a[href*='/tests']")).click();
//	}
//
//	@And("user selects a city from the popup")
//	public void user_selects_a_city_from_the_popup() throws Exception {
//		String cityName = ExcelReader.getCellData("src/test/resources/TestData.xlsx", "LabTests", 1, 0);
//		WebElement cityInput = driver.findElement(By.id("locationInput"));
//		cityInput.clear();
//		cityInput.sendKeys(cityName);
//		cityInput.sendKeys(Keys.ENTER);
//	}
//
//	@Then("Lab Tests page for the selected city should be displayed")
//	public void lab_tests_page_for_the_selected_city_should_be_displayed() throws Exception {
//		String expectedCity = ExcelReader.getCellData("src/test/resources/TestData.xlsx", "LabTests", 1, 0);
//		String actualCity = driver.findElement(By.id("locationInput")).getAttribute("value");
//		Assert.assertEquals(actualCity, expectedCity, "City mismatch!");
//	}
//
//	@When("user scrolls to Top Booked Diagnostic Tests section")
//	public void user_scrolls_to_top_booked_diagnostic_tests_section() {
//		WebElement section = driver.findElement(By.xpath("//h2[contains(text(),'Top Booked Diagnostic Tests')]"));
//		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
//	}
//
//	@And("user clicks on a diagnostic test from the list")
//	public void user_clicks_on_a_diagnostic_test_from_the_list() throws Exception {
//		String testName = ExcelReader.getCellData("src/test/resources/TestData.xlsx", "LabTests", 1, 1);
//		WebElement testLink = driver.findElement(By.xpath("//a[.//div[text()='" + testName + "']]"));
//		testLink.click();
//	}
//
//	@Then("the diagnostic test details page should be displayed")
//	public void the_diagnostic_test_details_page_should_be_displayed() {
//		String currentUrl = driver.getCurrentUrl();
//		if (!currentUrl.contains("/tests/")) {
//			throw new AssertionError("Diagnostic test details page not displayed! Current URL: " + currentUrl);
//		}
//		System.out.println("Diagnostic test details page verified successfully.");
//	}
//
//	@When("user clicks on Book Now or Add to Cart")
//	public void user_clicks_on_book_now_or_add_to_cart() {
//		WebElement addToCartButton = driver.findElement(By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std"));
//		addToCartButton.click();
//	}
//
//	@Then("the booking page for the selected test should be displayed")
//	public void the_booking_page_for_the_selected_test_should_be_displayed() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement bookingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std")));
//		if (!bookingElement.isDisplayed()) {
//			throw new AssertionError("Booking page element not found!");
//		}
//		System.out.println("Booking page verified successfully.");
//	}
//
//	@Then("user should see options to confirm booking or proceed to payment")
//	public void user_should_see_options_to_confirm_booking_or_proceed_to_payment() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//button[contains(text(),'Proceed to Payment')]")));
//		if (!confirmButton.isDisplayed()) {
//			throw new AssertionError("Proceed to Payment option not found!");
//		}
//		System.out.println("Booking options verified successfully.");
//	}
//}









//package com.stepDefinitionTestNG;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.ElementNotInteractableException;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.setup.BaseSteps;
//import com.parameters.ExcelReader;
//
//import io.cucumber.java.Before;
//import io.cucumber.java.After;
//import io.cucumber.java.en.*;
//
//public class Profile {
//    static WebDriver driver;
//    WebDriverWait wait;
//
//    @Before
//    public void setUp() {
//        BaseSteps.initializeDriver();
//        driver = BaseSteps.getDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    @After
//    public void tearDown() {
//        BaseSteps.quitDriver();
//    }
//
//    @Given("user is on Practo Homepage")
//    public void user_is_on_practo_homepage() {
//        driver.get("https://www.practo.com");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='/tests']")));
//    }
//
//    @When("user clicks on Lab Tests Link")
//    public void user_clicks_on_lab_tests_link() {
//        try {
//            // Optional: handle popup if present
//            try {
//                WebElement popupClose = driver.findElement(By.cssSelector(".some-popup-close")); // 🔧 Replace with actual selector
//                if (popupClose.isDisplayed()) {
//                    popupClose.click();
//                }
//            } catch (NoSuchElementException ignored) {}
//
//            WebElement labTestsLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/tests']")));
//            labTestsLink.click();
//        } catch (ElementNotInteractableException e) {
//            System.out.println("Lab Tests link not interactable: " + e.getMessage());
//        }
//    }
//
//    @And("user selects a city from the popup")
//    public void user_selects_a_city_from_the_popup() throws Exception {
//        String cityName = ExcelReader.getCellData("src/test/resources/TestData.xlsx", "LabTests", 1, 0);
//
//        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationInput")));
//
//        // Use JavaScript to set the value
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));", cityInput, cityName);
//
//        // Press ENTER to confirm selection
//        cityInput.sendKeys(Keys.ENTER);
//
//        // Wait for the city to reflect in the input field
//        wait.until(driver -> {
//            String value = cityInput.getAttribute("value");
//            return value != null && value.trim().equalsIgnoreCase(cityName);
//        });
//    }
//    
//
//    @Then("Lab Tests page for the selected city should be displayed")
//    public void lab_tests_page_for_the_selected_city_should_be_displayed() throws Exception {
//        String expectedCity = ExcelReader.getCellData("src//test//resources//Excel//TestData.xlsx", "LabTests", 1, 0);
//        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationInput")));
//
//        // Wait until the value is not empty
//        wait.until(driver -> {
//            String value = cityInput.getAttribute("value");
//            return value != null && !value.trim().isEmpty();
//        });
//
//        String actualCity = cityInput.getAttribute("value").trim();
//        Assert.assertEquals(actualCity, expectedCity, "City mismatch!");
//    }
//    
//
//    @When("user scrolls to Top Booked Diagnostic Tests section")
//    public void user_scrolls_to_top_booked_diagnostic_tests_section() {
//        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//h2[contains(text(),'Top Booked Diagnostic Tests')]")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
//    }
//
//    @And("user clicks on a diagnostic test from the list")
//    public void user_clicks_on_a_diagnostic_test_from_the_list() throws Exception {
//        String testName = ExcelReader.getCellData("src/test/resources/TestData.xlsx", "LabTests", 1, 1);
//        WebElement testLink = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//a[.//div[text()='" + testName + "']]")));
//        testLink.click();
//    }
//
//    @Then("the diagnostic test details page should be displayed")
//    public void the_diagnostic_test_details_page_should_be_displayed() {
//        String currentUrl = driver.getCurrentUrl();
//        if (!currentUrl.contains("/tests/")) {
//            throw new AssertionError("Diagnostic test details page not displayed! Current URL: " + currentUrl);
//        }
//        System.out.println("Diagnostic test details page verified successfully.");
//    }
//
//    @When("user clicks on Book Now or Add to Cart")
//    public void user_clicks_on_book_now_or_add_to_cart() {
//        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std")));
//        addToCartButton.click();
//    }
//
//    @Then("the booking page for the selected test should be displayed")
//    public void the_booking_page_for_the_selected_test_should_be_displayed() {
//        WebElement bookingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std")));
//        if (!bookingElement.isDisplayed()) {
//            throw new AssertionError("Booking page element not found!");
//        }
//        System.out.println("Booking page verified successfully.");
//    }
//
//    @Then("user should see options to confirm booking or proceed to payment")
//    public void user_should_see_options_to_confirm_booking_or_proceed_to_payment() {
//        WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//button[contains(text(),'Proceed to Payment')]")));
//        if (!confirmButton.isDisplayed()) {
//            throw new AssertionError("Proceed to Payment option not found!");
//        }
//        System.out.println("Booking options verified successfully.");
//    }
//}




//package com.stepDefinitionTestNG;
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import com.setup.BaseSteps;
//import com.parameters.ExcelReader;
//import io.cucumber.java.Before;
//import io.cucumber.java.After;
//import io.cucumber.java.en.*;
//
//public class Profile {
//    static WebDriver driver;
//    WebDriverWait wait;
//
//    @Before
//    public void setUp() {
//        BaseSteps.initializeDriver();
//        driver = BaseSteps.getDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    @After
//    public void tearDown() {
//        BaseSteps.quitDriver();
//    }
//
//    @Given("user is on Practo Homepage")
//    public void user_is_on_practo_homepage() {
//        driver.get("https://www.practo.com");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='/tests']")));
//    }
//
//    @When("user clicks on Lab Tests Link")
//    public void user_clicks_on_lab_tests_link() {
//        WebElement labTestsLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/tests']")));
//        labTestsLink.click();
//    }
//
//    @And("user selects a city from the popup")
//    public void user_selects_a_city_from_the_popup() throws Exception {
//        String cityName = ExcelReader.getCellData(
//            "C:\\Users\\dyamaa\\SpritPracto\\Practo\\src\\test\\resources\\Excel\\TestData.xlsx",
//             1, 0);
//
//        WebElement popupContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.cssSelector("div.c-location-popup"))); // Update selector if needed
//
//        
//        WebElement cityInput = popupContainer.findElement(By.id("locationInput"));
//        cityInput.clear();
//        cityInput.sendKeys(cityName);
//
//       
//        WebElement applyButton = popupContainer.findElement(By.cssSelector("button[data-qa-id='location-apply']")); // Update selector if needed
//        applyButton.click();
//
//        
//        wait.until(ExpectedConditions.invisibilityOf(popupContainer));
//
//        WebElement cityDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationInput")));
//        wait.until(driver -> cityDisplay.getAttribute("value").trim().equalsIgnoreCase(cityName));
//
//        System.out.println("City selected successfully: " + cityDisplay.getAttribute("value"));
//    }
//
//    @Then("Lab Tests page for the selected city should be displayed")
//    public void lab_tests_page_for_the_selected_city_should_be_displayed() throws Exception {
//        String expectedCity = ExcelReader.getCellData(
//            "C:\\Users\\dyamaa\\SpritPracto\\Practo\\src\\test\\resources\\Excel\\TestData.xlsx",
//             1, 0);
//
//        WebElement cityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationInput")));
//        String actualCity = cityInput.getAttribute("value").trim();
//        Assert.assertEquals(actualCity, expectedCity, "City mismatch!");
//    }
//
//    @When("user scrolls to Top Booked Diagnostic Tests section")
//    public void user_scrolls_to_top_booked_diagnostic_tests_section() {
//        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//h2[contains(text(),'Top Booked Diagnostic Tests')]")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
//    }
//
//    @And("user clicks on a diagnostic test from the list")
//    public void user_clicks_on_a_diagnostic_test_from_the_list() throws Exception {
//        String testName = ExcelReader.getCellData(
//            "C:\\Users\\dyamaa\\SpritPracto\\Practo\\src\\test\\resources\\Excel\\TestData.xlsx",
//             1, 1);
//        WebElement testLink = wait.until(ExpectedConditions.elementToBeClickable(
//            By.xpath("//a[.//div[text()='" + testName + "']]")));
//        testLink.click();
//    }
//
//    @Then("the diagnostic test details page should be displayed")
//    public void the_diagnostic_test_details_page_should_be_displayed() {
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertTrue(currentUrl.contains("/tests/"), "Diagnostic test details page not displayed!");
//    }
//
//    @When("user clicks on Book Now or Add to Cart")
//    public void user_clicks_on_book_now_or_add_to_cart() {
//        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
//            By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std")));
//        addToCartButton.click();
//    }
//
//    @Then("the booking page for the selected test should be displayed")
//    public void the_booking_page_for_the_selected_test_should_be_displayed() {
//        WebElement bookingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std")));
//        Assert.assertTrue(bookingElement.isDisplayed(), "Booking page element not found!");
//    }
//
//    @Then("user should see options to confirm booking or proceed to payment")
//    public void user_should_see_options_to_confirm_booking_or_proceed_to_payment() {
//        WebElement confirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//button[contains(text(),'Proceed to Payment')]")));
//        Assert.assertTrue(confirmButton.isDisplayed(), "Proceed to Payment option not found!");
//    }
//}



//
//package com.stepDefinitionTestNG;
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import com.setup.BaseSteps;
//import com.parameters.ExcelReader;
//import io.cucumber.java.Before;
//import io.cucumber.java.After;
//import io.cucumber.java.en.*;
//
//public class Profile {
//    static WebDriver driver;
//    WebDriverWait wait;
//
//    @Before
//    public void setUp() {
//        BaseSteps.initializeDriver();
//        driver = BaseSteps.getDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    @After
//    public void tearDown() {
//        BaseSteps.quitDriver();
//    }
//
//    @Given("user is on Practo Homepage")
//    public void user_is_on_practo_homepage() {
//        driver.get("https://www.practo.com");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='/tests']")));
//    }
//
//    @When("user navigates to Lab Tests page")
//    public void user_navigates_to_lab_tests_page() {
//        // Wait for Lab Tests page to load by checking a unique element
//        WebElement labTestsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.xpath("//h1[contains(text(),'Lab Tests')]"))); // Adjust selector if needed
//        System.out.println("Navigated to Lab Tests page successfully.");
//    }
//
//    @And("user navigates to Diagnostic Test details page")
//    public void user_navigates_to_diagnostic_test_details_page() {
//        // Verify URL contains /tests/ or check for a unique element on details page
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertTrue(currentUrl.contains("/tests/"), "Not on Diagnostic Test details page!");
//        System.out.println("Navigated to Diagnostic Test details page successfully.");
//    }
//
//    @Then("user navigates to Booking page")
//    public void user_navigates_to_booking_page() {
//        // Wait for booking page element to confirm navigation
//        WebElement bookingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.cssSelector("div.c-qc__qc-button.hollow.u-marginr--std"))); // Adjust selector if needed
//        Assert.assertTrue(bookingElement.isDisplayed(), "Booking page not displayed!");
//        System.out.println("Navigated to Booking page successfully.");
//    }
//
//}

package com.stepDefinitionTestNG;                                                                                                                                                                             
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LabTestsPage;

import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	HomePage homePage;
	LabTestsPage labTestsPage;


	@Given("user is on Practo Homepage")
	public void user_is_on_practo_homepage() {
		homePage=new HomePage(driver);

	}

	@When("user clicks on Lab Tests link")
	public void user_clicks_on_lab_tests_link() {
		homePage.clickLabTestsLink();
		labTestsPage = new LabTestsPage(driver);

	}

	@And("Lab Tests page should be displayed")
	public void lab_tests_page_should_be_displayed() {
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + actualUrl);
		Assert.assertTrue(actualUrl.contains("tests"),
				"Lab Tests page is not displayed correctly! Actual: " + actualUrl);
	}

	@Then("user clicks on TopBooked Diagnosttic Tests  link")
	public void user_clicks_on_top_booked_diagnosttic_tests_link() {
		driver.get(prop.getProperty("topbookedtests.url"));
	}

	@And("TopBooked Diagnosttic Tests page should be displayed correctly")
	public void top_booked_diagnosttic_tests_page_should_be_displayed_correctly() {
		String expectedUrl = prop.getProperty("topbookedtests.url");
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl),
                "topbookedtests is not displayed correctly!");
	}

}























