package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.dto.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.CartService;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductMapper productMapper;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService,
                          ProductMapper productMapper, ProductService productService) {
        this.cartService = cartService;
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProductsInCart(HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = cartService.addCart(new Cart());
        }
        return productMapper.mapToProductDtoList(cart.getProducts());
    }

    @PostMapping
    public List<Product> addProductsToCart(@RequestBody List<ProductDto> products, HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        return cartService.addProducts(productMapper.mapToProductList(products), cart);
    }

    @DeleteMapping("/{product_id}")
    public void removeProductFromCart(@PathVariable("product_id") long productId, HttpServletRequest request) {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.getProducts().remove(productService.getProductById(productId));
    }

}