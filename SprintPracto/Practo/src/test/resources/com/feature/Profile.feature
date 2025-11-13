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
    
@SearchTests
  Scenario Outline: Search for items in Lipid Profile page
    Given user is on Practo Homepage
    When user clicks on Lab Tests link
    Then Lab Tests page should be displayed                                   
    And select Bangalore city                               
    When user clicks on Lipid Profile link
    Then verify Lipid Profile page URL            
    And click on search
    And Enter the Test from <sheet> and <row> in Lipid Profile page for search
    And click Entered Test in search
    Then verify Test results for SearchBox 

    Examples:
      | sheet  | row|
      | 0 | 1 |
      | 0 | 2 |    
      | 0 | 3 |

    @SearchTests
  Scenario Outline: Search for items in Lipid Profile page
    Given user is on Practo Homepage
    When user clicks on Lab Tests link
    Then Lab Tests page should be displayed                                   
    And select Bangalore city                               
    When user clicks on Lipid Profile link
    Then verify Lipid Profile page URL            
    And click on search City
    And Enter the City from <sheet> and <row> in Lipid Profile page for search
    And click Entered City in search
    Then verify City results for SearchBox 

    Examples:
      | sheet  | row|
      | 1 | 1 |
     # | 1 | 2 |
     # | 1 | 3 |
    
#@AddTests
#Scenario Outline: Navigate to LabTest page and add Tests to Cart

# Given user is on Practo Homepage
#  When user clicks on Lab Tests link
#  Then Lab Tests page should be displayed
#  And add first test <sheetNo> <rowNum>
#  And add second test <sheetNo> <rowNum>
#  And click Proceed to Checkout 
#  Then verify Add patient details
    
 # Examples:
 # | sheetNo | rowNum |
 # | 1 | 1 | 
 #| 0 | 2 |
 # | 0 | 3 |
     

