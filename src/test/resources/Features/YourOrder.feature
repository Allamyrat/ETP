@Order
Feature: User should be able to see Exchange Subscription summary on Order window

  Background:
    Given user logs into the system

    Scenario Outline: Order window should display summary for selected Exchange Subscription
      When user is on Order window with selected "<ProtocolType>" and <amount>
      Then Order window should include selected "<ProtocolType>" and <amount>
      And Pay Now price should be equal to Pay button price on Subscription page
      And Next charge price should be equal to Monthly Subscription price on Subscription page
      Examples:
        | ProtocolType | amount |
        | FIX 4.2      | 1      |
        | FIX 4.3      | 2      |
        | FIX 4.4      | 3      |
        | FIX 5.0      | 14     |
        | FIX 5.0 SP1  | 7      |
        | FIX 5.0 SP2  | 100    |