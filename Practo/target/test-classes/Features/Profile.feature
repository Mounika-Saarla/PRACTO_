Feature: Home Page Footer Navigation
This feature deals with the Search for clinics
@outline1
Scenario Outline: Validate Footer Contains Search for clinics click
    Given User is on the Home page
    And User scrolls to the footer section
    When The footer should contain a visible link labeled Search for clinics
    And User clicks on the "Search for clinics" link
    And User applies a location filter from sheet <sheet> at RowIndex <RowIndex>
    Then Filtered clinic results should be displayed

    Examples:
      | sheet | RowIndex |
      | 0     | 1        |
      | 0     | 2        |
      
      
@firstclinic
Scenario:navigate to required clinic details
Given  user launch practo website
When user clicks the search for clinics link
And user clicks on view profile of first clinic
And clinic details shouls be displayed
Then user select the doctor in that clinic



@invalidmobile
Scenario: Invalid mobile number shows error but OTP field appears
Given user on the homepage
When user click on the "Search for Clinics" footer link
And user enter a valid location and speciality from test data
And user applies a City filter from test data
And user applies a Role filter from test data
And user select a doctor from the search results
And user click on the "Book clinic visit" button
And user select a time slot from test data
And user enter an invalid mobile number from test data
And user click on the "Continue" button
Then user should see an error message in next page from test data


@GenderFilter
  Scenario: Navigate through pages and apply Gender Filter
    Given User is on the Practo homepage
    And User navigates to the Search for Clinics page
    And User enters a valid role and clicks search
    And Clinic results are displayed
    When User selects a gender in the Gender filter
    And User applies the filter
    Then All displayed doctors should match the selected gender
    And Gender filter should remain applied after page refresh






