package isi.shoppingCart.usecases.services;

import java.util.List;

import isi.shoppingCart.entities.Cart;
import isi.shoppingCart.entities.CartItem;
import isi.shoppingCart.entities.Product;
import isi.shoppingCart.entities.Purchase;
import isi.shoppingCart.usecases.ports.CartRepository;
import isi.shoppingCart.usecases.ports.ProductRepository;
import isi.shoppingCart.usecases.ports.PurchaseRepository;

public class ShoppingCartApp {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final PurchaseRepository purchaseRepository;
    private final AgregarProductoAlCarritoUseCase agregarProductoAlCarritoUseCase;
    private final ConfirmarCompraUseCase confirmarCompraUseCase;

    public ShoppingCartApp(ProductRepository productRepository,
                           CartRepository cartRepository,
                           PurchaseRepository purchaseRepository,
                           AgregarProductoAlCarritoUseCase agregarProductoAlCarritoUseCase,
                           ConfirmarCompraUseCase confirmarCompraUseCase) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.purchaseRepository = purchaseRepository;
        this.agregarProductoAlCarritoUseCase = agregarProductoAlCarritoUseCase;
        this.confirmarCompraUseCase = confirmarCompraUseCase;
    }

    public List<Product> getCatalogProducts() {
        return productRepository.findAll();
    }

    public List<CartItem> getCartItems() {
        Cart cart = cartRepository.getCart();
        return cart.getItems();
    }

    public double getCartTotal() {
        Cart cart = cartRepository.getCart();
        return cart.getTotal();
    }

    public List<Purchase> getPurchasesRecord() {
        return purchaseRepository.findAll();
    }

    public String addProductToCart(int productId) {
        return agregarProductoAlCarritoUseCase.execute(productId);
    }

    public String confirmPurchase() {
        return confirmarCompraUseCase.execute();
    }
}
