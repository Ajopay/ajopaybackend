package com.example.ajopay.service;

import com.example.ajopay.model.Users;
import com.example.ajopay.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(email));
        if (users == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");

        }
        return new CustomUserDetails(users);
    }
}
