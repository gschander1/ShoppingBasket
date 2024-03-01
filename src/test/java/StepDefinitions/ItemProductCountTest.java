package StepDefinitions;

import io.cucumber.java.en.*;
import uk.co.shoppingcart.Basket;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemProductCountTest {

    Basket basket;
    Map<String, Integer> totalProductCount;

    @Given("a there are items in basket")
    public void a_there_are_items_in_basket() {
        basket = new Basket();
        basket.addProductToCart("Apple");
        basket.addProductToCart("Apple");
        basket.addProductToCart("Apple");
        basket.addProductToCart("Apple");
        basket.addProductToCart("Lime");
        basket.addProductToCart("Lime");
        basket.addProductToCart("Watermelon");
        basket.addProductToCart("Melon");
    }

    @When("the basket is created")
    public void the_basket_is_created() {
        totalProductCount = new HashMap<>();
        totalProductCount = basket.countEachProductInBasket(basket.getProductsInBasket());
    }

    @Then("total count of each product is calculated")
    public void total_count_of_each_product_is_calculated() {
        assertThat(totalProductCount).hasSize(4);
        assertThat(totalProductCount).extracting("Apple").isEqualTo(4);
        assertThat(totalProductCount).extracting("Lime").isEqualTo(2);
        assertThat(totalProductCount).extracting("Melon").isEqualTo(1);
        assertThat(totalProductCount).extracting("Watermelon").isEqualTo(1);

    }
}
