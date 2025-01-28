package com.example.ajopay.controller;
import com.example.ajopay.dto.Reponse.Response;
import com.example.ajopay.dto.RequestDto.Request;
import com.example.ajopay.service.UserService;
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
    public Response Signup(@RequestBody Request request) {
        return userService.Signup(request);
    }
}
