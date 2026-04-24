package isi.shoppingCart.usecases.services;

import isi.shoppingCart.entities.Cart;
import isi.shoppingCart.entities.Product;
import isi.shoppingCart.entities.Purchase;
import isi.shoppingCart.entities.CartItem;
import isi.shoppingCart.usecases.ports.CartRepository;
import isi.shoppingCart.usecases.ports.ProductRepository;
import isi.shoppingCart.usecases.ports.PurchaseRepository;

public class ConfirmarCompraUseCase {
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private PurchaseRepository purchaseRepository;

    public ConfirmarCompraUseCase(ProductRepository productRepository,
                                  CartRepository cartRepository,
                                  PurchaseRepository purchaseRepository){
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public String execute(){
        Cart cart = cartRepository.getCart();

        if (cart == null || cart.getItems().isEmpty()){
            return "Carrito vacio, debe agregar productos para realizar una compra";
        }

        for (CartItem item : cart.getItems()){
            int id = item.getProduct().getId();
            Product product = productRepository.findById(id);

            if(item.getQuantity() > product.getAvailableQuantity()){
                return "Stock insuficiente para" + product.getName();
            }
        }

        Purchase compra = Purchase.crearDesde(cart, 1);

        for (CartItem item : cart.getItems()) {
            int id = item.getProduct().getId();
            Product product = productRepository.findById(id);

            for (int i = 0; i < item.getQuantity(); i++) {
                product.decreaseAvailableQuantity();
            }

            productRepository.save(product);
        }

        purchaseRepository.save(compra);

        cart.clear();
        cartRepository.save(cart);

        return "Compra confirmada con éxito";
    }
}
