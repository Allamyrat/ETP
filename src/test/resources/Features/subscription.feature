Feature: User is able to add Exchange Subscription

  Background:
    Given user logs into the system
  @Subscription
  Scenario Outline: Adding Exchange Subscription
    When user clicks on AddExchange button
    Then user selects a "<ProtocolType>"
    And user selects session <amount>
    Then verify that exchange can be added for selected session <amount>

    Examples:
      | ProtocolType | amount |
      | FIX 4.2      | 1      |
      | FIX 4.3      | 1      |
      | FIX 4.4      | 2      |
      | FIX 5.0      | 14     |
      | FIX 5.0 SP1  | 7      |
      | FIX 5.0 SP2  | 100    |

  Scenario: User should not be able to add exchange subscription without session
    When  user adds Exchange with followings
      |ProtocolType|FIX 4.3 |
      |SessionAmount|0      |
    Then Add button should be disabled

  Scenario Outline: Validating added Exchange Subscription
    When user adds exchange with "<ProtocolType>" and <amount> of sessions
    Then header should be "Subscription"
    And payment status should be Unpaid
    And left Subscription bar should match right Subscription bar for selected "<ProtocolType>" and <amount>

    Examples:
      | ProtocolType | amount |
      | FIX 4.2      | 1      |
      | FIX 4.3      | 1      |
      | FIX 4.4      | 2      |
      | FIX 5.0      | 14     |
      | FIX 5.0 SP1  | 7      |
      | FIX 5.0 SP2  | 100    |

