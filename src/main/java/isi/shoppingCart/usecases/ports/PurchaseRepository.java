package isi.shoppingCart.usecases.ports;

import java.util.List;

import isi.shoppingCart.entities.Purchase;

public interface PurchaseRepository {
    void recordPurchase(Purchase purchase);
    List<Purchase> findAll();
    Purchase findById(int id);
}
