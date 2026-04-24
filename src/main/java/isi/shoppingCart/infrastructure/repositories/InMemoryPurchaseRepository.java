package isi.shoppingCart.infrastructure.repositories;

import isi.shoppingCart.entities.Purchase;
import isi.shoppingCart.usecases.ports.PurchaseRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryPurchaseRepository implements PurchaseRepository {
    private List<Purchase> purchases;

    public InMemoryPurchaseRepository() {
        this.purchases = new ArrayList<>();
    }

    public void save(Purchase purchase) {
        this.purchases.add(purchase);

        System.out.println("Compra guardada exitosamente: ID " + purchase.getId());
    }

    public List<Purchase> findAll() {
        return Collections.unmodifiableList(purchases);
    }
}

