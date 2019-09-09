package fr.lacombe.pricing;

public class Price {

    public static final Price ZERO = Price.of(0);

    private Price() {
    }

    public static Price of(int price) {
        return new Price();
    }
}
