package uk.co.shoppingcart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketPriceCalculator {

    OffersCalculator offersCalculator;
    Basket basket;
    Item item;
    Map<String, Integer> productListCounter;

    public BasketPriceCalculator() {
    }

    public Double getBasketPricing(List<String> productsInBasket) {
        double totalPrice = 0.0;
        productListCounter = new HashMap<>();
        item = new Item();
        offersCalculator = new OffersCalculator();
        basket = new Basket();

        productListCounter = basket.countEachProductInBasket(productsInBasket);

        for (int i = 0; i < productsInBasket.size(); i++) {
            double itemPrice = item.getItemPrice(getProductName(productsInBasket, i));
            totalPrice = totalPrice + itemPrice;
        }
        double discountPrice = offersCalculator.calculateOfferPrice(productListCounter);
        return totalPrice - discountPrice;
    }

    private static String getProductName(List<String> productsInBasket, int i) {
        return productsInBasket.get(i);
    }
}
