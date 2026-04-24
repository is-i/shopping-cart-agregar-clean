package isi.shoppingCart.usecases.ports;

import isi.shoppingCart.entities.Purchase;
import java.util.List;

public interface PurchaseRepository {
    List<Purchase> findAll();
    void save(Purchase purchase);
}
