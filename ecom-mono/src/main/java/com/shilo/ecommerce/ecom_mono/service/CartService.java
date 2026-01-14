package com.shilo.ecommerce.ecom_mono.service;

import com.shilo.ecommerce.ecom_mono.dto.CartDTO;
import com.shilo.ecommerce.ecom_mono.dto.CartItemDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartService {
    public CartDTO addProductToCart(Integer productId, Integer quantity);
    public List<CartDTO> getAllCarts();
    public CartDTO getCart(String emailId, Integer cartId);
    @Transactional
    public CartDTO updateProductQuantityInCart(Integer productId, Integer quantity);
    public String deleteProductFromCart(Integer cartId, Integer productId);
    public void updateProductInCarts(Integer cartId, Integer productId);
    public String createOrUpdateCartWithItems(List<CartItemDTO> cartItems);
}
