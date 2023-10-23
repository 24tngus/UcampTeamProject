package com.mission.mymission.controller;

import com.mission.mymission.entity.User;
import com.mission.mymission.exception.BusinessException;
import com.mission.mymission.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class UserController {
    private final UserRepository userRepository;

    @PostMapping("/account/login")
    public int login(@RequestBody Map<String, String> params) {
        User user = userRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
        if (user!= null) {
            return user.getSeq();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mypage/{id}")
    public User getUser(@PathVariable int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
        return user;
    }
}
