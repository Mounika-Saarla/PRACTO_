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

Scenario: Navigate from homepage and book hospital with valid details
    Given user launches Practo application
    When user clicks on Search for hospitals link on homepage
    And user enters city name from Excel and selects suggestions 
    Then user verifies hospital list page is displayed
    When user selects a hospital from the list
    And user clicks on Book Hospital Visit
    And user click on clinic button
   Then user looks contact details

Scenario: Navigate from homepage and book hospital with invalid phone number
    Given user launches Practo application
    When user clicks on Search for hospitals link on homepage
    And user enters city name from Excel and selects suggestions 
   # And user clicks on Search button
    Then user verifies hospital list page is displayed
    When user selects a hospital from the list
    And user clicks on Book Hospital Visit
     And user click on clinic button
    #Then user enters invalid booking details from Excel and verifies error message  

    