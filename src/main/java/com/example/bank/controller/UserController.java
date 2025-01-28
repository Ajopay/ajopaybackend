package com.example.bank.controller;

import com.example.bank.dto.request.RequestDto;
import com.example.bank.dto.response.ResponseDto;
import com.example.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseDto signUp(@RequestBody RequestDto requestDto) {
        // Call the userService to handle the sign-up logic


        return userService.SignUp(requestDto);
    }
}
