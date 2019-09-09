package fr.lacombe.pricing;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class CashRegisterTest {

    @Test
    void price_of_an_empty_cart_is_zero() {
        CashRegister cashRegister = new CashRegister();
        Cart cart = Cart.of(Collections.emptyList());

        Price price = cashRegister.price(cart);

        assertThat(price).isEqualTo(Price.ZERO);
    }
}
