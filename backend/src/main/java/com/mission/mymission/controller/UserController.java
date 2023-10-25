package com.mission.mymission.controller;

import com.mission.mymission.entity.Cart;
import com.mission.mymission.entity.Shop;
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
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class UserController {
    private final JwtService jwtService;
    private final UserRepository userRepository;


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

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody Map<String, String> params, HttpServletResponse res) {

        User newUser = new User();
        newUser.setId(params.get("id"));
        newUser.setPassword(params.get("password"));
        newUser.setName(params.get("name"));
        newUser.setNickname(params.get("nickname"));
        newUser.setEmail(params.get("email"));
        newUser.setTel(params.get("tel"));

        userRepository.save(newUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/mypage")
    public ResponseEntity getMypage(@CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        List<User> users = userRepository.findBySeq(seq);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/mypage/update")
    public ResponseEntity getMypageUpdate(@RequestBody Map<String, String> params,
                                          @CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        List<User> user = userRepository.findBySeq(seq);

//        if (user.getId() != null)
//            user.setId(params.get("id"));
//        if (user.getPassword() != null)
//            user.setPassword(params.get("password"));
//        if (user.getName() != null)
//            user.setName(params.get("name"));
//        if (user.getNickname() != null)
//            user.setNickname(params.get("nickname"));
//        if (user.getEmail() != null)
//            user.setEmail(params.get("email"));
//        if (user.getTel() != null)
//            user.setTel(params.get("tel"));
//
//        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
