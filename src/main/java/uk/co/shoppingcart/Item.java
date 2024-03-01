package uk.co.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class Item {

    private Double getPriceList(String productName) {
        Map<String, Double> itemPrice = new HashMap<>();
        // Initialize prices
        itemPrice.put("Apple", 35.00);
        itemPrice.put("Banana", 20.00);
        itemPrice.put("Melon", 50.00);
        itemPrice.put("Lime", 15.00);

        return itemPrice.get(productName);
    }

    public Double getItemPrice(String productName) {
        return getPriceList(productName);
    }

}
