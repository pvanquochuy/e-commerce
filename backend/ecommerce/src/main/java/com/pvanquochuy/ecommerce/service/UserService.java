package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.UserException;
import com.pvanquochuy.ecommerce.model.User;


public interface UserService {
     User findUserById(Long userId) throws UserException;
     User findUserProfileByJwt(String jwt) throws UserException;

}
