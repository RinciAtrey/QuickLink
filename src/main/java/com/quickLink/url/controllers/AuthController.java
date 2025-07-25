package com.quickLink.url.controllers;

import com.quickLink.url.dto.LoginRequest;
import com.quickLink.url.dto.RegisterRequest;
import com.quickLink.url.models.User;
import com.quickLink.url.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;


    @PostMapping("/public/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
      return ResponseEntity.ok(userService.loginUser(loginRequest));
    }


    @PostMapping("/public/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
       User user= new User();
       user.setUsername(registerRequest.getUsername());
       user.setPassword(registerRequest.getPassword());
       user.setEmail(registerRequest.getEmail());
       user.setRole("ROLE_USER");
       userService.registerUser(user);
       return ResponseEntity.ok("User registered successfully");
    }
}
