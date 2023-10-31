package com.mission.mymission.controller;

import com.mission.mymission.entity.Store;
import com.mission.mymission.entity.User;
import com.mission.mymission.repository.UserRepository;
import com.mission.mymission.service.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class UserController {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse res) {
        String get_email = params.get("email");
        String get_password = params.get("password");

        User user = userRepository.findByEmailAndPassword(get_email, get_password);

        if (user != null) { // 사용자가 존재하는지 확인

            // 사용자의 암호 해시와 입력한 암호를 비교
            boolean isPasswordMatch = passwordEncoder.matches(get_password, user.getPassword());

            if (isPasswordMatch) { // 암호 일치
                // 사용자의 일련 번호 가져오기
                int seq = user.getSeq();
                String token = jwtService.getToken("seq", seq);

                // JWT 토큰을 클라이언트로 전달하도록 쿠키를 설정
                Cookie cookie = new Cookie("token", token);
                cookie.setHttpOnly(true);
                cookie.setPath("/");

                res.addCookie(cookie);

                return new ResponseEntity<>(seq, HttpStatus.OK);
            }
        }

        // 로그인 실패
        return new ResponseEntity<>(0, HttpStatus.OK);
    }


    @PostMapping("/user/logout")
    public ResponseEntity logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        res.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
//        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/check")
    public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
        Claims claims = jwtService.getClaims(token);

        if (claims != null) {
            int seq = Integer.parseInt(claims.get("seq").toString());
            return new ResponseEntity<>(seq, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/user/join")
    public ResponseEntity join(@RequestBody Map<String, String> params, HttpServletResponse res) {
        User newUser = new User();

        newUser.setId(params.get("id"));
        newUser.setName(params.get("name"));
        newUser.setNickname(params.get("nickname"));
        newUser.setEmail(params.get("email"));
        newUser.setTel(params.get("tel"));

        //유저가 입력한 패스워드를 암호화시킨 변수 encodePassword (패스워드 암호화 작업)
        String encodePassword = passwordEncoder.encode(params.get("password"));
        //System.out.println("유저가 입력한 패스워드 => 암호화" + encodePassword);
        newUser.setPassword(encodePassword);

        userRepository.save(newUser);

        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    @GetMapping("/user/join/{id}")
    public ResponseEntity joinExist(@PathVariable("id") String id, HttpServletResponse res) {
        User exist = userRepository.findById(id);
        if (exist != null) {
            return new ResponseEntity<>(0, HttpStatus.OK);
        }
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    @GetMapping("/user/mypage")
    public ResponseEntity getMypage(@CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        User users = userRepository.findBySeq(seq);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/user/mypage/update")
    public ResponseEntity getMypageUpdate(@RequestBody User updateuser,
                                          @CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        User user = userRepository.findBySeq(seq);

        user.setId(updateuser.getId());
//        user.setPassword(updateuser.getPassword());
        user.setName(updateuser.getName());
        user.setNickname(updateuser.getNickname());
        user.setEmail(updateuser.getEmail());
        user.setTel(updateuser.getTel());

//        String encodePassword = passwordEncoder.encode(updateuser.getPassword());
//        user.setPassword(encodePassword);

        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/user/mypage/delete/{seq}")
    public ResponseEntity removeUser (@PathVariable("seq") int seq) {
        User user = userRepository.findBySeq(seq);
        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
