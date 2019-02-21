package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, CartMapper cartMapper,
                          ProductMapper productMapper, ProductService productService) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @GetMapping
    public CartDto getProductsInCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = cartService.addCart(new Cart());
            session.setAttribute("cart", cart);
        }
        return cartMapper.mapToCartDto(cart);
    }

    @PostMapping
    public CartDto addProductsToCart(@RequestBody List<ProductDto> products, HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        return cartMapper.mapToCartDto(cartService.addProducts(productMapper.mapToProductList(products), cart));
    }

    @DeleteMapping("/{product_id}")
    public void removeProductFromCart(@PathVariable("product_id") long productId, HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.getProducts().remove(productService.getProductById(productId));
    }

}