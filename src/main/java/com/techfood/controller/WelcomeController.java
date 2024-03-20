package com.techfood.controller;

import com.techfood.dto.WelcomeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping
    public WelcomeDto welcome() {
        return new WelcomeDto("User login is successful, you are being redirected.");
    }

}
