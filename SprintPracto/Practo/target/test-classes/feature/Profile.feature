
Feature: Lab Tests Navigation
  Verify that user can navigate to Lab Tests page from homepage

  @lipidProfilePage
  Scenario: Navigate to Lab Tests page
    Given user is on Practo Homepage
    When user clicks on Lab Tests link
    Then Lab Tests page should be displayed
    And select Bangalore city
    When user clicks on Lipid Profile link
    Then verify Lipid Profile page URL

@AddToCart
  Scenario: Navigate to Lab Tests page and add Lipid Profile to cart
    Given user is on Practo Homepage
    When user clicks on Lab Tests link
    Then Lab Tests page should be displayed
    And select Bangalore city
    When user clicks on Lipid Profile link
    Then verify Lipid Profile page URL
    And click on Add to Cart button
    Then verify item is added to cart
    
