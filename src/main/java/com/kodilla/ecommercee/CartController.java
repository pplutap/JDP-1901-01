package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/V1/cart")
public class CartController {
    @Autowired
    private CartMapper cartMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getProductsInCart")
    public Map<Long, Integer> getProductsInCart(long cartId) throws CartNotFoundException {
        return new HashMap<Long, Integer>();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCart")
    public CartDto updateCart(CartDto cartDto, long productId, int quantity) {
        Map<Long, Integer> productsInCart = new HashMap<>(2, 5);
        return new CartDto(1L, productsInCart);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductFromCart")
    public void deleteProductFromCart(long cartId, long productId) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "orderProducts")
    public void orderProducts() {

    }

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart() {

    }
}
