package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/V1/cart")
public class CartController {
    private final CartMapper cartMapper;

    public CartController(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @GetMapping(value = "getProductsInCart")
    public Map<Long, Integer> getProductsInCart(long cartId) throws CartNotFoundException {
        return new HashMap<Long, Integer>();
    }

    @PutMapping(value = "updateCart")
    public CartDto updateCart(CartDto cartDto, long productId, int quantity) {
        Map<Long, Integer> productsInCart = new HashMap<>(2, 5);
        return new CartDto(1L, productsInCart);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductFromCart")
    public void deleteProductFromCart(long cartId, long productId) {

    }

    @PostMapping(value = "orderProducts")
    public void orderProducts() {

    }

    @PostMapping(value = "createCart")
    public void createCart() {

    }
}
