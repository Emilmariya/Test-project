Feature: PediatricICU

  Background: Login steps
    Given user in on browser page
    When user open the URL "https://nurse-app.azurewebsites.net/"
    And user type hospitalcode
    And user click on the login button
    Then user navigate to home page

  Scenario Outline: Verify the pediatricICU page
    And user verify logo
    And user verify smartmediclogo
    And user verify smartmedic demo
    And clicks on the ICU button <ICUname>
    Then user navigate to pediatricICU page

    Examples: 
      | ICUname       |
      | Pediatric ICU |

  Scenario Outline: Selecting Bed from the pediatric ICU list
    And user click on the button <ICUname>
    And user click on the Bed No.<bed>
    Then two section is visible if there is weight

    Examples: 
      | ICUname       | bed         |
      | Pediatric ICU | Bed No. 002 |

  Scenario Outline: Selecting cardiac ICU from the drop down list
    And click the ICU button <ICUname>
    And user click on the cardiacICU from the dropdown list
    Then user naviagtes to the cardiacICU screen

    Examples: 
      | ICUname       |
      | Pediatric ICU |

  Scenario Outline: Selecting the signout from the dropdown list
    And press on the ICU button <ICUname>
    And click on the signout button from the drop down list
    Then navigate to login screen

    Examples: 
      | ICUname       |
      | Pediatric ICU |
