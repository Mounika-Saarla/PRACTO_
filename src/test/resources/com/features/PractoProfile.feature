#Feature: Practo Home Page

 #Scenario: Navigate to Home page
  #  Given User is on the Chrome
   # When User clicks on the Practo url
   # Then User should in Practo page

#@check
#Scenario: Validate Footer Contains "Search for hospitals" click
#    Given User is on the Home page
#    And User scrolls to the footer section
#    When The footer should contain a visible link labeled "Search for hospitals"
#    Then User clicks the "Search for hospitals" link
    
#Feature: Practo Hospital Search and Booking

#Scenario: Search and book hospital with valid details
 #   Given user launches Practo application
 #   When user enters city and hospital name from Excel
 #   And user clicks on Search button
 #   Then user verifies hospital list page is displayed
 #   When user selects a hospital from the list
 #   And user clicks on Book Hospital Visit
#    Then user enters booking details from Excel and confirms booking

#Scenario: Search and book hospital with invalid phone number
 #   Given user launches Practo application
 #   When user enters city and hospital name from Excel
 #   And user clicks on Search button
 #   Then user verifies hospital list page is displayed
 #   When user selects a hospital from the list
 #   And user clicks on Book Hospital Visit
 #   Then user enters invalid booking details from Excel and verifies error message
    
    

Feature: Practo Hospital Search and Booking

@valid
Scenario: Navigate from homepage and book hospital with valid details
   Given user launches Practo application
   When user clicks on Search for hospitals link on homepage
    And user enters city name from Excel and selects suggestions 
   Then user verifies hospital list page is displayed
    When user selects a hospital from the list
    And user clicks on Book Hospital Visit
    And user click on clinic button
   Then user looks contact details
   
@overview
Scenario: Navigate from homepage to hospital overview page
   Given user launches Practo application
    When user clicks on Search for hospitals link on homepage
    And user enters city name from Excel and selects suggestions 
    And user verifies hospital list page is displayed 
    Then user clicks hospital card so user see details

    

#@ExcelData
#Scenario Outline: Navigate from homepage and book hospital with valid to details
#   Given user launches Practo application
#    When user clicks on Search for hospitals link on homepage
#    And user enters city name "<City>" and selects suggestions
#    Then user verifies hospital list page is displayed
#    When user selects a hospital from the list
#    And user clicks on Book Hospital Visit


#Examples:
#   | City      |
#   | Bangalore |
#   | Mumbai    |



@city
Scenario Outline: Navigate from homepage and search City from name 
   Given user launches Practo application
   When user clicks on Search for hospitals link on homepage
   And user enters city name from sheet <sheet> and row <row> and selects suggestions
   Then user verifies hospital list page is displayed
   When user selects a hospital from the list
  Then  user clicks on Book Hospital Visit
   
Examples:
    | sheet | row |
	| 	0	|	1  |
	|	0	|	2	|


@hospital
Scenario Outline: Navigate from homepage and search hospital by name
  Given user launches Practo application
  When user clicks on Search for hospitals link on homepage
  And user enters hospital name from sheet <sheet> and row <row> and selects suggestions
  Then user verifies hospital list page is displayed
  When user selects a hospital from the list
  Then user see suggestion Visit

Examples:
    | sheet | row |
    |   0  |  1  |
    |   0  |  2  |
    
#Scenario Outline: Navigate from homepage and book hospital with valid details
#   Given user launches Practo application
#   When user clicks on Search for hospitals link on homepage
#   And user enters city name from sheet Sheet3 and row <row> and selects suggestions
#   Then user verifies hospital list page is displayed
#   When user selects hospital from sheet Sheet3 and row <row>
#   Then user clicks on Book Hospital Visit

#Examples:
 #   | sheet  | row |
 #   | Sheet3 | 1   |
 #   | Sheet3 | 2   |
    

@service
 Scenario: Search for hospital and select service
    Given user launches Practo application
   When user clicks on Search for hospitals link on homepage
    And user enters city name from Excel and selects suggestions 
   Then user verifies hospital list page is displayed
   And user clicks on Doctor for Skin Whitening in Bangalore
    Then user should see the list of doctors for skin whitening in Bangalore

@negative
Scenario Outline: Navigate from homepage and search hospital by name
  Given user launches Practo application
  When user clicks on Search for hospitals link on homepage
  And user enters hospital name from sheet <sheet> and row <row> and selects suggestions
  Then user verifies hospital list page is displayed
  When user selects a hospital from the list
  Then user enter value and see error
  #Then user see suggestion Visit

Examples:
    | sheet | row |
    |   1  |  0  |


  




    