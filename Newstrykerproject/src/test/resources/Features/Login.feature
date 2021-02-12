Feature: login

  Background: Login page
    Given user on browser
    When user opens URL "https://nurse-app.azurewebsites.net/"

  Scenario Outline: Successful login with valid credentails
    And user enters <hospitalcode>
    And clicks on login button
    Then user is navigate to stryker home page

    Examples: 
      | hospitalcode |
      |       123451 |
      |       123459 |

  Scenario: Verify the error message while login
    When clicks on proceed button
    Then user view error message "Please enter hospital code"
