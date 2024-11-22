package com.pvanquochuy.ecommerce.repository;

import com.pvanquochuy.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByemail(String email);

}
