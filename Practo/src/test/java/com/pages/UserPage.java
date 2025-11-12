
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
	


//--------------------Scenario-outline------------------------------


   

    

 package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class UserPage {
    WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHealthPackages() {
        driver.findElement(By.xpath("//a[contains(text(),'Health Packages')]")).click();
    }

    public void clickOnPackage(String packageName) {
        driver.findElement(By.xpath("//h2[contains(text(),'" + packageName + "')]")).click();
    }

    public boolean verifyPackageDetails(String expectedPackageName) {
        String actualTitle = driver.findElement(By.xpath("//h1")).getText();
        return actualTitle.contains(expectedPackageName);
    }

    public void clickBookNow() {
        driver.findElement(By.xpath("//button[contains(text(),'Book Now')]")).click();
    }

    public void enterBookingDetails(Map<String, String> rowData) {
        driver.findElement(By.name("name")).sendKeys(rowData.get("name"));
        driver.findElement(By.name("age")).sendKeys(rowData.get("age"));
        driver.findElement(By.name("gender")).sendKeys(rowData.get("gender"));
        driver.findElement(By.name("contact")).sendKeys(rowData.get("contact"));
    }

    public void submitBooking() {
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
    }

    public boolean validateBookingResult(String expectedResult) {
        String actualMessage = driver.findElement(By.xpath("//div[@class='confirmation-message']")).getText();
        return actualMessage.contains(expectedResult);
    }
}