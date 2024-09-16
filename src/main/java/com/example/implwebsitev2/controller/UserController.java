package com.example.implwebsitev2.controller;

import com.example.implwebsitev2.domain.User;
import com.example.implwebsitev2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/api/test")
    public void userSave(@RequestBody User user) {
        userRepository.save(user);
    }
}

