package isi.shoppingCart.usecases.ports;

import isi.shoppingCart.entities.Purchase;
import java.util.List;

public interface PurchaseRepository {
    List<Purchase> findAll();
    Purchase findById(int id);
}
