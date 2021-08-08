@login
Feature: Logging in to the system

  Background:
    Given user is on Login page

  Scenario: User logs in with valid credentials
    When user enters credentials and clicks on Sign In button
    Then the system should navigate to Subscription page

  Scenario: User enters invalid username on login page
    When user enters invalid username
    Then the system should display the invalid email error message

  Scenario Outline: User enters invalid password
    When user enters "<username>" and "<password>"
    And clicks on Sign In button
    Then the system should display the error message for entered "<password>"
    Examples:
      | username             | password  |
      | test.qa.3@esprow.com | abcdefg   |
      | test.qa.3@esprow.com | abcdefgh  |
      | test.qa.3@esprow.com | abcdefghi |

