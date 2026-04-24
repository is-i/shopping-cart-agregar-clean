package isi.shoppingCart.entities;

public class Purchase {
   private int id;
   private double totalPrice;

   public Purchase(int id, double totalPrice){
       this.id = id;
       this.totalPrice = totalPrice;
   }

    public static Purchase crearDesde(Cart cart, int idCompra) {
        double total = cart.getTotal();

        return new Purchase(idCompra, total);
    }

   public int getId() {
       return id;
   }

   public double getTotalPrice() {
       return totalPrice;
   }
}
