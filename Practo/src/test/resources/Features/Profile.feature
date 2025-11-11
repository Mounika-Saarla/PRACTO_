Feature: Lab Tests Navigation
  Verify that user can book a diagnostic test from Top Booked Diagnostic Tests section
  Scenario: Navigate and book a Top Booked Diagnostic Test   
    Given user is on Practo Homepage
    When user clicks on Lab Tests link
    And Lab Tests page should be displayed
    Then user clicks on TopBooked Diagnosttic Tests  link
    And TopBooked Diagnosttic Tests page should be displayed correctly
    
    
    
