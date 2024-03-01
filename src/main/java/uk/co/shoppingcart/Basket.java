package uk.co.shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    private final List<String> basketItems = new ArrayList<>();

    private final Map<String, Integer> productCount = new HashMap<>();

    public Basket() {
    }

    public void addProductToCart(String itemName) {
        basketItems.add(itemName);
    }

    public List<String> getProductsInBasket() {
        return basketItems;
    }

    public Map<String, Integer> countEachProductInBasket(List<String > productsInBasket) {

        int count = 0;
        for (String itemName : productsInBasket) {
            productCount.put(itemName, productCount.getOrDefault(itemName, count) + 1);
        }

        return productCount;
    }
}
