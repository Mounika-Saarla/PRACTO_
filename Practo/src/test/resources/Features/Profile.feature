Feature: Home Page Footer Navigation
#This feature deals with the Search for clinics
#@search
#Scenario Outline: Validate Footer Contains "Search for clinics" click
 #   Given User is on the Home page
  #  And  User scrolls to the footer section
   # When The footer should contain a visible link labeled "Search for clinics"
    #And User clicks the "Search for clinics" link
    #And User applies a location filter <RowIndex>
    #And User applies a speciality filter <RowIndex>
    #Then Filtered clinic results should be displayed
    
   # Examples:
    #| RowIndex   | 
    #| 1		| 

#Scenario:navigate to required clinic details
#Given  user launch practo website
#When user clicks the search for clinics link
#And user clicks on view profile of first clinic
#Then clinic details shouls be displayed


@excel
Scenario: Invalid mobile number shows error but OTP field appears
Given user on the homepage
When user click on the "Search for Clinics" footer link
#And user enter a valid location and speciality from test data
When  User applies a City filter from test data
When  User applies a Role filter from test data
And user select a doctor from the search results
And user click on the "Book clinic visit" button
And user select a time slot from test data
And user enter an invalid mobile number from test data
And user click on the "Continue" button
Then user should see an error message in next page from test data




