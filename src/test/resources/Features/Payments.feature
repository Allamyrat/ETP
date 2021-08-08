
Feature: User is able to make payment with a valid credit card

  Background:
    Given user logs into the system

  Scenario Outline: User is able to proceed to Complete Order window
    When user adds exchange with "<ProtocolType>" and <amount> of sessions
    And user selects exchange subscription
    Then user clicks on ConfirmPay button
    And System should display Order window
    When user clicks on Proceed to Checkout on the Order window
    Then System should display Complete order window
    Examples:
      | ProtocolType | amount |
      | FIX 4.2      | 1      |
      | FIX 4.3      | 2      |
      | FIX 4.4      | 3      |
      | FIX 5.0      | 14     |
      | FIX 5.0 SP1  | 7      |
      | FIX 5.0 SP2  | 100    |
    # I couldn't write a scenario for happy path for payment. Because once I entered account info there is always
  # edit option. I deleted caches and cookies but account name and lastname stays there

  Scenario: user is able to make payment for subscription with predifined account and credit card
    When user confirms an exchange subscription for payment with following options
    |ProtocolType|FIX 4.3 |
    |SessionAmount|3      |
    Then user clicks on Proceed to Checkout on the Order window
    When user checks the Agreement checkbox
    And clicks on Pay button
    Then System should successfully open Subscription

  Scenario: user is able to update the account information
    When user is on Complete Order window
    Then user clicks on edit Account
    And user enters account informaton
    When clicks on Update button
    Then entered account info should be displayed on Order window

  Scenario: user is able to update the payment information
    When user is on Complete Order window
    Then user clicks on edit Payment
    And user enters credit card information
    When clicks on Update button
    Then entered credit card info should be displayed on Order window
  @payment
  Scenario Outline: User is able to make payment for multiple Exchange Subscriptions
    When user adds exchange with "<ProtocolType>" and <amount> of sessions
    Then user adds another Exchange with followings
      |ProtocolType|FIX 4.3 |
      |SessionAmount|3      |
    And user clicks on ConfirmPay button
    Examples:
      | ProtocolType | amount |
      | FIX 4.2      | 1      |

