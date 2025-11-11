
Feature: Practo Doctor Search
 
Scenario: Validate that searching for dentist shows matching doctors
    Given the user navigates to the Practo website
    When the user opens the Find Doctors page
    And the user searches for the Dentists
    Then matching doctors should be visible