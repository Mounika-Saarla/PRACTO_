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

	@FindBy(xpath = "(//div[text()='ADD'])[1]")
	private WebElement addfirst;
	
	@FindBy(xpath = "(//div[text()='ADD'])[2]")
	private WebElement addSecond;
	
	@FindBy(xpath = "//div[text()='Proceed to Checkout']")
	private WebElement checkout;
	
	@FindBy(xpath = "//div[text()='Add patient details']")
	private WebElement patientDetails;
	

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

	public void enterTest(String[] TestName) throws IOException   {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchForTests);
		searchBox.sendKeys(TestName);
		System.out.println("DEBUG: Sent to search box -> " + TestName);
	}
	public void verifyTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(testVerify));
		wait.until(ExpectedConditions.visibilityOf(testVerify)).isDisplayed();
	}

	//Ts_04
	public void addFirstTest(int sheetNo, int rowNum) throws IOException {
		String[] firstTestpath = ExcelReader.getRowData(sheetNo, rowNum);
		wait.until(ExpectedConditions.visibilityOf(addfirst));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", addfirst);
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstTestpath);

	}

	public void addSecondTest(int sheetNo, int rowNum) {

	}

	public void proceedToCheckout() {

	}

	public void verifyPatientDetails() {

	}



}

