Feature: Pediatric

  Background: Steps for login
    Given user is on the browser page screen
    And user on the URL "https://nurse-app.azurewebsites.net/"
    When user enter hospital code
    And user press proceed button
    Then page navigate to stryker home page

  Scenario Outline: Verify the pediatrtic page
    And user verify the strykerlogo
    And user verify the Smartmediclogo
    And user verify the Smartmedicdemo
    And user clicks on the ICU button <ICUname>
    Then user navigate to pediatric page

    Examples: 
      | ICUname       |
      | Pediatric ICU |

  Scenario Outline: selecting the bed from the Pediatric ICU list
    #And user clicks on the ICU button <ICUname>
    And user click on the ICU button from the home screen <ICUname>
    And click on the bedno <bednumb>
    #Then verify the selected bed screen

    Examples: 
      | ICUname       | bednumb   |
      | Pediatric ICU | Bed No. 002 |
