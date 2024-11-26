package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.OrderException;
import com.pvanquochuy.ecommerce.model.Address;
import com.pvanquochuy.ecommerce.model.Order;
import com.pvanquochuy.ecommerce.model.User;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, Address shippingAddress);
    Order findOrderById(Long orderId) throws OrderException;
    List<Order> usersOrderHistory(Long userId);
    Order placedOrder(Long orderId) throws OrderException;
    Order confirmedOrder(Long orderId) throws OrderException;
    Order shippedOrder(Long orderId) throws OrderException;
    Order deliveredOrder(Long orderId) throws OrderException;
    Order canceledOrder(Long orderId) throws OrderException;
    List<Order> getAllOrder();
    void deleteOrder(Long orderId) throws OrderException;
}
