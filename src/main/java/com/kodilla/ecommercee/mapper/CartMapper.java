package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getId(), cartDto.getProductsInCart());
    }

    public CartDto mapToCartDto (final Cart cart) {
        return new CartDto(cart.getId(), cart.getProducts());
    }

    public List<CartDto> mapToCartDtoList (final List<Cart> carts) {
        return carts.stream()
                .map(e -> new CartDto(e.getId(), e.getProducts()) )
                .collect(Collectors.toList());
    }


}
