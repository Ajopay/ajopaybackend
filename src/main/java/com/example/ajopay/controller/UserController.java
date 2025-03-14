package com.example.ajopay.controller;

import com.example.ajopay.dto.Reponse.LoginResponse;
import com.example.ajopay.dto.Reponse.Response;
import com.example.ajopay.dto.RequestDto.LoginDto;
import com.example.ajopay.dto.RequestDto.Request;
import com.example.ajopay.model.Users;
import com.example.ajopay.repository.UserRepository;
import com.example.ajopay.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:5500", allowCredentials = "true")


public class UserController {


    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    @PostMapping("/signup")
    public Response signup(@RequestBody Request request) {
        return userService.Signup(request);
    }

    @GetMapping("/user/{firstName}")
    public ResponseEntity<Users> getUserByFirstName(@PathVariable String firstName) {
        Users user = userService.getUsersbyFirstName(firstName);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Users> getUserbyEmail(@PathVariable String email) {
        Users user=userService.getEmail(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity <LoginResponse> login(@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse = userService.verify(loginDto);
        return ResponseEntity.ok(loginResponse);
//        Users users1= userRepository.findByEmail(users.getEmail());
//        if (users1 == null) {
//            return "user not  found";
//        }else {
//            return "Successfully logged in";
//        }
    }
}
