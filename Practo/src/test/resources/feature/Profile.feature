Feature: Lab Tests Navigation
  Verify that user can navigate to Lab Tests page from homepage
 
  Scenario: Navigate to Lab Tests page
    Given user is on Practo Homepage
    When user clicks on Lab Tests link
    Then Lab Tests page should be displayed
    When user clicks on Lipid Profile link
    Then Lipid Profile page should be displayed correctly
 
Scenario: Change city to Hyderabad on Lipid Profile page
  Given user is on Lipid Profile page
  When user clicks on the city search dropdown
  And user selects Hyderabad from the list
  Then the page should update to show Hyderabad as the selected city
 