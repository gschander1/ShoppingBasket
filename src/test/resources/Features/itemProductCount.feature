Feature: count the total unique product in the basket
  Scenario: count unique products in the basket
    Given a there are items in basket
    When the basket is created
    Then total unique count occurs for each product