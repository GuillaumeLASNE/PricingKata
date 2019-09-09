package fr.lacombe.pricing;

import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.singletonList;
import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Assertions.assertThat;

class CashRegisterTest {

    private static final Currency EURO = Currency.getInstance("EUR");

    @Test
    void price_of_an_empty_cart_is_zero() {
        CashRegister cashRegister = new CashRegister(emptyMap());
        Cart cart = Cart.of(emptyList());

        Price price = cashRegister.price(cart);

        assertThat(price).isEqualTo(Price.ZERO);
    }

    @Test
    void price_of_a_cart_containing_one_item_reference_is_item_price() {
        Price priceOfACiderBottle = Price.of(2.99, EURO);
        ItemReference ciderBottleReference = ItemReference.of("REFERENCE_OF_A_CIDER_BOTTLE");

        Map<ItemReference, Price> itemPrices = singletonMap(ciderBottleReference, priceOfACiderBottle);
        CashRegister cashRegister = new CashRegister(itemPrices);

        Price price = cashRegister.price(Cart.of(singletonList(ciderBottleReference)));

        assertThat(price).isEqualTo(Price.of(2.99, EURO));
    }

    @Test
    void price_of_a_cart_containing_an_apple_reference_is_the_apple_price() {
        Price applePrice = Price.of(1, EURO);
        ItemReference appleReference = ItemReference.of("REFERENCE_OF_AN_APPLE");

        Map<ItemReference, Price> itemPrices = singletonMap(appleReference, applePrice);
        CashRegister cashRegister = new CashRegister(itemPrices);

        Price price = cashRegister.price(Cart.of(singletonList(appleReference)));

        assertThat(price).isEqualTo(Price.of(1, EURO));
    }
}
