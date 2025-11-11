package com.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

import com.parameters.PropertyReader;
import org.testng.Assert;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

//        List<WebElement> hospitalSuggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(hospitalSuggestionsXpath)));
//        for (WebElement suggestion : hospitalSuggestions) {
//            if (suggestion.getText().equalsIgnoreCase(hospital)) {
//                suggestion.click();
//                break;
//            }
//        }

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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*

    public void enterCityAndHospital(String city, String hospital) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // --- Enter City ---
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.elementToBeClickable(cityLocator));
        WebElement cityField = driver.findElement(cityLocator);
        cityField.clear();
        cityField.sendKeys(city);

        // Wait for city suggestions
        By citySuggestionsLocator = By.xpath(PropertyReader.getProperty("search.properties", "citySuggestionList"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(citySuggestionsLocator));
        List<WebElement> citySuggestions = driver.findElements(citySuggestionsLocator);

        boolean cityFound = false;
        for (WebElement suggestion : citySuggestions) {
            if (suggestion.getText().equalsIgnoreCase(city)) {
                suggestion.click();
                cityFound = true;
                break;
            }
        }
        if (!cityFound) {
            throw new Exception("City suggestion '" + city + "' not found");
        }

        // Validate city
        String actualCity = cityField.getAttribute("value");
        Assert.assertEquals(actualCity, city, "City not entered correctly");

        // --- Enter Hospital ---
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalLocator));
        WebElement hospitalField = driver.findElement(hospitalLocator);
        hospitalField.clear();
        hospitalField.sendKeys(hospital);

        // Wait for hospital suggestions
        By hospitalSuggestionsLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalSuggestionList"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(hospitalSuggestionsLocator));
        List<WebElement> hospitalSuggestions = driver.findElements(hospitalSuggestionsLocator);

        boolean hospitalFound = false;
        for (WebElement suggestion : hospitalSuggestions) {
            if (suggestion.getText().equalsIgnoreCase(hospital)) {
                suggestion.click();
                hospitalFound = true;
                break;
            }
        }
        if (!hospitalFound) {
            throw new Exception("Hospital suggestion '" + hospital + "' not found");
        }

        // Validate hospital
        String actualHospital = hospitalField.getAttribute("value");
        Assert.assertEquals(actualHospital, hospital, "Hospital not entered correctly");
    }*/
   /*
    public void enterCity(String city) throws Exception {
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.elementToBeClickable(cityLocator));
        WebElement cityField = driver.findElement(cityLocator);
        cityField.clear();
        cityField.sendKeys(city);

        // Wait for suggestions list
        By suggestionsLocator = By.xpath(PropertyReader.getProperty("search.properties", "citySuggestionList"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsLocator));

        // Find all suggestions
        List<WebElement> suggestions = driver.findElements(suggestionsLocator);
        boolean cityFound = false;
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equalsIgnoreCase(city)) {
                suggestion.click();
                cityFound = true;
                break;
            }
        }

        if (!cityFound) {
            throw new Exception("City suggestion '" + city + "' not found in the list");
        }

        // Validate final value
        String actualCity = cityField.getAttribute("value");
        Assert.assertEquals(actualCity, city, "City not entered correctly");
    }*/
    /*
    public void enterHospital(String hospital) throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalLocator));
        WebElement hospitalField = driver.findElement(hospitalLocator);
        hospitalField.clear();
        hospitalField.sendKeys(hospital);

        // Wait for suggestions list
        By suggestionsLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalSuggestionList"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionsLocator));

        // Find all suggestions
        List<WebElement> suggestions = driver.findElements(suggestionsLocator);
        boolean hospitalFound = false;
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equalsIgnoreCase(hospital)) {
                suggestion.click();
                hospitalFound = true;
                break;
            }
        }

        if (!hospitalFound) {
            throw new Exception("Hospital suggestion '" + hospital + "' not found in the list");
        }

        // Validate final value
        String actualHospital = hospitalField.getAttribute("value");
        Assert.assertEquals(actualHospital, hospital, "Hospital not entered correctly");
    }*/
    
   /* public void enterHospital(String hospital) throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for hospital input field
        WebElement hospitalField = wait.until(ExpectedConditions.elementToBeClickable(hospitalLocator));
        hospitalField.clear();
        hospitalField.sendKeys(hospital);

        // Wait for hospital suggestions
        By hospitalSuggestionsLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalSuggestionList"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(hospitalSuggestionsLocator));

        // Select exact match from suggestions
        List<WebElement> suggestions = driver.findElements(hospitalSuggestionsLocator);
        boolean hospitalFound = false;
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().equalsIgnoreCase(hospital)) {
                suggestion.click();
                hospitalFound = true;
                break;
            }
        }

        if (!hospitalFound) {
            throw new Exception("Hospital suggestion '" + hospital + "' not found");
        }

        // Validate
        Assert.assertEquals(hospitalField.getAttribute("value"), hospital, "Hospital not entered correctly");
    }
*/
   /* public void enterCity(String city) throws Exception {
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.elementToBeClickable(cityLocator));
        WebElement cityField = driver.findElement(cityLocator);
        cityField.clear();
        cityField.sendKeys(city);
        By citySuggestion = By.xpath(PropertyReader.getProperty("search.properties", "citySuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(citySuggestion));
        driver.findElement(citySuggestion).click();
        Assert.assertEquals(cityField.getAttribute("value"), city, "City not entered correctly");
    }*/

   /* public void enterHospital(String hospital) throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalLocator));
        WebElement hospitalField = driver.findElement(hospitalLocator);
        hospitalField.clear();
        hospitalField.sendKeys(hospital);
        By hospitalSuggestion = By.xpath(PropertyReader.getProperty("search.properties", "hospitalSuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalSuggestion));
        driver.findElement(hospitalSuggestion).click();
        Assert.assertEquals(hospitalField.getAttribute("value"), hospital, "Hospital not entered correctly");
    }*/
}


/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.parameters.PropertyReader;

public class SearchPage {
    WebDriver driver;

    @FindBy(xpath = "")
    WebElement cityField;

    @FindBy(xpath = "")
    WebElement hospitalField;

    @FindBy(xpath = "")
    WebElement searchButton;

    public SearchPage(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        cityField = driver.findElement(org.openqa.selenium.By.xpath(PropertyReader.getProperty("search.properties", "cityField")));
        hospitalField = driver.findElement(org.openqa.selenium.By.xpath(PropertyReader.getProperty("search.properties", "hospitalField")));
        searchButton = driver.findElement(org.openqa.selenium.By.xpath(PropertyReader.getProperty("search.properties", "searchButton")));
    }

    public void enterCity(String city) { cityField.sendKeys(city); }
    public void enterHospital(String hospital) { hospitalField.sendKeys(hospital); }
    public void clickSearch() { searchButton.click(); }
}*/

/*
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.parameters.PropertyReader;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }*/

    /*public void enterCity(String city) throws Exception {
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityLocator));
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void enterHospital(String hospital) throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(hospitalLocator));
        driver.findElement(hospitalLocator).sendKeys(hospital);
    }*/
    /*
    public void enterCity(String city) throws Exception {
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityLocator));
        driver.findElement(cityLocator).clear();  // Clear existing value
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void enterHospital(String hospital) throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(hospitalLocator));
        driver.findElement(hospitalLocator).clear();  // Clear existing value
        driver.findElement(hospitalLocator).sendKeys(hospital);
    }*/
    
    /*public void enterCity(String city) throws Exception {
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityLocator));
        driver.findElement(cityLocator).clear();
        driver.findElement(cityLocator).sendKeys(city);

        // Select suggestion
        By citySuggestion = By.xpath(PropertyReader.getProperty("search.properties", "citySuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(citySuggestion));
        driver.findElement(citySuggestion).click();
    }

    public void enterHospital(String hospital) throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(hospitalLocator));
        driver.findElement(hospitalLocator).clear();
        driver.findElement(hospitalLocator).sendKeys(hospital);

        // Select suggestion
        By hospitalSuggestion = By.xpath(PropertyReader.getProperty("search.properties", "hospitalSuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalSuggestion));
        driver.findElement(hospitalSuggestion).click();
    }*/
    /*
    public void enterCity(String city) throws Exception {
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityLocator));
        WebElement cityField = driver.findElement(cityLocator);
        cityField.clear();
        cityField.sendKeys(city);

        // Wait and click suggestion
        By citySuggestion = By.xpath(PropertyReader.getProperty("search.properties", "citySuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(citySuggestion));
        driver.findElement(citySuggestion).click();
    }

    public void enterHospital(String hospital) throws Exception {
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(hospitalLocator));
        WebElement hospitalField = driver.findElement(hospitalLocator);
        hospitalField.clear();
        hospitalField.sendKeys(hospital);

        // Wait and click suggestion
        By hospitalSuggestion = By.xpath(PropertyReader.getProperty("search.properties", "hospitalSuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalSuggestion));
        driver.findElement(hospitalSuggestion).click();
    }*/
    /*
    public void enterCity(String city) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for city field to appear
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.presenceOfElementLocated(cityLocator));

        WebElement cityField = driver.findElement(cityLocator);
        cityField.clear();
        cityField.sendKeys(city);

        // Wait and click suggestion
        By citySuggestion = By.xpath(PropertyReader.getProperty("search.properties", "citySuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(citySuggestion));
        driver.findElement(citySuggestion).click();
    }

    public void enterHospital(String hospital) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for hospital field
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.presenceOfElementLocated(hospitalLocator));

        WebElement hospitalField = driver.findElement(hospitalLocator);
        hospitalField.clear();
        hospitalField.sendKeys(hospital);

        // Wait and click suggestion
        By hospitalSuggestion = By.xpath(PropertyReader.getProperty("search.properties", "hospitalSuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalSuggestion));
        driver.findElement(hospitalSuggestion).click();
    }*/
    /*
    public void enterCity(String city) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.elementToBeClickable(cityLocator));

        WebElement cityField = driver.findElement(cityLocator);
        cityField.clear();
        cityField.sendKeys(city);

        // Select suggestion
        By citySuggestion = By.xpath(PropertyReader.getProperty("search.properties", "citySuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(citySuggestion));
        driver.findElement(citySuggestion).click();
    }

    public void enterHospital(String hospital) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalLocator));

        WebElement hospitalField = driver.findElement(hospitalLocator);
        hospitalField.clear();
        hospitalField.sendKeys(hospital);

        // Select suggestion
        By hospitalSuggestion = By.xpath(PropertyReader.getProperty("search.properties", "hospitalSuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalSuggestion));
        driver.findElement(hospitalSuggestion).click();
    }*/
    /*
    public void enterCity(String city) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // Wait for page URL to confirm navigation
        wait.until(ExpectedConditions.urlContains("/hospitals"));

        // Wait for city input field
        By cityLocator = By.xpath(PropertyReader.getProperty("search.properties", "cityField"));
        wait.until(ExpectedConditions.presenceOfElementLocated(cityLocator));

        WebElement cityField = driver.findElement(cityLocator);
        cityField.clear();
        cityField.sendKeys(city);

        // Wait and click suggestion
        By citySuggestion = By.xpath(PropertyReader.getProperty("search.properties", "citySuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(citySuggestion));
        driver.findElement(citySuggestion).click();
    }
    public void enterHospital(String hospital) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By hospitalLocator = By.xpath(PropertyReader.getProperty("search.properties", "hospitalField"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalLocator));

        WebElement hospitalField = driver.findElement(hospitalLocator);
        hospitalField.clear();
        hospitalField.sendKeys(hospital);

        // Select suggestion
        By hospitalSuggestion = By.xpath(PropertyReader.getProperty("search.properties", "hospitalSuggestion"));
        wait.until(ExpectedConditions.elementToBeClickable(hospitalSuggestion));
        driver.findElement(hospitalSuggestion).click();
    }

}*/

