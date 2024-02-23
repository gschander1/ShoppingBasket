package StepDefinitions;

import io.cucumber.java.en.*;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.*;
import uk.co.shoppingcart.Basket;
import uk.co.shoppingcart.BasketPriceCalculator;

import java.util.List;

public class BasketPriceTest {

    Basket basket;
    BasketPriceCalculator basketPriceCalculator;
    List<String> basketItems;
    Double totalBasketPrice = 0.0;

    @Given("a basket has products")
    public void a_basket_has_products() {
        basket = new Basket();
        basket.addProductToCart("Apple"); //35
        basket.addProductToCart("Banana");//20
        basket.addProductToCart("Melon");//50
        basket.addProductToCart("Banana");//20
        basket.addProductToCart("Lime");//15
        basket.addProductToCart("Lime");//15 total= 130
        basketItems = basket.getProductsInBasket();
    }

    @Given("a basket has no products")
    public void a_basket_has_no_products() {
        basket = new Basket();
        basketItems = basket.getProductsInBasket();
    }

    @When("a total cost of basket is requested")
    public void a_total_cost_of_basket_is_requested() {
        basketPriceCalculator = new BasketPriceCalculator();
        totalBasketPrice = basketPriceCalculator.getBasketPricing(basketItems);
    }

    @Then("I get the total cost of basket")
    public void I_get_the_total_cost_of_basket() {
        checkTotalPriceOfBasket(155.0);
    }

    @Then("I get the total cost of zero for basket")
    public void I_get_the_total_cost_of_zero_for_basket() {
        checkTotalPriceOfBasket(0.0);
    }

    @Given("I purchase four limes")
    public void I_purchase_four_limes() {
        basket = new Basket();
        basket.addProductToCart("Lime");
        basket.addProductToCart("Lime");
        basket.addProductToCart("Lime");
        basket.addProductToCart("Lime");
    }

    @When("Limes are added to the basket")
    public void Limes_are_added_to_the_basket() {
        basketItems = basket.getProductsInBasket();
    }

    @Then("Lime offer is applied to basket")
    public void Lime_offer_is_applied_to_basket() {
        basketPriceCalculator = new BasketPriceCalculator();
        totalBasketPrice = basketPriceCalculator.getBasketPricing(basketItems);
    }

    @And("basket price is updated")
    public void basket_price_is_updated() {
        checkTotalPriceOfBasket(45.0);
    }

    @Given("I add four melons to the basket")
    public void i_add_four_melons_to_the_basket() {
        basket = new Basket();
        basket.addProductToCart("Melon");
        basket.addProductToCart("Melon");
        basket.addProductToCart("Melon");
        basket.addProductToCart("Melon");
        basketItems = basket.getProductsInBasket();
    }
    @When("basket price is calculated")
    public void basket_price_is_calculated() {
        basketPriceCalculator = new BasketPriceCalculator();
        totalBasketPrice = basketPriceCalculator.getBasketPricing(basketItems);

    }
    @Then("melon discount two for one is applied")
    public void melon_discount_two_for_one_is_applied() {
        checkTotalPriceOfBasket(100.0);

    }

    private void checkTotalPriceOfBasket(double totalPrice) {
        assertEquals(totalPrice, totalBasketPrice, 0.0); //junit
        assertThat(totalBasketPrice).isEqualTo(totalPrice); //assertJ
    }

}
