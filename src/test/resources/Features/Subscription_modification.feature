Feature: user is able to modify Exchange Subscriptions on Subscription page

  Background:
    Given user logs into the system
  @modify
  Scenario Outline: user is able to delete the selected Subscription Before Payment
    When user adds exchange with "<ProtocolType>" and <amount> of sessions
    Then user selects exchange subscription
    When user clicks on delete icon
    And clicks on Confirm button
    Then the system should delete the Subscription
    Examples:
      | ProtocolType | amount |
      | FIX 4.2      | 1      |
      | FIX 4.3      | 2      |
      | FIX 4.4      | 3      |
      | FIX 5.0      | 14     |
      | FIX 5.0 SP1  | 7      |
      | FIX 5.0 SP2  | 100    |

  Scenario: user is able to delete the selected Subscription After Payment
    When user selects a paid subscription on Subscription page
    Then user clicks on delete icon
    And clicks on Confirm button
    When user clicks on Confirm button on the delete confirmation window
    Then the system should delete the Subscription

  Scenario Outline: user is able to increase the number of sessions
    When user adds exchange with "<ProtocolType>" and <amount> of sessions
    And user clicks on plus sign on Sessions once
    Then the number of sessions should be one more of <amount>
    And calculated Current Payment should be same with on Pay button
    Examples:
      | ProtocolType | amount |
      | FIX 4.2      | 1      |
      | FIX 4.3      | 2      |
      | FIX 4.4      | 3      |
      | FIX 5.0      | 14     |
      | FIX 5.0 SP1  | 7      |
      | FIX 5.0 SP2  | 100    |


