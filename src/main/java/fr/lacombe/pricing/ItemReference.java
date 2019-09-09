package fr.lacombe.pricing;

import java.util.Objects;

public final class ItemReference {
    private final String reference;

    private ItemReference(String reference) {
        this.reference = reference;
    }

    public static ItemReference of(String reference) {
        return new ItemReference(reference);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemReference that = (ItemReference) o;
        return Objects.equals(reference, that.reference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reference);
    }
}
