package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.ProductException;
import com.pvanquochuy.ecommerce.model.Review;
import com.pvanquochuy.ecommerce.model.User;
import com.pvanquochuy.ecommerce.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    Review createReview(ReviewRequest req, User user) throws ProductException;
    List<Review> getAllReview(Long productId);

}
