package com.mission.mymission.controller;

import com.mission.mymission.entity.Shop;
import com.mission.mymission.entity.ShopRegister;
import com.mission.mymission.entity.Store;
import com.mission.mymission.repository.ShopRegisterRepository;
import com.mission.mymission.repository.StoreRepository;
import com.mission.mymission.service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class ShopRegisterController {
    private final ShopRegisterRepository registerRepository;

    private final JwtService jwtService;
    private final StoreRepository storeRepository;

    @GetMapping("/shop/register")
    public List<ShopRegister> getShop() {
        List<ShopRegister> register = registerRepository.findAll();

        return register;
    }

    @PostMapping("/shop/register/join")
    public ResponseEntity join(@RequestBody Map<String, String> params, HttpServletResponse res, @CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        Store stores = storeRepository.findBySeq(seq);

        ShopRegister reg = new ShopRegister();
        reg.setStorename(params.get("storename"));
        reg.setDetailinfo(params.get("detailinfo"));
        reg.setCategory(params.get("category"));
        reg.setLocation(params.get("location"));
        reg.setPhonenumber(params.get("phonenumber"));
        reg.setImage(params.get("image"));
        reg.setStoreid(stores.getId());

        registerRepository.save(reg);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/shop/register/join/{storename}")
    public ResponseEntity joinExist(@PathVariable("storename") String storename, HttpServletResponse res) {
        ShopRegister exist = registerRepository.findByStorename(storename);
        if (exist != null) {
            return new ResponseEntity<>(0, HttpStatus.OK);
        }
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

    @GetMapping("/shop/register/info")
    public ResponseEntity getShop (@CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        Store stores = storeRepository.findBySeq(seq);

        List<ShopRegister> reg = registerRepository.findByStoreid(stores.getId());

        return new ResponseEntity<>(reg, HttpStatus.OK);
    }

    @GetMapping("/shop/register/info/{seq}")
    public ResponseEntity getShops (@PathVariable("seq") int seq) {

        ShopRegister reg = registerRepository.findBySeq(seq);

        return new ResponseEntity<>(reg, HttpStatus.OK);
    }

    @PutMapping("/shop/register/update/{seq}")
    public ResponseEntity getStoreUpdate(@PathVariable("seq") int seq,
                                         @RequestBody Shop updateshop) {

        ShopRegister reg = registerRepository.findBySeq(seq);

        reg.setStorename(updateshop.getStorename());
        reg.setDetailinfo(updateshop.getDetailinfo());
        reg.setCategory(updateshop.getCategory());
        reg.setLocation(updateshop.getLocation());
        reg.setPhonenumber(updateshop.getPhonenumber());
        reg.setImage(updateshop.getImage());

        registerRepository.save(reg);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/shop/register/delete/{seq}")
    public ResponseEntity removeShop (@PathVariable("seq") int seq) {
        ShopRegister reg = registerRepository.findBySeq(seq);

        registerRepository.delete(reg);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
