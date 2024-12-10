package com.pvanquochuy.ecommerce.repository;

import com.pvanquochuy.ecommerce.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
