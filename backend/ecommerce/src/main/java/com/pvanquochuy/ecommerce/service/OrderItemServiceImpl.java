package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.model.OrderItem;
import com.pvanquochuy.ecommerce.repository.OrderItemRepository;

public class OrderItemServiceImpl implements OrderItemService{

    private OrderItemRepository orderItemRepository;
    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
