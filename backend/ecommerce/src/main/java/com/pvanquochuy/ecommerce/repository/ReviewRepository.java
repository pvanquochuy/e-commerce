package com.pvanquochuy.ecommerce.repository;

import com.pvanquochuy.ecommerce.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r WHERE r.product.id =: productId")
    List<Review> getAllProductsReview(@Param("productId")Long productId);
}
