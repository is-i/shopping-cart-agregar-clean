package isi.shoppingCart.infrastructure.repositories;

import isi.shoppingCart.usecases.ports.PurchaseRepository;
import isi.shoppingCart.entities.Purchase;
import java.util.List;

public class InMemoryPurchaseRepository implements PurchaseRepository {
    private List<Purchase> purchases;
    public InMemoryPurchaseRepository() {

    }
}
