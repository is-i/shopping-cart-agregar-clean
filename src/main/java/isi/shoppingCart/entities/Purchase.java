package isi.shoppingCart.entities;

import java.util.Collections;
import java.util.List;

public class Purchase {
    private final int id;
    private final List<CartItem> items;
    public Purchase(int id, List<CartItem> items) {
        this.items = items;
        this.id = id;
    }
    public int getId() { return this.id; }
    public List<CartItem> getItems() { return Collections.unmodifiableList(items); }
}
