package com.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class SearchPage  extends BaseSteps{
    
    public SearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void enterCityAndHospital(String city, String hospital) throws Exception {
        // Get locators from properties
        String cityFieldXpath = PropertyReader.getProperty("search.properties", "cityField");
        String citySuggestionsXpath = PropertyReader.getProperty("search.properties", "citySuggestionList");
        String hospitalFieldXpath = PropertyReader.getProperty("search.properties", "hospitalField");
        String hospitalSuggestionsXpath = PropertyReader.getProperty("search.properties", "hospitalSuggestionList");

        if (cityFieldXpath == null || citySuggestionsXpath == null || hospitalFieldXpath == null || hospitalSuggestionsXpath == null) {
            throw new IllegalArgumentException("One or more XPath values are null. Check search.properties file.");
        }

        // Enter City
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cityFieldXpath)));
        cityField.clear();
        cityField.sendKeys(city);
//        cityField.click();
        WebElement citySuggestions = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'" + city + "')]")
            ));
            citySuggestions.click();

//        List<WebElement> citySuggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(citySuggestionsXpath)));
//        for (WebElement suggestion : citySuggestions) {
//            if (suggestion.getText().equalsIgnoreCase(city)) {
//                suggestion.click();
//                break;
//            }
//        }

        // Enter Hospital
        WebElement hospitalField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(hospitalFieldXpath)));
        hospitalField.clear();
        hospitalField.sendKeys(hospital);
        WebElement hospitalSuggestions = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'" + hospital + "')]")
            ));
        hospitalSuggestions.click();

        // Validate
        Assert.assertEquals(cityField.getAttribute("value"), city, "City not entered correctly");
        Assert.assertEquals(hospitalField.getAttribute("value"), hospital, "Hospital not entered correctly");
    }
    

   
    public void enterCity(String city) throws Exception {
        String cityFieldXpath = PropertyReader.getProperty("search.properties", "cityField");
        String citySuggestionsXpath = PropertyReader.getProperty("search.properties", "citySuggestionList");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement cityField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cityFieldXpath)));
        cityField.clear();
        cityField.sendKeys(city);
//        cityField.click();
        WebElement citySuggestions = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'" + city + "')]")
            ));
            citySuggestions.click();
        String actualCity = cityField.getAttribute("value");
        Assert.assertEquals(actualCity, city, "City not entered correctly");
    }
    
    
}