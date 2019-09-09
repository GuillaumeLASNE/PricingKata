package fr.lacombe.pricing;

import java.util.Collection;
import java.util.Optional;

public class Cart {
    private final Collection<ItemReference> itemReferences;

    private Cart(Collection<ItemReference> itemReferences) {
        this.itemReferences = itemReferences;
    }

    public static Cart of(Collection<ItemReference> itemReferences) {
        return new Cart(itemReferences);
    }

    public boolean isEmpty() {
        return itemReferences.isEmpty();
    }

    public Optional<ItemReference> getFirst() {
        return itemReferences.stream().findFirst();
    }
}
