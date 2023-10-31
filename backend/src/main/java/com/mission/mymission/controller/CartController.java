package com.mission.mymission.controller;

import com.mission.mymission.entity.Cart;
import com.mission.mymission.entity.Shop;
import com.mission.mymission.repository.CartRepository;
import com.mission.mymission.repository.ShopRepository;
import com.mission.mymission.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CartController {
    private final JwtService jwtService;
    private final CartRepository cartRepository;
    private final ShopRepository shopRepository;

    @GetMapping("/cart/shop")
    public ResponseEntity getCartShop(@CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        int userSeq = jwtService.getSeq(token);
        List<Cart> carts = cartRepository.findByUserSeq(userSeq);
        List<Integer> shopIds = carts.stream().map(Cart::getShopSeq).toList();
        List<Shop> shops = shopRepository.findBySeqIn(shopIds);

        return new ResponseEntity<>(shops, HttpStatus.OK);
    }

    @PostMapping("/cart/insert/{shopSeq}")
    public ResponseEntity pushCartShop(
            @PathVariable("shopSeq") int shopSeq,
            @CookieValue(value="token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        int userSeq = jwtService.getSeq(token);
        Cart cart = cartRepository.findByUserSeqAndShopSeq(userSeq, shopSeq);

        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setUserSeq(userSeq);
            newCart.setShopSeq(shopSeq);
            cartRepository.save(newCart);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/cart/delete/{shopSeq}")
    public ResponseEntity removeCartShop(
            @PathVariable("shopSeq") int shopSeq,
            @CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        int userSeq = jwtService.getSeq(token);
        Cart cart = cartRepository.findByUserSeqAndShopSeq(userSeq, shopSeq);

        cartRepository.delete(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
