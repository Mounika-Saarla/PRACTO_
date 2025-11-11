Feature: Home Page Footer Navigation
This feature deals with the Search for clinics

Scenario: Validate Footer Contains "Search for clinics" click
    Given User is on the Home page
    And  User scrolls to the footer section
    When The footer should contain a visible link labeled "Search for clinics"
    And User clicks the "Search for clinics" link
    And User applies a location filter <RowIndex>
    And User applies a speciality filter <RowIndex>
    Then Filtered clinic results should be displayed
    
    Examples:
    | RowIndex   | 
    | 1			 | 


@booking
  Scenario: Navigate to Doctor Details and Appointment Booking
    Given user is on Clinic Details page
    When user selects a doctor and navigates to Doctor Details page
    And user chooses a time slot and proceeds to Appointment Booking page
    Then booking page should display selected doctor and time slot


