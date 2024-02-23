Feature: Adding product to basket

  Scenario: Add a product to the basket
    Given a new product and quantity is added
    When it is added to the basket
    Then basket is updated

