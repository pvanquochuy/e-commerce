package com.pvanquochuy.ecommerce.repository;

import com.pvanquochuy.ecommerce.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
