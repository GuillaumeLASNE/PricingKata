package fr.lacombe.pricing;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Cart implements Iterable<ItemReference> {
    private final Collection<ItemReference> itemReferences;

    private Cart(Collection<ItemReference> itemReferences) {
        this.itemReferences = itemReferences;
    }

    public static Cart of(Collection<ItemReference> itemReferences) {
        return new Cart(itemReferences);
    }

    @Override
    public Iterator<ItemReference> iterator() {
        return itemReferences.iterator();
    }

    @Override
    public void forEach(Consumer<? super ItemReference> action) {
        Objects.requireNonNull(action);
        for (ItemReference itemReference : itemReferences) {
            action.accept(itemReference);
        }
    }

    @Override
    public Spliterator<ItemReference> spliterator() {
        return itemReferences.spliterator();
    }
}
