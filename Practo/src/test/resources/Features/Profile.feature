Feature: Home Page Footer Navigation
This feature deals with the Search for clinics
#passed
@outline1
Scenario Outline: Validate Footer Contains Search for clinics click
    Given User is on the Home page
    And User scrolls to the footer section
    When The footer should contain a visible link labeled Search for clinics
    And User clicks on the Search for clinics link
    And User applies a location filter from sheet <sheet> at RowIndex <RowIndex>
    Then Filtered clinic results should be displayed

    Examples:
      | sheet | RowIndex |
      | 0     | 1        |
      | 0     | 2        |
     
     
 #passed 
@firstclinic
Scenario:navigate to required clinic details
Given  user launch practo website
When user clicks the search for clinics link
And user clicks on view profile of first clinic
And clinic details shouls be displayed
Then user select the doctor in that clinic


#passed
@clinicinGopalapuram
  Scenario: Navigate to doctor details in Gopalapuram
   Given User is on the Home page
    And User scrolls to the footer section
    When The footer should contain a visible link labeled Search for clinics
    And User clicks on the Search for clinics link
    And User clicks on Clinics in Gopalapuram link
    Then User click on Call Clinic
    
    
@Anesthesiologists
Scenario:Navigate to Anesthesiologists available in chennai
Given  user launch practo website
When user clicks the search for clinics link
And user clicks on Qure Ortho Clinic link
Then user clicks on Anesthesiologist in Chennai link in footer


@outline2
Scenario Outline: Validate Footer Contains Search for clinics click
    Given User is on the Home page
    And User scrolls to the footer section
    When The footer should contain a visible link labeled Search for clinics
    And User clicks on the Search for clinics link
    And User applies a speciality filter from sheet <sheet> at RowIndex <RowIndex>
    Then Filtered clinic results should be displayed

    Examples:
      | sheet | RowIndex |
      | 0     | 1        |
      | 0     | 2        |


