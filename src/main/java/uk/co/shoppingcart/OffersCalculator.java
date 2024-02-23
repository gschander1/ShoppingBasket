package uk.co.shoppingcart;

import java.util.*;

public class OffersCalculator {

    Item item;
    public OffersCalculator() {
    }

    public double calculateOfferPrice(Map<String, Integer> productCount) {
        item = new Item();

        double limeDiscount = (productCount.containsKey("Lime") && (productCount.get("Lime") >= 3)) ? limeOffer(item, productCount.get("Lime")) : 0.0;;

        double melonDiscount = (productCount.containsKey("Melon") && (productCount.get("Melon") >= 2)) ? melonOffer(item, productCount.get("Melon")):0.0 ;

        return limeDiscount + melonDiscount;
    }

    private Double limeOffer(Item item, Integer limeCount) {
        return ((limeCount / 3)) * item.getItemPrice("Lime");  // 3 for 2 offer
    }

    private Double melonOffer(Item item, Integer melonCount) {
        return (melonCount / 2 ) * item.getItemPrice("Melon"); //Buy one, get one free for Melon
    }
}

