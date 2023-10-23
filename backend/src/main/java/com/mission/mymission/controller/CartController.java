package com.mission.mymission.controller;

import com.mission.mymission.entity.Cart;
import com.mission.mymission.entity.Menu;
import com.mission.mymission.repository.CartRepository;
import com.mission.mymission.repository.MenuRepository;
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
    private final MenuRepository menuRepository;

    @GetMapping("/cart/menu")
    public ResponseEntity getCartMenu(@CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        int userSeq = jwtService.getSeq(token);
        List<Cart> carts = cartRepository.findByUserSeq(userSeq);
        List<Integer> menuIds = carts.stream().map(Cart::getMenuSeq).toList();
        List<Menu> menus = menuRepository.findBySeqIn(menuIds);

        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @PostMapping("/cart/menu/{menuSeq}")
    public ResponseEntity pushCartMenu(
            @PathVariable("menuSeq") int menuSeq,
            @CookieValue(value="token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        int userSeq = jwtService.getSeq(token);
        Cart cart = cartRepository.findByUserSeqAndMenuSeq(userSeq, menuSeq);

        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setUserSeq(userSeq);
            newCart.setMenuSeq(menuSeq);
            cartRepository.save(newCart);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cart/menu/{menuSeq}")
    public ResponseEntity removeCartMenu(
            @PathVariable("menuSeq") int menuSeq,
            @CookieValue(value = "token", required = false) String token) {

        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        int userSeq = jwtService.getSeq(token);
        Cart cart = cartRepository.findByUserSeqAndMenuSeq(userSeq, menuSeq);

        cartRepository.delete(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
