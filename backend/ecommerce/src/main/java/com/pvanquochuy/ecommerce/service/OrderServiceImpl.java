package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.OrderException;
import com.pvanquochuy.ecommerce.model.Address;
import com.pvanquochuy.ecommerce.model.Order;
import com.pvanquochuy.ecommerce.model.User;
import com.pvanquochuy.ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private CartService cartService;
    private AddressRepository addressRepository;
    private OrderItemService orderItemService;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CartService cartService, AddressRepository addressRepository, OrderItemService orderItemService, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.addressRepository = addressRepository;
        this.orderItemService = orderItemService;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public Order createOrder(User user, Address shippingAddress) {
        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> usersOrderHistory(Long userId) {
        return List.of();
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order canceledOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> getAllOrder() {
        return List.of();
    }

    @Override
    public void deleteOrder(Long orderId) throws OrderException {

    }
}
