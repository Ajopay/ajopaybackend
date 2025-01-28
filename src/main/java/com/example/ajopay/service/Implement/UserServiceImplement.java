package com.example.ajopay.service.Implement;

import com.example.ajopay.dto.Reponse.Response;
import com.example.ajopay.dto.RequestDto.Request;
import com.example.ajopay.model.Users;
import com.example.ajopay.repository.UserRepository;
import com.example.ajopay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public Response Signup(Request request) {
        // Correctly instantiate the user object using the constructor
        Users user = new Users(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getPassword(),
                request.getConfirmpassword()
        );


        Users createdUser = repository.save(user);


        return new Response(createdUser.getFirstName());
    }
}
