package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCartById(Long id) {

        return cartRepository.findById(id).orElseThrow(CartNotFoundException::new);
    }

    public List<Cart> getCartList() {
        return cartRepository.findAll();
    }

    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }


}
