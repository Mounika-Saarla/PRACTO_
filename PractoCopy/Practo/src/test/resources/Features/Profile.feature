
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
  Given User launches the Practo website 
  And User clicks on Find Doctors option
  When the user enters specialization from sheet <sheet> and row <row> in the search bar
  And clicks the search button
  Then the results page should display doctors specialized in specialization


Examples:
| sheet |row|
| 0     | 0 |
| 0     | 1 |
| 0     | 2 |


@Order
Scenario: User searches for a medicine after navigating through Find Doctors
  Given User launches the Practo website
  And User clicks on Find Doctors option
  When User clicks on Order Medicines
  And User enters Medicine Name from <sheet> and row <row> in the search bar
  And clicks the search button
  Then the results page should display relevant products for Medicine Name
  
  Examples:
| sheet |row|
| 0     | 0 |
| 0     | 1 |