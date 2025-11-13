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
   
   
#Feature: Validate Health Checkup Packages and booking

#Scenario: Validate Health Checkup Packages and booking
 #   Given user launches the Practo website
  #  And user clicks on lab tests
   # When user navigates to Health Packages section   
   # Then user clicks on Book Now button 
    

  
    
  Feature: Book Health Checkup Package on Practo
  Scenario Outline: Navigate from homepage and book health checkup with valid details
    Given user launches Practo application
    When user clicks on Lab Tests link on homepage
    And user scrolls to "Popular Health Checkup Package" section
    And user selects package name from sheet <sheet> and row <row>
    And user clicks on Book Now button
    Then user verifies booking section page is displayed
    And user enters patient details from sheet <sheet> and row <row>
    And user clicks on Continue button
    

    Examples:
      | sheet | row |
      | 0     | 1   |
     
  

    
 