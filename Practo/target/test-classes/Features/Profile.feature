#Feature: Lab Tests Navigation

#Scenario: Navigate to Labtest and book a package
#Given user launch practo website
#When user clicks the search for Lab Tests link
#And user clicks on Know More button and Package details displayed
#Then user clicks on Book Now and then booking site is displayed





 #Scenario: Navigate to Healthy Hair article and verify content
    #Given user launches the Practo website
    #When user clicks on See All Articles link
   #And user navigates to Health Feed page
    #And user clicks on Healthy Hair category
    #And user navigates to Healthy Hair page
    #And user selects the article "7 Health Benefits of Dates"
    #And user clicks on the selected article
    #Then user should be navigated to the article page
   #And verify the article content is displayed
   
   
Feature: Validate Health Checkup Packages and booking


Scenario Outline: Validate Health Checkup Packages and booking
    Given user launches the Practo website
    When user navigates to Health Packages section
    And user clicks on a package to view details
    Then verify package details page displays correct info
    And user clicks on Book Now button
    And user enters details from row <RowIndex>
    And user submits booking details
    Then validate expected result from row <RowIndex>

Examples:
    | RowIndex |
    | 1        |
    | 2        |


    
   
Examples:
    |RowIndex|
    |1       |
    |2       |
