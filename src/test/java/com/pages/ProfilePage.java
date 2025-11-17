
package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.Reports;

public class ProfilePage {
	// WebDriver driver;

	Map<String, String> formData;
	PropertyReader propertyreader = new PropertyReader();

	private static WebDriver driver;
	private static WebDriverWait wait;
	static ExtentTest test;

	// PageFactory WebElements
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/a/div[1]")
	private WebElement findDoctorsLink1;
	
////*[@id="root"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/a/div[1]
	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-keyword']")
	private WebElement searchField;

	@FindBy(xpath = "(//div[@class='product-tab__title'])[1]")
	private WebElement findDoctorsLink;

	@FindBy(xpath = "//span[text()='Consult with a doctor']")
	private WebElement consultWithDoctorLink;

//	@FindBy(xpath = "//input[@placeholder='Search doctors, clinics, hospitals, etc.']")
//	private WebElement searchButton;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchButton;

	@FindBy(xpath = "//*[@id=\"c-omni-container\"]/div/div[2]/div[2]/div[1]/div[1]/span[1]/div")
	WebElement clickEnter;

	@FindBy(xpath = "//ul[contains(@class,'c-dropdown')]//li[1]") // First suggestion
	WebElement firstSuggestion;

	@FindBy(xpath = "//h1[contains(text(), '213 Dermatologists ')]")
	private WebElement resultsHeader;
	// 4th Scenario
	@FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[1]/div[2]/div/a[2]/span")
	private WebElement OrderMedicines;

//	@FindBy(xpath = "//input[@placeholder='Search for medicines, health products and more']")
//	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/div[1]/div/div/input")

	@FindBy(css = "//input[placeholder*=' medicines')]")
	WebElement searchOrder;
	//// input[contains(@placeholder,'Search for medicines')]
	// *[@id="root"]/div[1]/div[2]/div/div[1]/div/div/input
	// input[@type='text']
	//// *[@id=\"root\"]/div[1]/div[2]/div/div[1]/div/div[2] this is first
	//// suggestion
	///
	@FindBy(css = "ul.c-dropdown li")
	private WebElement Suggestion;

	// ul[contains(@class,'c-dropdown')]/li[1]")
	// css suggestion

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/a/div[1]")
	private WebElement findDoctors2;

	@FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[1]/div[2]/div/a[5]/i")
	private WebElement ReadArticles;

//    @FindBy(xpath ="//*[@id=\"searchBar\"]")
	@FindBy(xpath = "//*[@id=\"searchBar\"]")
	private WebElement searchhealthtopic;

	//// input[@id='searchBar']
	///
	@FindBy(xpath = "//input[@id='searchBar']")
	private WebElement searchb5;

	// --------------------------------------form------------------------------------------------

	@FindBy(xpath = "//span[text()='Insta by Practo']")
	//// span[text()='Insta by Practo']
	//// //*[@id='container']/footer/div/div[1]/div[4]/div[2]/a[1]/span
	WebElement instaSection;

//@FindBy(xpath = "//a[@data-event="I would like a free demo"]")
//	/// html/body/section[1]/div/div[2]/div[5]/a
////	///// a[contains(@class,'btn')])[2]
//	WebElement freeDemoButton;
//@FindBy(xpath = "//a[@data-event='I would like a free demo']")
//WebElement freeDemoButton;

//	@FindBy(xpath = "//*[@id='freedemo']/div[1]/div/div[1]/div[1]/input")
//	WebElement name;
//
//	@FindBy(xpath = "//*[@id='freedemo']/div[1]/div/div[1]/div[2]/input")
//	WebElement email;
//
//	@FindBy(xpath = "//*[@id='freedemo']/div[1]/div/div[2]/div[1]/div/input")
//	WebElement phone;
//
//	@FindBy(xpath = "//*[@id='freedemo']/div[1]/div/div[2]/div[2]/input")
//	WebElement city;
//
//	@FindBy(xpath = "//input[contains(@class,'btn')]")
//	WebElement submit;
//
//	@FindBy(xpath = "/html/body/section[8]/div[2]/form/div[2]/div/div[2]")
//	WebElement thankYouPopup;

	// demo form (on the Insta page)
	@FindBy(css = "form#freedemo")
	WebElement demoForm;       ////input[@placeholder=' Enter your name ']     // if present; else we use the inputs themselves
	 
//	@FindBy(name = "name")
//	WebElement nameField;
//	 
//	@FindBy(name = "email")
//	WebElement emailField;
//	 
//	@FindBy(name = "number")
//	WebElement phoneField;
//	 
//	@FindBy(name = "city")
//	WebElement cityField;
	
	 
	@FindBy(css = "input.btn.center-block[type='submit'], input[type='submit'][value*='Get free demo']")
	WebElement submitButton;
	
	
	
	// Constructor
	public ProfilePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	public boolean clickFindDoctors1() {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(findDoctorsLink1)).click();
			test.pass("Clicked on 'Find Doctors' link");
			return true;
		} catch (Exception e) {
			test.fail("Failed to click 'Find Doctors': " + e.getMessage());
			return false;
		}
}
	

	public boolean clickConsultWithDoctor() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(consultWithDoctorLink)).click();
			test.pass("Clicked on 'Consult with a doctor' link");
			return true;
		} catch (Exception e) {
			test.fail("Failed to click 'Consult with a doctor': " + e.getMessage());
			return false;
		}
	}

	public void enterSpecialization(String specialization) {
		wait.until(ExpectedConditions.visibilityOf(searchField)).clear();
		searchField.sendKeys(specialization);
	}


	// =============================
	public void clickCorrectSearchResult(String specialization) {
		// Wait for any suggestion to appear
		By anySuggestion = By.cssSelector("div.c-omni-suggestion-item");
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(anySuggestion, 0));

		// Correct XPath for matching specialization
		By suggestionLocator = By
				.xpath("//div[@data-qa-id='omni-suggestion-main' and normalize-space(text())='Dentist']"
						+ specialization + "')]");

		WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(suggestionLocator));

		// Scroll into view and click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", suggestion);
		try {
			suggestion.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", suggestion);
		}
	}

	public boolean areDoctorResultsVisible() {
		List<WebElement> results = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@data-qa-id,'doctor-card')]")));
		return results.size() > 0;
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public boolean selectPopularSearch(String specialty) {
		try {
			WebElement specialtyLink = driver.findElement(By.xpath("//a[text()='" + specialty + "']"));
			wait.until(ExpectedConditions.elementToBeClickable(specialtyLink)).click();
			test.pass("Clicked on '" + specialty + "' link from popular searches");
			return true;
		} catch (Exception e) {
			test.fail("Failed to click '" + specialty + "' from popular searches: " + e.getMessage());
			return false;
		}
	}

	public boolean isOnListingPage(String expectedKeyword) {
		try {
			String currentUrl = driver.getCurrentUrl();
			boolean isCorrectPage = currentUrl.toLowerCase().contains(expectedKeyword.toLowerCase());
			if (isCorrectPage) {
				test.pass("Navigated to listing page containing '" + expectedKeyword + "' in URL");
			} else {
				test.fail("Expected URL to contain '" + expectedKeyword + "', but got: " + currentUrl);
			}
			return isCorrectPage;
		} catch (Exception e) {
			test.fail("Error while validating listing page: " + e.getMessage());
			return false;
		}
	}

	public boolean clickDermatologist() {
		try {
			WebElement dermLink = driver.findElement(By.xpath("//a[text()='Dermatologist']"));
			wait.until(ExpectedConditions.elementToBeClickable(dermLink)).click();
			test.pass("Clicked on 'Dermatologist' link");
			return true;
		} catch (Exception e) {
			test.fail("Failed to click 'Dermatologist': " + e.getMessage());
			return false;
		}
	}

	// -----------------------3 Scenario
	// Outline-------------------------------------------


	public void clickFindDoctors() {
		wait.until(ExpectedConditions.elementToBeClickable(findDoctorsLink));
		findDoctorsLink.click();
	}

	public void enterSpecialization1(String specialization) {
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.clear();
		searchButton.sendKeys(specialization);

		wait.until(ExpectedConditions.visibilityOf(firstSuggestion));
		firstSuggestion.click();
	}

	public void clickSearchButton() {
		wait.until(ExpectedConditions.visibilityOf(clickEnter));
		clickEnter.click();
	}

	public void verifyResults() {
		wait.until(ExpectedConditions.visibilityOf(resultsHeader));
		System.out.println("Results page loaded successfully." + resultsHeader.getText());
	}

//------------------4th Scenario--------------------

	public boolean clickOrderMeds() {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(OrderMedicines)).click();
			test.pass("Clicked on 'Order Medicines");
			// profilePage = PageFactory.initElements(driver, ProfilePage.class);
			return true;
		} catch (Exception e) {
			test.fail("Failed to click 'Consult with a doctor': " + e.getMessage());
			return false;
		}
	}

	public boolean searchMedicine(String medicineName) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			WebElement bar = wait.until(ExpectedConditions.elementToBeClickable(searchOrder));
			bar.click();
//	        //bar.clear();
//	        bar.sendKeys(medicineName);
//	        test.pass("Entered medicine name: " + medicineName);
//
//	       WebElement sug= wait.until(ExpectedConditions.visibilityOf(Suggestion));
////	       su.click();
//	       sug.sendKeys(Keys.ARROW_DOWN);
//	       sug.click(); 
////	        sug.sendKeys(Keys.ENTER);
//	    } catch (Exception e) {
//	        test.fail("Failed to search medicine: " + e.getMessage());
//	        e.printStackTrace();
//	    }

			wait.until(ExpectedConditions.elementToBeClickable(searchOrder)).click();
			// searchOrder.clear();
			searchOrder.sendKeys(medicineName);
			test.pass("Entered medicine name: " + medicineName);

			// wait and click suggestion
			wait.until(ExpectedConditions.visibilityOf(Suggestion)).click();

			return true;

		} catch (Exception e) {
			test.fail("Failed to search medicine: " + e.getMessage());
			return false;
		}

	}
	// Suggestion.click();

	// or click search button

	public void clickSearchButton1() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(clickEnter));
		clickEnter.click();

	}
//---------------------5th scenario-------------------------

	//// h2[@class='h1 text-center']
	@FindBy(xpath = "h2[@class='h1 text-center']")
	WebElement scrolldown;

	public boolean clickFindDoctors2() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(findDoctors2)).click();
			test.pass("Clicked on 'Find Doctors' link");
			return true;
		} catch (Exception e) {
			test.fail("Failed to click 'Find Doctors': " + e.getMessage());
			return false;
		}
	}

	public boolean clickReadArticles() {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(ReadArticles)).click();
			test.pass("Clicked on 'Order Medicines");
			// profilePage = PageFactory.initElements(driver, ProfilePage.class);
			return true;
		} catch (Exception e) {
			test.fail("Failed to click 'Consult with a doctor': " + e.getMessage());
			return false;
		}
	}

	public void enterArticle(String Article) {
		wait.until(ExpectedConditions.visibilityOf(searchb5)).click();
		searchb5.clear();
		searchb5.sendKeys(Article);

//	wait.until(ExpectedConditions.visibilityOf(firstSuggestion));
//	firstSuggestion.click();
	}

	public boolean entersearcharticles() {
		try {

			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchhealthtopic));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			searchhealthtopic.click();

			return true;
		} catch (Exception e) {

			return false;
		}

	}

//----------------------------form-------------------------------

//	public void scrollToInstaSection() {
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", instaSection);
//		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(instaSection));
//		instaSection.click();
//	}
	public void scrollToInstaSection() {
	    ((JavascriptExecutor) driver)
	          .executeScript("arguments[0].scrollIntoView({behavior:'auto', block:'center'});",
	                          instaSection);
	 
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	           .until(ExpectedConditions.visibilityOf(instaSection));
	 
	    instaSection.click();
	}
	public void scrollDownAfterInstaSection() {
	    try {
	        Thread.sleep(1000); // Give time for any animations or content load
	        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

//================================================================================
	@FindBy(xpath = "//input[@placeholder=' Enter your name ']")
	WebElement nameField;
	
	@FindBy(xpath = "//input[@placeholder=' Enter your email address ']")
	WebElement emailField;
	 
	@FindBy(xpath = "//input[@class='require phone error']")
	WebElement phoneField;
	////input[@class='require phone error']   //input[@placeholder=' Enter your number ']
	 
	@FindBy(xpath = "//input[@placeholder=' Enter your city ']")
	WebElement cityField;
	
	public void waitForPageToLoad() {
	    new WebDriverWait(driver, Duration.ofSeconds(15)).until(
	        webDriver -> ((JavascriptExecutor) webDriver)
	            .executeScript("return document.readyState").equals("complete")
	    );
	}
	public void scrollToDemoForm() throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	    // scroll slowly until the form is found
	    for (int i = 0; i < 15; i++) {
	        js.executeScript("window.scrollBy(0, 400);");
	        Thread.sleep(500);
	 
	        try {
	            if (nameField.isDisplayed()) {
	                js.executeScript("arguments[0].scrollIntoView({block:'center'});", nameField);
	                break;
	            }
	        } catch (Exception ignored) {}
	    }
	}
	public void forceScrollToForm() throws InterruptedException {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	 
	    // scroll full page slowly until the form appears
	    long scrollPosition = 0;
	    long pageHeight = (long) js.executeScript("return document.body.scrollHeight");
	 
	    for(int i = 0; i < 15; i++) {
	        js.executeScript("window.scrollBy(0, 600);");
	        Thread.sleep(500);
	 
	        // try if name field is visible now
        try {
	            if (nameField.isDisplayed()) {
	                js.executeScript("arguments[0].scrollIntoView({block:'center'});", nameField);
	                break;
	            }
	        } catch (Exception ignored) {}
	    }
//	 
	    Thread.sleep(1000);
	}
	 
	// call this after reading Excel row into Map<String,String> formData
	public void fillDemoFormFromMap(Map<String,String> formData) throws InterruptedException {
		System.out.println("Form Data from Excel: " + formData);
	    enterName(formData.get("Name"));      // or key from your Excel header
	    enterEmail(formData.get("Email"));
	    enterPhone(formData.get("Phone"));    // number as string
	    enterCity(formData.get("City"));
	}
	 
	public void enterName(String value) {
		//System.out.println(value);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(nameField));
	    nameField.clear();
	    wait.until(ExpectedConditions.elementToBeClickable(nameField));
	    nameField.sendKeys(value);
	    
	}
	 
	public void enterEmail(String value) {
		//System.out.println(value);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(emailField));
	    emailField.clear();
	    emailField.sendKeys(value);
	}
	 
//	public void enterPhone(String value) {
//		//System.out.println(value);
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.visibilityOf(phoneField));
//	    phoneField.clear();
//	    // if your excel phone is numeric, ensure string:
//	    phoneField.sendKeys(String.valueOf(value));
//	}
	//2
	//working
	public void enterPhone(String phone) {
	    try {
	        WebElement phoneInput = driver.findElement(By.xpath("//form[@id='freedemo']//input[@name='number']"));
	       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phoneInput);
	        phoneInput.click();
	        phoneInput.clear();
	        phoneInput.sendKeys(phone.replaceAll("\\D", "")); // Ensure only digits
	        test.pass("Entered phone number: " + phone);
	    } catch (Exception e) {
	        test.fail("Failed to enter phone number: " + e.getMessage());
	    }
	}
	//3
//	public void enterPhone(String phone) throws InterruptedException {
//	    try {
////	        WebElement phoneInput = driver.findElement(By.xpath("//form[@id='freedemo']//input[@name='number']"));
////	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phoneInput);
////	        //phoneInput.click(); // Ensure focus
////	        phoneInput.clear();
////	        phoneInput.sendKeys(phone.replaceAll("\\D", "")); // Only digits
//	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	    	//wait.until(ExpectedConditions.elementToBeClickable(phoneField));
//		    wait.until(ExpectedConditions.visibilityOf(phoneField));
//		    phoneField.clear();
//		    phoneField.click();
//		   // long phone1=Long.parseLong(phone);
//		    phoneField.sendKeys(phone.replaceAll("\\D", "")); 
//		   // phoneField.sendKeys(String.valueOf(phone1));
//		    phoneField.sendKeys(phone);
//	        test.pass("Entered phone number: " + phone);
//	    } catch (Exception e) {
//	        test.fail("Failed to enter phone number: " + e.getMessage());
//	    }
//	    Thread.sleep(2000);
//	}
	
	//4
//	public void enterPhone(String phone) {
//	    try {
//	        WebElement phoneInput = driver.findElement(By.xpath("//form[@id='freedemo']//input[@name='number']"));
//	       // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", phoneInput);
//	        phoneInput.click();
//	        phoneInput.clear();
//	        phoneInput.sendKeys(phone.replaceAll("\\D", "")); // Ensure only digits
//	        test.pass("Entered phone number: " + phone);
//	    } catch (Exception e) {
//	        test.fail("Failed to enter phone number: " + e.getMessage());
//	    }
//	}
	
	public void enterCity(String value) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(cityField));
	    cityField.clear();
	    cityField.sendKeys(value);
	}
	//2
	
	public void submitDemoForm() throws InterruptedException {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
	        submitButton.click();
	    } catch (Exception e) {
	        // fallback JS click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
	    }
	 
	    // optional: wait for thank you text to appear
	    try {
	        Thread.sleep(1500);
	    } catch (InterruptedException ignored) {}
	}
	public boolean verifySuccess() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	 
	    // Wait for the success div to appear
	    WebElement successMsg = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("div.text-center.margin-v.send_success")
	        )
	    );
	 
	    // Validate the text (optional but recommended)
	    String msg = successMsg.getText();
	    System.out.println("Success Message: " + msg);
	 
	    if (!msg.toLowerCase().contains("thank you")) {
	        throw new AssertionError("Success message not displayed correctly!");
	    }
	 
	    // Optional: small pause to visually confirm
	    Thread.sleep(1000);
	    return true;
	}
	
}
