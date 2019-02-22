package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    private final ProductMapper productMapper;

    @Autowired
    public CartMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(cartDto.getId(), productMapper.mapToProductList(cartDto.getProductsInCart()));
    }

    public CartDto mapToCartDto (final Cart cart) {
        return new CartDto(cart.getId(), productMapper.mapToProductDtoList(cart.getProducts()));
    }

    public List<CartDto> mapToCartDtoList (final List<Cart> carts) {
        return carts.stream()
                .map(e -> new CartDto(e.getId(), productMapper.mapToProductDtoList(e.getProducts())))
                .collect(Collectors.toList());
    }


}
