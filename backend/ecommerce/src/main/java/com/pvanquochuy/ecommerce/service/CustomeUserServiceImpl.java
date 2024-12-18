package com.pvanquochuy.ecommerce.service;

import com.pvanquochuy.ecommerce.exception.UserException;
import com.pvanquochuy.ecommerce.model.User;
import com.pvanquochuy.ecommerce.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomeUserServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public CustomeUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByemail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with email " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }


}
