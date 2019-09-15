package fr.lacombe.pricing;

import java.util.Map;

public class CashRegister {
    private final Map<ItemReference, Price> itemPrices;

    public CashRegister(Map<ItemReference, Price> itemPrices) {
        this.itemPrices = itemPrices;
    }

    public Price price(Cart cart) {
        Price priceOfTheCart = Price.ZERO;
        for (ItemReference itemReference : cart) {
            priceOfTheCart = priceOfTheCart.add(itemPrices.get(itemReference));
        }
        return priceOfTheCart;
    }
}
