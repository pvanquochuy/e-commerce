package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.CartItemException;
import com.pvanquochuy.ecommerce.exception.ProductException;
import com.pvanquochuy.ecommerce.exception.UserException;
import com.pvanquochuy.ecommerce.model.Cart;
import com.pvanquochuy.ecommerce.model.User;
import com.pvanquochuy.ecommerce.request.AddItemRequest;

public interface CartService {
    Cart createCart(User user);
    String addCartItem(Long userId, AddItemRequest req) throws ProductException, CartItemException, UserException;
    Cart findUsercart(Long userId);
}
