package com.techfood.controller;

import com.techfood.dto.RegisterUser;
import com.techfood.entity.User;
import com.techfood.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterUser registerUser) {
        return authenticationService
                .register(registerUser.username(), registerUser.password());
    }
}
