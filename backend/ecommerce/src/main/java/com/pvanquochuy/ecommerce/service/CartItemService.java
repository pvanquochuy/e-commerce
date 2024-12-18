package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.CartItemException;
import com.pvanquochuy.ecommerce.exception.UserException;
import com.pvanquochuy.ecommerce.model.Cart;
import com.pvanquochuy.ecommerce.model.CartItem;
import com.pvanquochuy.ecommerce.model.Product;

public interface CartItemService {
    CartItem createCartItem(CartItem cartItem);
    CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;
    CartItem isCarttemExist(Cart cart, Product product, String size, Long userId);
    void removeCartItem(Long userId, Long cardItemId) throws CartItemException, UserException;
    CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
