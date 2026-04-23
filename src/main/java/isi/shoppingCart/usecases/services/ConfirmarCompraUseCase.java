package isi.shoppingCart.usecases.services;

import isi.shoppingCart.entities.Cart;
import isi.shoppingCart.entities.Product;
import isi.shoppingCart.usecases.ports.CartRepository;
import isi.shoppingCart.usecases.ports.ProductRepository;

public class ConfirmarCompraUseCase {
    private ProductRepository productRepository;
    private CartRepository cartRepository;

    public ConfirmarCompraUseCase(ProductRepository productRepository, CartRepository cartRepository){
        this.productRepository=productRepository;
        this.cartRepository=cartRepository;
    }
    public Boolean ValidarCarrito{
        int carrito;
        Cart cart = cartRepository.getCart();
        if(cart.getTotal()==0){
            return false;
        }


    }
}
