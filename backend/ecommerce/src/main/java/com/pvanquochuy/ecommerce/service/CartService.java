package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.ProductException;
import com.pvanquochuy.ecommerce.model.Cart;
import com.pvanquochuy.ecommerce.model.User;
import com.pvanquochuy.ecommerce.request.AddItemRequest;

public interface CartService {
    Cart createCart(User user);
    String addCartItem(Long userId, AddItemRequest req) throws ProductException;
    Cart findUsercart(Long userId);
}
