
Feature: Practo Doctor Search
 #@Search
#Scenario: Validate that searching for dentist shows matching doctors
   #Given the user navigates to the Practo website
    #When the user opens the Find Doctors page
   #And the user searches for the Dentists
    #Then matching doctors should be visible
    
    @Module
    Scenario: Navigate from Practo home to Find Doctors and then to Consult with a doctor
  Given User launches the Practo website 
  When User clicks on Find Doctors option
  #And User should be on the Find Doctors page
  And User clicks on Consult with a doctor option
  Then User should be on the Consult with a doctor page
  
 @Module2
 Scenario: Validate that selecting Dermatologist from popular searches navigates through three pages
    Given the user navigates to the Practo website
    When the user opens the Find Doctors page
    And the user selects Dermatologist from the popular searches section
    Then the user should be navigated to the Dermatologist listing page

    @Spz
    Scenario Outline: Search for a doctor by specialization
  Given the user is on the Practo homepage
  When the user enters "<specialization>" in the search bar
  And selects the location as "<location>"
  And clicks the search button
  Then the results page should display doctors specialized in "<specialization>"
  And the page should show filters and sorting options relevant to "<specialization>"

Examples:
  | specialization         | location   |
  | Dermatologist          | Bangalore  |
  | Pediatrician           | Mumbai     |
  | Gynecologist           | Delhi      |
  | Cardiologist           | Hyderabad  |
  | Orthopedic Surgeon     | Chennai    |