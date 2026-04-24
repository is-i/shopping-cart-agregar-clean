package isi.shoppingCart.infrastructure.repositories;

import isi.shoppingCart.usecases.ports.PurchaseRepository;
import isi.shoppingCart.entities.Purchase;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class InMemoryPurchaseRepository implements PurchaseRepository {
    private List<Purchase> purchases;
    public InMemoryPurchaseRepository() {
        purchases = new ArrayList<Purchase>();
    }

    @Override
    public void recordPurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    @Override
    public List<Purchase> findAll() {
        return Collections.unmodifiableList(purchases);
    }

    @Override
    public Purchase findById(int id) {
        for (int i = 0; i < purchases.size(); i++) {
            Purchase purchase = purchases.get(i);

            if (purchase.getId() == id) {
                return purchase;
            }
        }
        return null;
    }
}
