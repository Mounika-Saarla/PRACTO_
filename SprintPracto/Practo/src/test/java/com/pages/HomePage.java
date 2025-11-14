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

	@FindBy(xpath = "//span[text()='You Cart']")
	private WebElement goToCartButton;


	@FindBy(xpath = "//input[@placeholder='Search for Tests, Packages and Profiles']")
	private WebElement searchBox;

	@FindBy(xpath = "//*[@id=\"root-app\"]/div/div/div[2]/div/div[2]/div/div/div")
	private WebElement searchResultsContainer;

	//Ts_03

	//@FindBy(xpath = "//input[@class='c-search__input']")
	@FindBy(css = "#omniSearch")
	private WebElement searchForTests;

	@FindBy(xpath = "//span[text()='Your Cart']")
	private WebElement testVerify;

	//Ts_04


	@FindBy(xpath = "//input[@class='c-search__input--location']")
	private WebElement searchForCity;

	@FindBy(xpath = "//input[@class='c-search__input citylist']")
	private WebElement selectACity;

	@FindBy(xpath = "//span[text()='Your Cart']")
	private WebElement verifyCity;

	@FindBy(xpath = "(//div[text()='Hyderabad'])[1]")
	private WebElement selectHyderabad;
	
	@FindBy(xpath = "(//div[text()='Delhi'])[1]")
	private WebElement selectDelhi;
	
	@FindBy(xpath = "(//div[text()='Chennai'])[1]")
	private WebElement selectChennai;
	
	@FindBy(xpath = "//h1[text()='Lipid Profile']")
	private WebElement verifyFinalPage;

	//Ts_05
	@FindBy(xpath = "//div[text()='Book Now']")
	private WebElement selectBookNow;

	@FindBy(xpath = "//div[text()='Add patient details']")
	private WebElement verifyAddPatient;


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

	//Ts_02
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
	public void clickTests() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		searchForTests.click();
	}

	public void enterTest(int sheet , int row ) throws IOException   {
		String[] testData = ExcelReader.getRowData(sheet, row); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchForTests);
		searchForTests.sendKeys(testData);
		//System.out.println("DEBUG: Sent to search box -> " + TestName);
	}
	public void verifyTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(testVerify));
		wait.until(ExpectedConditions.visibilityOf(testVerify)).isDisplayed();
	}

	//Ts_04
	public void searchCity() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(searchForCity));
		searchForCity.click();
	}

	public void selectACity() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(selectACity));
		selectACity.click();
	}

	public void enterCityName(int sheet, int row) throws IOException {
	    String[] cityData = ExcelReader.getRowData(sheet, row); // Assuming ExcelReader returns String[]
	    String cityName = cityData[0]; // First column contains city name

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Click input box using JS to avoid interception
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectACity);
	    selectACity.clear();
	    selectACity.sendKeys(cityName);

	    // Wait for dropdown and click matching city
	    if (cityName.equalsIgnoreCase("Hyderabad")) {
	        wait.until(ExpectedConditions.elementToBeClickable(selectHyderabad)).click();
	    } else if (cityName.equalsIgnoreCase("Delhi")) {
	        wait.until(ExpectedConditions.elementToBeClickable(selectDelhi)).click();
	    } else if (cityName.equalsIgnoreCase("Chennai")) {
	        wait.until(ExpectedConditions.elementToBeClickable(selectChennai)).click();
	    }
	}

	public void clickCityToSearch() {
		wait.until(ExpectedConditions.visibilityOf(selectACity));
		selectACity.click();
	}

	public void verifyCity() {
		wait.until(ExpectedConditions.visibilityOf(verifyFinalPage));
	}


	//Ts_05
	public void bookNow() {
		wait.until(ExpectedConditions.visibilityOf(selectBookNow));
		selectBookNow.click();
	}

	public void addPatientDetails() {
		wait.until(ExpectedConditions.visibilityOf(verifyAddPatient));
	}


}

