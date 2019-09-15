package fr.lacombe.pricing;

import java.util.Map;

public class CashRegister {
    private final Map<ItemReference, Price> itemPrices;

    public CashRegister(Map<ItemReference, Price> itemPrices) {
        this.itemPrices = itemPrices;
    }

    public Price price(Cart cart) {
        for (ItemReference itemReference : cart) {
            return itemPrices.get(itemReference);
        }
        return Price.ZERO;
    }
}
