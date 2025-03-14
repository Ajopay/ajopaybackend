package com.example.ajopay.service;

import com.example.ajopay.dto.Reponse.LoginResponse;
import com.example.ajopay.dto.Reponse.Response;
import com.example.ajopay.dto.RequestDto.LoginDto;
import com.example.ajopay.dto.RequestDto.Request;
import com.example.ajopay.model.Users;
import com.example.ajopay.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
     Response Signup(Request request);

     Users getUsersbyFirstName(String firstName);
     Users getUsersbyAccount(String account);


      LoginResponse verify(LoginDto loginDto);

     Users getEmail(String email);

//     Users createUser(Users users);
}
