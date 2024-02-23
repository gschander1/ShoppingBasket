package StepDefinitions;

import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.*;

import uk.co.shoppingcart.Basket;

import static org.junit.Assert.*;

import java.util.List;

public class BasketTest {

    List<String> basketItems = null;

    @Given("a new product and quantity is added")
    public void a_new_product_and_quantity_is_added() {
    }

    @When("it is added to the basket")
    public void it_is_added_to_the_basket() {
        Basket basket = new Basket();
        basket.addProductToCart("Apple");
        basket.addProductToCart("Mango");
        basket.addProductToCart("Mango");
        basketItems = basket.getProductsInBasket();
    }

    @Then("basket is updated")
    public void basket_is_updated() {
        assertEquals("Apple", basketItems.get(0));
        assertEquals("Mango", basketItems.get(1));
        assertEquals("Mango", basketItems.get(2));   //junit assertion

        assertThat(basketItems)                 //assertj
                .contains("Mango", "Apple", "Mango")
                .hasSize(3);
    }
}
