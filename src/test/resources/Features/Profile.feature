
Feature: Practo Doctor Search

    
    @Module
    Scenario: Navigate from Practo home to Find Doctors and then to Consult with a doctor
 Given User launches the Practo website 
 When the user opens the Find Doctors page
  And User clicks on Consult with a doctor option
  Then User should be on the Consult with a doctor page
  
@Module2
 Scenario: Validate that selecting Dermatologist from popular searches navigates through three pages
    Given the user navigates to the Practo website
   When the user opens the Find Doctors page
   And the user selects Dermatologist from the popular searches section
    Then the user should be navigated to the Dermatologist listing page

 
    
     @Spz
  Scenario Outline: Search for a doctor by specialization
  Given User launches the Practo website 
   When the user opens the Find Doctors page
  When the user enters specialization from sheet <sheet> and row <row> in the search bar
  And clicks the search button
  Then the results page should display doctors specialized in specialization


Examples:
| sheet |row|
| 0     | 0 |
| 0     | 1 |
| 0     | 2 |
|0      | 3 |

@Order
Scenario: User searches for a medicine after navigating through Find Doctors
  Given User launches the Practo website
 When the user opens the Find Doctors page
  When User clicks on Order Medicines
  #And User enters Medicine Name from <sheet> and row <row> in the search bar
  #And clicks the search button
  Then the results page should display relevant products 

  
 #Examples:
#| sheet |row|
#| 0     | 1 |
#| 0     | 2 |



#@Meds
 # Scenario: User navigates to Order Medicines after launching Practo
  #  Given User launches the Practo website
   # When User clicks on the Find Doctors option
    #And User clicks on the Order Medicines option
    #Then User should be redirected to the Order Medicines page
    
    #------------------------------------5th scenario------------------------
    
  


@form
Scenario Outline: User requests a free demo via Insta By Practo
  Given User launches the Practo website
  When User clicks on the Find Doctors option
  And User scrolls to the Insta By Practo section
# And User clicks on the I would like a free demo button
  And User fills the demo request form using data from sheet <sheet> and row <row>
  And User submits the demo request form
  Then User should see the Thank You popup and close it

Examples:
  | sheet | row |
  | 1     |  1  |
  | 1     |  2  |
  
  
