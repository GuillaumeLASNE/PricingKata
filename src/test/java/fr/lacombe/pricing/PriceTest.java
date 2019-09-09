package fr.lacombe.pricing;

import org.junit.jupiter.api.Test;

import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;

class PriceTest {

    //TODO: test for default equality before edge cases

    @Test
    void zero_is_equal_with_any_currency() {
        assertThat(Price.ZERO).isEqualTo(Price.of(0, Currency.getInstance("EUR")));
    }
}