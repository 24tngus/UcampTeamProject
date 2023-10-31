package com.mission.mymission.controller;

import com.mission.mymission.entity.ShopRegister;
import com.mission.mymission.entity.Store;
import com.mission.mymission.repository.StoreRepository;
import com.mission.mymission.service.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class StoreController {
    private final JwtService jwtService;
    private final StoreRepository storeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${file.dir")
    private String fileDir;

    @PostMapping("/store/login")
    public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse res) {
        String get_id = params.get("id");
        String get_password = params.get("password");
        Store store = storeRepository.findById(get_id);
        if (store != null) { // id 확인
            // seq 값을 토큰화 해서 cookie에 넣어 전달
            int seq = store.getSeq();
            String token = jwtService.getToken("seq", seq);

            String encodePassword = store.getPassword();
            //System.out.println("암호화된 패스워드와 유저가 입력한 패스워드가 일치하는지" + decodePassword);
            Boolean decodePassword = passwordEncoder.matches(get_password, encodePassword);

//            if (decodePassword != true) { // 비밀번호 확인
//                //암호화된 패스워드와 유저가 입력한 패스워드 비교 => 일치하면 true
//                //로그인 할 때 db에 암호화되어 저장된 패스워드와  로그인 창에서 입력한 패스워드와 비교해서
//                return new ResponseEntity<>(0, HttpStatus.OK);
//            }
            // token값을 클라이언트에 전달해서 인증할 수 있지만, 서버에서 관리하는게 안전해서 SSR 형식으로 구현
            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);

            return new ResponseEntity<>(seq, HttpStatus.OK);
        }
        return new ResponseEntity<>(0, HttpStatus.OK);
    }

    @PostMapping("/store/logout")
    public ResponseEntity logout(HttpServletResponse res) {
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        res.addCookie(cookie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/store/join")
    public ResponseEntity join(@RequestBody Map<String, String> params, HttpServletResponse res) {

        Store newStore = new Store();
        newStore.setId(params.get("id"));
        newStore.setName(params.get("name"));
        newStore.setEmail(params.get("email"));
        newStore.setTel(params.get("tel"));
        newStore.setStorenumber(params.get("storenumber"));
        newStore.setStorefile(params.get("storefile"));

        //유저가 입력한 패스워드를 암호화시킨 변수 encodePassword (패스워드 암호화 작업)
        String encodePassword = passwordEncoder.encode(params.get("password"));
        //System.out.println("유저가 입력한 패스워드 => 암호화" + encodePassword);
        newStore.setPassword(encodePassword);

        storeRepository.save(newStore);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/store/join/{id}")
    public ResponseEntity joinExist(@PathVariable("id") String id, HttpServletResponse res) {
        Store exist = storeRepository.findById(id);
        if (exist != null) {
            return new ResponseEntity<>(0, HttpStatus.OK);
        }
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    @GetMapping("/store/mypage")
    public ResponseEntity getStore(@CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        Store stores = storeRepository.findBySeq(seq);

        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @PutMapping("/store/mypage/update")
    public ResponseEntity getStoreUpdate(@RequestBody Store updatestore,
                                          @CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        Store store = storeRepository.findBySeq(seq);

        store.setId(updatestore.getId());
        store.setName(updatestore.getName());
        store.setEmail(updatestore.getEmail());
        store.setTel(updatestore.getTel());
        store.setStorenumber(updatestore.getStorenumber());
        store.setStorefile(updatestore.getStorefile());

//        String encodePassword = passwordEncoder.encode(updatestore.getPassword());
//        store.setPassword(encodePassword);

        storeRepository.save(store);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/store/mypage/delete/{seq}")
    public ResponseEntity removeStore (@PathVariable("seq") int seq) {
        Store store = storeRepository.findBySeq(seq);
        storeRepository.delete(store);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
