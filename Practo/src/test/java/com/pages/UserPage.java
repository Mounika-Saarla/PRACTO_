
//----------------Scenario:1-------------------------------

/*package com.pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.PropertyReader;

public class UserPage {

	WebDriver driver;
	private WebDriverWait wait;

	// Constructor
	public UserPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
			return false;}

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
	}*/



//-------------------Scenario:2-----------------------------




/*  private void waitForPageLoad() {
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
	    }*/



//--------------------Scenario:3------------------------------




/*package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserPage {
    WebDriver driver;

    // Constructor
    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for Health Packages section
    private By healthPackagesSection = By.xpath("//h1[contains(text(),'Health Packages')]");

    // Locator for Book Now button
    private By bookNowButton = By.xpath("//button[contains(text(),'Book Now')]");

    // Method to verify Health Packages section is visible
    public boolean isHealthPackagesSectionVisible() {
        try {
            WebElement section = driver.findElement(healthPackagesSection);
            return section.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click Book Now button
    public void clickBookNow() {
        try {
            WebElement button = driver.findElement(bookNowButton);
            button.click();
        } catch (Exception e) {
            System.out.println("Book Now button not found or not clickable: " + e.getMessage());
        }
    }
}*/


//---------------------------Scenario- outline------------------------

/*package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.PropertyReader;

public class UserPage {

    WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    private By labTestsLink = By.linkText("Lab Tests");
    private By fever = By.xpath("//div[contains(text(),'Fever')]");
    private By diabetes = By.xpath("//div[contains(text(),'Diabetes')]");
    private By skin = By.xpath("//div[contains(text(),'Skin')]");

    // ✅ Handle overlay by clicking city directly
    public void handleCityOverlay() {
        try {
            String cityName = PropertyReader.getProperty("overlayCityInput"); // e.g., Bangalore
            By cityDirectElement = By.xpath("//div[text()='" + cityName + "']");

            // Wait for city element and click it
            WebElement cityOption = wait.until(ExpectedConditions.elementToBeClickable(cityDirectElement));
            cityOption.click(); // ✅ Direct click, no scroll, no JS

            System.out.println("Overlay closed by selecting city: " + cityName);
        } catch (Exception e) {
            System.out.println("City overlay not present, continuing...");
        }
    }

    public void openHomePage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void clickLabTestsLink() {
        driver.findElement(labTestsLink).click();
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

}*/

//-------------------------------Scenario_outline:2---------------------------------------

package com.pages;

import com.parameters.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class UserPage {

    private WebDriver driver;

    // Constructor
    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    // Launch Practo application
    public void launchApplication() {
        driver.get(PropertyReader.getProperty("app.url"));
    }

    // Click Lab Tests link
    public void clickLabTests() {
        WebElement labTestsLink = driver.findElement(By.linkText(PropertyReader.getProperty("labtests.linktext")));
        labTestsLink.click();
    }

    // Click For Providers link
    public void clickForProviders() {
        WebElement forProvidersLink = driver.findElement(By.linkText(PropertyReader.getProperty("forproviders.linktext")));
        forProvidersLink.click();
    }

    // Select Software for Providers from dropdown
    public void selectSoftwareForProviders() {
        WebElement dropdown = driver.findElement(By.id(PropertyReader.getProperty("provider.dropdown.id")));
        Select select = new Select(dropdown);
        select.selectByVisibleText(PropertyReader.getProperty("provider.dropdown.option"));
    }

    // Navigate to provider link from Excel
    public void navigateToProviderLink(int sheetIndex, int rowIndex) {
        String excelPath = PropertyReader.getProperty("excel.path");
        try (FileInputStream fis = new FileInputStream(excelPath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(0); // Assuming link is in first column
            String providerLink = cell.getStringCellValue();

            driver.get(providerLink);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel file: " + excelPath);
        }
    }

    // Verify provider page
    public static boolean isProviderPageDisplayed(WebDriver driver) {
        String expectedKeyword = PropertyReader.getProperty("provider.page.keyword");
        return driver.getCurrentUrl().contains(expectedKeyword);
    }
}