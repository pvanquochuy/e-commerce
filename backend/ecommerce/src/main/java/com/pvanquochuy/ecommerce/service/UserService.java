package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.UserException;
import com.pvanquochuy.ecommerce.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User findUserByLongIḍ(Long userId) throws UserException;
    public User findUserProfileByJwt(String jwt) throws UserException;

}
