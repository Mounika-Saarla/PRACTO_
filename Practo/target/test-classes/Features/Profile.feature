Feature: Lab Tests Navigation

@FirstScenario
Scenario: Navigate to Labtest and book a package
Given user launch practo website
When user clicks the search for Lab Tests link
And user clicks on Know More button and Package details displayed
Then user clicks on Book Now and then booking site is displayed




 @SecondScenario
 Scenario: Navigate to Healthy Hair article and verify content
    Given user launches the Practo home
    When user clicks on See All Articles link
    And user navigates to Health Feed page
    And user clicks on Healthy Hair category
    And user navigates to Healthy Hair page
    And user selects the article "7 Health Benefits of Dates"
    And user clicks on the selected article
    Then user should be navigated to the article page
    And verify the article content is displayed
   
   

@ThirdScenario
Scenario: Validate Health Checkup Packages and booking
    Given user launches the Practo site
    And user clicks on lab tests
    When user navigates to Health Packages section   
    Then user clicks on Book Now button 
    

  

@FourthScenario
Scenario Outline: User books a lab test using Excel inputs
   Given user launches Practo application
   When user clicks on Lab Tests link on homepage
    And user selects test name from sheet <sheet> and row <row>
    Then user verifies test details page is displayed

    Examples:
      | sheet | row |
      |   0   |  0  |
      |   0   |  1  |
      |   0   |  2  |

   
   
   


@FifthScenario
  Scenario Outline: Navigate to provider pages using Excel data
    Given user launches Practo web
    When user clicks on Lab Tests link on Web
    And user handles city overlay
    And user clicks on For Providers
    And user selects Software for Providers from dropdown
    And user navigates to provider link from Excel sheet <sheet> and row <row>
    Then verify that the provider page is displayed

    Examples:
      | sheet | row |
      |   0   |  1  |
      |   0   |  2  |
      |   0   |  3  |
     
     
     

@NegativeScenario
  Scenario: Search for an invalid doctor and validate No results found message
    Given when the user launches Practo home page
    When user clicks on the search bar
    And user enters an invalid doctor name
 And user selects a suggestion from dropdown
    Then user should see a message No results found on the page
 