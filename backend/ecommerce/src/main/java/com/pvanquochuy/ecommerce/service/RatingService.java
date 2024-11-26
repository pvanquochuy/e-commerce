package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.ProductException;
import com.pvanquochuy.ecommerce.model.Rating;
import com.pvanquochuy.ecommerce.model.User;
import com.pvanquochuy.ecommerce.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingService {
    Rating createRating(RatingRequest req, User user) throws ProductException;
    List<Rating> getProductRating(Long productId);

}
