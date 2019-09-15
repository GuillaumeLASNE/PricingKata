package fr.lacombe.pricing;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public final class Price {

    public static final Price ZERO = new Price(BigDecimal.ZERO, null);

    private final BigDecimal price;
    private final Currency currency;

    private Price(BigDecimal price, Currency currency) {
        this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.currency = currency;
    }

    public static Price of(double price, Currency currency) {
        //TODO: do not allow null currency
        return new Price(BigDecimal.valueOf(price), currency);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        // ZERO has no currency
        if (Objects.equals(ZERO.price, price) || Objects.equals(ZERO.price, price1.price))
            return Objects.equals(price, price1.price);
        return Objects.equals(price, price1.price) &&
                Objects.equals(currency, price1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, currency);
    }

    public Price add(Price augend) {
        final BigDecimal sumOfPrices = this.price.add(augend.price);
        final Currency currency = ZERO.equals(this) ? augend.currency : this.currency;
        return new Price(sumOfPrices, currency);
    }

    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                ", currency=" + currency +
                '}';
    }
}
