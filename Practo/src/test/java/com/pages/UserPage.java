
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

package com.pages;

import com.setup.BaseSteps;
import com.parameters.PropertyReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class UserPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public UserPage() {
        driver = BaseSteps.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void launchApp() {
        driver.get(PropertyReader.get("AppUrl"));
    }

    public void handleCitySelection() {
        try {
            WebElement cityModal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'Select a city')]")));
            if (cityModal.isDisplayed()) {
                WebElement city = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[text()='Bangalore']")));
                city.click();
                System.out.println("City selected: Bangalore");
            }
        } catch (TimeoutException e) {
            System.out.println("City selection modal not displayed, continuing...");
        }
    }

    public void clickLabTests() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyReader.get("LabTestsXpath")))).click();
    }

    public void scrollToHealthPackage() {
        WebElement section = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyReader.get("HealthPackageXpath"))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", section);
    }

    public void selectPackageByName(String packageName) {
        String dynamicXpath = String.format(PropertyReader.get("PackageNameXpath"), packageName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath))).click();
    }

    public void clickBookNow() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyReader.get("BookNowXpath")))).click();
    }

    public boolean isBookingPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyReader.get("BookingPageXpath")))).isDisplayed();
    }

    public void enterPatientDetails(String name, String ageType, String gender, String mobile) {
        driver.findElement(By.xpath(PropertyReader.get("PatientNameXpath"))).sendKeys(name);

        Select ageDropdown = new Select(driver.findElement(By.xpath(PropertyReader.get("AgeXpath"))));
        ageDropdown.selectByVisibleText("Years");

        String genderXpath = String.format(PropertyReader.get("GenderXpath"), gender);
        driver.findElement(By.xpath(genderXpath)).click();

        driver.findElement(By.xpath(PropertyReader.get("ContactXpath"))).sendKeys(mobile);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyReader.get("ContinueXpath")))).click();
    }

    public void verifyBookingResult(String expectedResult) {
        WebElement resultElement = driver.findElement(By.xpath("//div[@class='booking-result']")); 
        String actualResult = resultElement.getText().trim();

        if (actualResult.equalsIgnoreCase(expectedResult)) {
            System.out.println("Booking result verified successfully: " + actualResult);
        } else {
            throw new AssertionError("Expected: " + expectedResult + " but found: " + actualResult);
        }
    }
    }