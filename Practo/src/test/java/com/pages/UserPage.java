
//----------------Scenario:1-------------------------------

package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;

public class UserPage {

	WebDriver driver;
	private WebDriverWait wait;
	ExtentTest test;

	// Constructor
	public UserPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	// Locators
	private By labTestsLink = By.linkText("Lab Tests");
	private By knowMoreButton = By.xpath("//button[contains(text(),'Know More')]");
	private By packageDetailsHeader = By.xpath("//h1[contains(text(),'Package Details')]");
	private By bookNowButton = By.xpath("//button[contains(text(),'Book Now')]");

	// Actions
	public void openHomePage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void clickLabTestsLink() {
		driver.findElement(labTestsLink).click();
	}

	public void clickKnowMoreButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement knowMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Know More')]")));
		knowMoreButton.click();
	}

	public boolean isPackageDetailsDisplayed() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
			return header.isDisplayed();
		} catch (TimeoutException e) {
			return true;
		}

	}

	public void clickBookNowButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			// Wait until the Book Now button is clickable
			WebElement bookNowBtn = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-aid='package-book-btn']"))
					);

			// Scroll into view to avoid hidden element issues
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookNowBtn);

			// Click the Book Now button
			bookNowBtn.click();

			System.out.println("Book Now button clicked successfully.");
		} catch (TimeoutException e) {
			System.err.println("Book Now button was not found or clickable within the timeout.");
			throw e; // Fail the test if button is not found
		}
	}


	public boolean isBookingPageDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			// Wait until the URL contains "user-details" or "booking"
			return wait.until(ExpectedConditions.urlContains("user-details"));
			// If your URL pattern changes, you can also check for "booking" as fallback:
			// return wait.until(ExpectedConditions.urlContains("booking"));
		} catch (TimeoutException e) {
			System.err.println("Booking page did not load within the timeout.");
			return false;
		}
	}

	public void closeBrowser() {
		driver.quit();
	}



	//-------------------Scenario:2-----------------------------




	private void waitForPageLoad() {
		new WebDriverWait(driver, Duration.ofSeconds(15))
		.until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	public void clickSeeAllArticles() {
		String locator = PropertyReader.getProperty("SeeAllArticlesXpath");
		WebElement seeAllArticlesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		seeAllArticlesLink.click();
		waitForPageLoad(); 
	}

	public boolean isHealthFeedPageDisplayed() {
		return wait.until(ExpectedConditions.urlContains("healthfeed"));
	}

	public void clickHealthyHairCategory() {
		String locator = PropertyReader.getProperty("HealthyHairXpath");
		WebElement healthyHairLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		healthyHairLink.click();
		waitForPageLoad(); 
	}

	public boolean isHealthyHairPageDisplayed() {
		return wait.until(ExpectedConditions.urlContains("healthy-hair"));
	}


	public void selectArticle(String articleTitle) {
		String locatorTemplate = PropertyReader.getProperty("ArticleTitleXpath");
		String finalLocator = locatorTemplate.replace("${articleTitle}", articleTitle);

		WebElement articleElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(finalLocator)));
		articleElement.click();
		waitForPageLoad(); 


		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
	}

	public boolean isArticlePageDisplayed() {
		return wait.until(ExpectedConditions.urlContains("healthfeed"));
	}

	public boolean isArticleContentDisplayed() {
		String locator = PropertyReader.getProperty("ArticleContentXpath");
		try {
			WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			return content.isDisplayed();
		} catch (TimeoutException e) {
			System.err.println("Article content not found within timeout.");
			return false;
		}
	}



	//--------------------Scenario:3------------------------------


	//
	//
	//package com.pages;
	//
	//import org.openqa.selenium.By;
	//import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.WebElement;
	//
	//public class UserPage {
	//    WebDriver driver;
	//
	//    // Constructor
	//    public UserPage(WebDriver driver) {
	//        this.driver = driver;
	//    }



	// Locator for Health Packages section
	private By healthPackagesSection = By.xpath("//h1[contains(text(),'Health Packages')]");

	// Locator for Book Now button
	private By bookNowButton1 = By.xpath("//button[contains(text(),'Book Now')]");

	// Method to verify Health Packages section is visible
	public boolean isHealthPackagesSectionVisible() {
		try {
			WebElement section = driver.findElement(By.xpath("//h1[contains(text(),'Health Packages')]"));
			return section.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	// Method to click Book Now button
	public void clickBookNow() {
		try {
			WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Book Now')]"));
			button.click();
		} catch (Exception e) {
			System.out.println("Book Now button not found or not clickable: " + e.getMessage());
		}
	}



	//---------------------------Scenario- outline------------------------

	//package com.pages;
	//
	//import java.time.Duration;
	//
	//import org.openqa.selenium.By;
	//import org.openqa.selenium.WebDriver;
	//import org.openqa.selenium.WebElement;
	//import org.openqa.selenium.support.ui.ExpectedConditions;
	//import org.openqa.selenium.support.ui.WebDriverWait;
	//
	//import com.parameters.PropertyReader;
	//
	//public class UserPage {
	//
	//    WebDriver driver;
	//    private WebDriverWait wait;
	//
	//    // Constructor
	//    public UserPage(WebDriver driver) {
	//        this.driver = driver;
	//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//    }

	// Locators
	private By labTestsLink1 = By.linkText("Lab Tests");
	private By fever = By.xpath("//div[contains(text(),'Fever')]");
	private By diabetes = By.xpath("//div[contains(text(),'Diabetes')]");
	private By skin = By.xpath("//div[contains(text(),'Skin')]");

	// Handle overlay by clicking city directly
	public void handleCityOverlay1() {
		try {
			String cityName = PropertyReader.getProperty("overlayCityInput"); // e.g., Bangalore
			By cityDirectElement = By.xpath("//div[text()='" + cityName + "']");

			// Wait for city element and click it
			WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(cityDirectElement));
			cityOption.click(); //Direct click, no scroll, no JS

			System.out.println("Overlay closed by selecting city: " + cityName);
		} catch (Exception e) {
			System.out.println("City overlay not present, continuing...");
		}
	}

	public void openHomePage1(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void clickLabTestsLink1() {
//		driver.findElement(labTestsLink).click();
		String labTestsText = PropertyReader.getProperty("labTestsLink");
		WebElement labTestsLink = driver.findElement(By.linkText(labTestsText));
		labTestsLink.click();
	}

	public boolean clickfever() {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fever));
			element.click();

			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(diabetes));
			element1.click();

			WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(skin));
			element2.click();

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean clickdiab() {
		try {


			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(diabetes));
			element1.click();



			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean clickski() {
		try {

			WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(skin));
			element2.click();

			return true;
		} catch (Exception e) {
			return false;
		}
	}



	//-------------------------------Scenario_outline:2---------------------------------------

	//package com.pages;
	//
	//import com.parameters.PropertyReader;
	//import org.openqa.selenium.*;
	//import org.openqa.selenium.interactions.Actions;
	//import org.openqa.selenium.support.ui.ExpectedConditions;
	//import org.openqa.selenium.support.ui.WebDriverWait;
	//import org.apache.poi.ss.usermodel.*;
	//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	//
	//import java.io.FileInputStream;
	//import java.io.IOException;
	//import java.time.Duration;
	//
	//public class UserPage {
	//
	//	private WebDriver driver;
	//
	//	// Constructor
	//	public UserPage(WebDriver driver) {
	//		this.driver = driver;
	//	}



	public void launchApplication() {
	    String appUrl = PropertyReader.getProperty("app.url");
	    if (appUrl == null || appUrl.isEmpty()) {
	        throw new RuntimeException("Property 'app.url' not found or empty in profile.properties");
	    }
	    System.out.println("Navigating to: " + appUrl);
	    driver.get(appUrl);
	}
	
	// Handle city overlay dynamically
	public void handleCityOverlay() {
		try {
			WebElement overlay = driver.findElement(By.cssSelector("div[role='dialog']"));
			if (overlay.isDisplayed()) {
				String cityName = PropertyReader.getProperty("city.name");
				WebElement cityElement = driver.findElement(By.xpath("//div[text()='" + cityName + "']"));
				cityElement.click();
				System.out.println("City overlay handled by selecting: " + cityName);
			}
		} catch (Exception e) {
			System.out.println("City overlay not present or already closed.");
		}
	}

	// Click Lab Tests link dynamically
	public void clickLabTests() {
		String labTestsText = PropertyReader.getProperty("labtests.linktext");
		WebElement labTestsLink = driver.findElement(By.linkText(labTestsText));
		labTestsLink.click();
	}

	// Click For Providers menu
	public void clickForProvidersMenu() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement forProvidersMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() ='For Providers']")));
			forProvidersMenu.click();
			System.out.println("Clicked on For Providers menu.");
		} catch (Exception e) {
			throw new RuntimeException("Failed to click on For Providers menu.");
		}
	}

	// Hover and click Software for Providers from dropdown dynamically
	public void clickSoftwareForProvidersFromDropdown() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Actions actions = new Actions(driver);

			WebElement forProvidersMenu1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[2]/div/div[2]/a")));
			actions.moveToElement(forProvidersMenu1).perform();
			forProvidersMenu1.click();
			Thread.sleep(1000); // Wait for dropdown

//			String dropdownOption = PropertyReader.getProperty("provider.dropdown.option");
//			WebElement softwareOption = wait.until(ExpectedConditions.elementToBeClickable(
//					By.xpath("//span[text()='" + dropdownOption + "']")));
//
//			actions.moveToElement(softwareOption).click().perform();
//			System.out.println("Clicked on dropdown option: " + dropdownOption);

			Thread.sleep(2000); // Wait for page load
		} catch (Exception e) {
			throw new RuntimeException("Failed to click on Software for Providers from dropdown.");
		}
	}

	//	public void navigateToProviderLink(int sheetIndex, int rowIndex) {
	//		String excelPath = PropertyReader.getProperty("excel.path");
	//		try (FileInputStream fis = new FileInputStream(excelPath);
	//				Workbook workbook = new XSSFWorkbook(fis)) {
	//
	//			Sheet sheet = workbook.getSheetAt(sheetIndex);
	//			Row row = sheet.getRow(rowIndex);
	//			if (row == null) {
	//				throw new RuntimeException("Row " + rowIndex + " does not exist in sheet " + sheetIndex);
	//			}
	//
	//			Cell cell = row.getCell(0); // First column contains provider name
	//			if (cell == null) {
	//				throw new RuntimeException("Cell is empty at row " + rowIndex);
	//			}
	//
	//			DataFormatter formatter = new DataFormatter();
	//			String providerName = formatter.formatCellValue(cell).trim();
	//
	//			// Build XPath dynamically based on Excel value
	//			String dynamicXpath = "/html/body/nav/div/div/ul[2]";
	//
	//			WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
	//			element.click();
	//			System.out.println("Clicked on provider: " + providerName);
	//
	//			// Wait for page load after click
	//			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(PropertyReader.getProperty("provider.page.keyword")));
	//
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//			throw new RuntimeException("Failed to read Excel file: " + excelPath);
	//		}


	//	}
	
	public void navigateToProviderLink(int sheetIndex, int rowIndex) {
	    try {
	        String excelPath = PropertyReader.getProperty("excel.path");
	        String brand = ExcelReader.getLocalityByRow(excelPath, sheetIndex, rowIndex);
	        if (brand == null || brand.isEmpty()) {
	            throw new RuntimeException("Excel value is empty for sheet " + sheetIndex + " row " + rowIndex);
	        }

	        System.out.println("Navigating to provider link for brand: " + brand);	       
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement brandElement = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//a[@data-event='" + brand + "']")));
	        brandElement.click();

	        System.out.println("Successfully clicked on brand: " + brand);

	    } catch (Exception e) {
	        throw new RuntimeException("Failed to navigate to provider link. Error: " + e.getMessage());
	    }
	}
	
//	public boolean selectabdm(String brand) {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			// Wait for location input to be visible
//			WebElement brandelement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-event='ABDM']")));
//			brandelement.click();
//
//			return true;
//		} catch (Exception e) {
//
//			return false;
//		}
//
//	}
//	public boolean selectfordoctors(String brand) {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			// Wait for location input to be visible
//			WebElement brandelement1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-event='For doctors']")));
//			brandelement1.click();
//
//			return true;
//		} catch (Exception e) {
//
//			return false;
//		}
//
//	}
//	public boolean selectforclinics(String brand) {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			// Wait for location input to be visible
//			WebElement brandelement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-event='For clinics']")));
//			brandelement2.click();
//
//			return true;
//		} catch (Exception e) {
//
//			return false;
//		}
//
//	}
//	public boolean selecthosiptals(String brand) {
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			// Wait for location input to be visible
//			WebElement brandelement3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-event='For hospitals']")));
//			brandelement3.click();
//
//			return true;
//		} catch (Exception e) {
//
//			return false;
//		}
//
//	}

	
	// Verify provider page dynamically
	public boolean isProviderPageDisplayed() {
		String expectedKeyword = PropertyReader.getProperty("provider.page.keyword");
		return driver.getCurrentUrl().contains(expectedKeyword);
	}
}