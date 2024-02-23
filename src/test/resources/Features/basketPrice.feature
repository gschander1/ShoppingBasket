Feature: get total price of the basket

  Scenario: get total price without offer
    Given a basket has products
    When a total cost of basket is requested
    Then I get the total cost of basket

  Scenario: get three for two discount price on 4 limes
    Given I purchase four limes
    When Limes are added to the basket
    Then Lime offer is applied to basket
    And basket price is updated

  Scenario: get two for one discount prices on 4 melon
    Given I add four melons to the basket
    When basket price is calculated
    Then melon discount two for one is applied

    Scenario: get zero total price when basket is empty
      Given a basket has no products
      When a total cost of basket is requested
      Then I get the total cost of zero for basket