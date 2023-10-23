package com.mission.mymission.controller;

import com.mission.mymission.entity.User;
import com.mission.mymission.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AcoountController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/account/login")
    public int login(@RequestBody Map<String, String> params) {
        User user = userRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
        if (user!= null) {
            return user.getSeq();
        }

        return 0;
    }
}
