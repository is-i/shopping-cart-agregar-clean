package isi.shoppingCart.entities;

import java.util.List;

public class Purchase {
    private int id;
    private Cart cart;
    private List<Double> subtotals;
    private Double total;

    public Purchase(int id, Cart cart) {
        this.id = id;
        this.cart = cart;
    }

    public int getId() { return this.id; }
    public void setSubtotals(List<Double> subtotals) { this.subtotals = subtotals; }
    public List<Double> getSubtotals() { return this.subtotals; }
    public Double getTotal() { return this.total; }
}
