package fr.lacombe.pricing;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Price {

    public static final Price ZERO = new Price(BigDecimal.ZERO, null);

    private final BigDecimal price;
    private final Currency currency;

    private Price(BigDecimal price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    public static Price of(double price, Currency currency) {
        return new Price(BigDecimal.valueOf(price), currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price) &&
                Objects.equals(currency, price1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, currency);
    }
}
