## Shopping Basket


### To run all the tests

`mvn test` 


## Basket.Java

- addProductToCart
- getProductsInBasket
- countEachProductInBasket

## BasketPriceCalculator.java 
- getBasketPricing

## Item.java
- getPriceList
- getItemPrice

## OffersCalculator.java
- calculateOfferPrice

## Tests:

#### `basketPrice.feature` test asserts that the price is calculated correctly for each of the known items

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


### `basket.feature` asserts that the products can be added to basket

    Scenario: Add products to the basket
    Given a new product and quantity is added
    When it is added to the basket
    Then basket is updated

### `itemProductCount.feature` asserts that the products in the basket are counted so that offers can be applied

    Feature: count the total unique product in the basket
    Scenario: count unique products in the basket
    Given a there are items in basket
    When the basket is created
    Then total count of each product is calculated

