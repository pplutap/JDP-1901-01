package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartById(long id) {

        return cartRepository.findById(id).orElseThrow(CartNotFoundException::new);
    }

    public List<Cart> getCartList() {
        return cartRepository.findAll();
    }

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }


}
