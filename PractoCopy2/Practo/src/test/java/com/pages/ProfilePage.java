//
//package com.pages;
// 
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.setup.BaseSteps;
// 
//public class ProfilePage {
//	private static WebDriver driver;
//    private static WebDriverWait wait;
//    static ExtentTest test;
//
//    private By findDoctorsLink1 = By.linkText("Find Doctors");
//    private By searchField = By.xpath("//input[@data-qa-id='omni-searchbox-keyword']");
//    private By doctorResults = By.xpath("//div[contains(@data-qa-id,'doctor-card')]");
//    
//    // Locators
//    private static By findDoctorsLink = By.xpath("(//div[@class='product-tab__title'])[1]");
//    private static By consultWithDoctorLink = By.xpath("//span[text()='Consult with a doctor']");
//
//    public ProfilePage(WebDriver driver, ExtentTest test)
//	{
//		this.driver=driver;
//		this.test = test;
//		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		//PageFactory.initElements(driver, this);
//	}
//
// 
////    public static boolean clickFindDoctors() {
////        WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(10));
////        wait.until(ExpectedConditions.elementToBeClickable(findDoctorsLink)).click();
////    }
////    
////    
////    public void enterSpecialization(String specialization) {
////        WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(10));
////        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
////        box.clear();
////        box.sendKeys(specialization);
////    }
////    
////    	
////    
////    public void clickCorrectSearchResult(String specialization) {
////        WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(15));
////     
////        // Wait for suggestions
////        By anySuggestion = By.cssSelector("div.c-omni-suggestion-item");
////        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(anySuggestion, 0));
////     
////        // CORRECT XPATH FOR PRACTO
////        By target = By.xpath(
////            "//div[contains(@class,'c-omni-suggestion-item')]//div[@data-qa-id='omni-suggestion-main' and contains(.,'"
////            + specialization + "')]"
////        );
////     
////        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(target));
////        wait.until(ExpectedConditions.elementToBeClickable(el));
////     
////        ((JavascriptExecutor) BaseSteps.driver)
////            .executeScript("arguments[0].scrollIntoView({block:'center'});", el);
////     
////        try {
////            el.click();
////        } catch (Exception e) {
////            ((JavascriptExecutor) BaseSteps.driver).executeScript("arguments[0].click();", el);
////        }
////    }
////    
//// 
////
//    public boolean areDoctorResultsVisible() {
//        WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(30));
//        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(doctorResults));
//        return results.size() > 0;
//    }
//
////    public static boolean clickFindDoctors1() {
////        driver.findElement(findDoctorsLink).click();
////		return false;
////    }
////
////    public static boolean clickConsultWithDoctor() {
////        driver.findElement(consultWithDoctorLink).click();
////		return false;
////    }
////
////    public String getCurrentUrl() {
////        return driver.getCurrentUrl();
////    }
////===============================
//    	public void enterSpecialization(String specialization) {
//        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
//        box.clear();
//        box.sendKeys(specialization);
//    }
//    	
//    	//div[@data-qa-id='omni-suggestion-main' and contains(text(),'
// public void clickCorrectSearchResult(String specialization) {
//      By suggestionLocator = By.xpath("//div[text()='Dentist']" + specialization + "')]");
//   WebElement suggestion = wait.until(ExpectedConditions.elementToBeClickable(suggestionLocator));
//    suggestion.click();
//  }
////   
////==================================
//    public boolean clickFindDoctors1() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(findDoctorsLink1)).click();
//            test.pass("Clicked on 'Find Doctors' link");
//            return true;
//        } catch (Exception e) {
//            test.fail("Failed to click 'Find Doctors': " + e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean clickConsultWithDoctor() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(consultWithDoctorLink)).click();
//            test.pass("Clicked on 'Consult with a doctor' link");
//            return true;
//        } catch (Exception e) {
//            test.fail("Failed to click 'Consult with a doctor': " + e.getMessage());
//            return false;
//        }
//    }
//    public String getCurrentUrl() {
//        return driver.getCurrentUrl();
//    }
//
//    //3rd Scenario
//    // Method to select Dermatologist from popular searches
//    public boolean selectPopularSearch(String specialty) {
//        try {
//            WebElement specialtyLink = driver.findElement(By.xpath("//a[text()='" + specialty + "']"));
//            wait.until(ExpectedConditions.elementToBeClickable(specialtyLink)).click();
//            test.pass("Clicked on '" + specialty + "' link from popular searches");
//            return true;
//        } catch (Exception e) {
//            test.fail("Failed to click '" + specialty + "' from popular searches: " + e.getMessage());
//            return false;
//        }
//    }
//
//    // Method to validate navigation to Dermatologist listing page
//    public boolean isOnListingPage(String expectedKeyword) {
//        try {
//            String currentUrl = driver.getCurrentUrl();
//            boolean isCorrectPage = currentUrl.toLowerCase().contains(expectedKeyword.toLowerCase());
//            if (isCorrectPage) {
//                test.pass("Navigated to listing page containing '" + expectedKeyword + "' in URL");
//            } else {
//                test.fail("Expected URL to contain '" + expectedKeyword + "', but got: " + currentUrl);
//            }
//            return isCorrectPage;
//        } catch (Exception e) {
//            test.fail("Error while validating listing page: " + e.getMessage());
//            return false;
//        }
//    }
//    public boolean clickDermatologist() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Dermatologist']")))).click();
//            test.pass("Clicked on 'Dermatologist' link");
//            return true;
//        } catch (Exception e) {
//            test.fail("Failed to click 'Dermatologist': " + e.getMessage());
//            return false;
//        }
//    }
//    
//
//}
// 

package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class ProfilePage {

	private static WebDriver driver;
	private static WebDriverWait wait;
	static ExtentTest test;

	// PageFactory WebElements
	@FindBy(linkText = "Find Doctors")
	private WebElement findDoctorsLink1;

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
	@FindBy(xpath = "//input[@placeholder='Search for medicines, health products and more']")

	WebElement searchOrder;
	//*[@id="root"]/div[1]/div[2]/div/div[1]/div/div/input
	// input[@type='text']
   
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/div[1]/div/div[2]")
	private WebElement Suggestion;
	
	@FindBy(xpath ="//*[@id=\"root\"]/div/div/div[1]/div[1]/div[2]/div/div[2]/div[1]/a/div[1]")
	private WebElement findDoctors2;
	
	@FindBy(xpath ="//*[@id=\"container\"]/div[2]/div[1]/div[2]/div/a[5]/i")
	private WebElement ReadArticles;
	
//    @FindBy(xpath ="//*[@id=\"searchBar\"]")
	@FindBy(xpath="//*[@id=\"searchBar\"]")
    private WebElement searchhealthtopic;
	
	////input[@id='searchBar']
	///
	@FindBy(xpath ="//input[@id='searchBar']")
	private WebElement searchb5;
	
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

//    public void clickCorrectSearchResult(String specialization) {
//        By target = By.xpath("//div[contains(@class,'c-omni-suggestion-item')]//div[@data-qa-id='omni-suggestion-main' and contains(text(),'" + specialization + "')]");
//        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(target));
//        wait.until(ExpectedConditions.elementToBeClickable(el));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
//        try {
//            el.click();
//        } catch (Exception e) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
//        }
//    }
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

	// -----------------------3 Scenario Outline-------------------------------------------

//	public static String getCellData(int sheetIndex, int rowIndex, int colIndex) {
//	   
//	}

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
			//profilePage = PageFactory.initElements(driver, ProfilePage.class);
			return true;
		} catch (Exception e) {
			test.fail("Failed to click 'Consult with a doctor': " + e.getMessage());
			return false;
		}
	}

	public void searchMedicine(String medicineName) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    try {
	        WebElement bar = wait.until(ExpectedConditions.elementToBeClickable(searchOrder));
	        bar.click();
	        //bar.clear();
	        bar.sendKeys(medicineName);
	        test.pass("Entered medicine name: " + medicineName);

	       WebElement sug= wait.until(ExpectedConditions.visibilityOf(Suggestion));
//	       su.click();
	       sug.sendKeys(Keys.ARROW_DOWN);
	       sug.click(); 
//	        sug.sendKeys(Keys.ENTER);
	    } catch (Exception e) {
	        test.fail("Failed to search medicine: " + e.getMessage());
	        e.printStackTrace();
	    }

}
		//Suggestion.click();
		
		
		 // or click search button
	

	public void clickSearchButton1() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(clickEnter));
		clickEnter.click();

	}
//---------------------5th scenario-------------------------
	
	
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
			//profilePage = PageFactory.initElements(driver, ProfilePage.class);
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

public boolean entersearcharticles()
{
	try {
        
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchhealthtopic));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        searchhealthtopic.click();

        return true;
    } catch (Exception e) {

        return false;
    }

}




}
