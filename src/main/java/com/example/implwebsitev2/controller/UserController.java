package com.example.implwebsitev2.controller;

import com.example.implwebsitev2.domain.User;
import com.example.implwebsitev2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // @Controller -> @RestController ( Json )
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    // 인스턴스 의존성 주입
    private final UserRepository userRepository;

    // CREATE (유저 저장)
    @PostMapping("/create")
    public User userSave(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 전체 조회
    @GetMapping("/search")
    public List<User> searchAllUser() {
        return userRepository.findAll();
    }

    // user 개별 조회
    @GetMapping("/{id}")
    public ResponseEntity<User> searchUser(@PathVariable String id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}

