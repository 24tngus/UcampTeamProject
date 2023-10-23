package com.mission.mymission.controller;

import com.mission.mymission.entity.User;
import com.mission.mymission.exception.BusinessException;
import com.mission.mymission.repository.UserRepository;
import com.mission.mymission.service.JwtService;
import com.mission.mymission.service.JwtServiceImpl;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final JwtService jwtService;

    @PostMapping("/account/login")
    public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse res) {
        User user = userRepository.findByEmailAndPassword(params.get("email"), params.get("password"));
        if (user!= null) { // seq 값을 토큰화 해서 cookie에 넣어 전달
            int seq = user.getSeq();
            String token = jwtService.getToken("seq", seq);

            // token값을 클라이언트에 전달해서 인증할 수 있지만,
            // 서버에서 관리하는게 안전해서 SSR 형식으로 구현
//            return token;
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);

            return new ResponseEntity<>(seq, HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/account/logout")
    public ResponseEntity logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        res.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
//        return ResponseEntity.ok().build();
    }

    @GetMapping("/account/check")
    public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
        Claims claims = jwtService.getClaims(token);

        if (claims != null) {
            int seq = Integer.parseInt(claims.get("seq").toString());
            return new ResponseEntity<>(seq, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/mypage/{id}")
    public User getUser(@PathVariable int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new BusinessException("User Not Found", HttpStatus.NOT_FOUND));
        return user;
    }
}
