package com.mission.mymission.controller;

import com.mission.mymission.entity.Menu;
import com.mission.mymission.entity.Shop;
import com.mission.mymission.entity.ShopRegister;
import com.mission.mymission.entity.Store;
import com.mission.mymission.repository.MenuRepository;
import com.mission.mymission.repository.ShopRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MenuController {
    private final MenuRepository menuRepository;
    private final ShopRepository shopRepository;

    @GetMapping("/menu")
    public List<Menu> getMenu() {
        List<Menu> menu = menuRepository.findAll();

        return menu;
    }

    @GetMapping("/menu/{shopseq}")
    public List<Menu> getMenuByShopSeq(@PathVariable int shopseq) {
        List<Menu> menuList = menuRepository.findByshopseq(shopseq);

        return menuList;
    }

    @GetMapping("/menu/shop/{seq}")
    public Shop getMenuBySeq(@PathVariable("seq") int seq) {
        Shop shop = shopRepository.findBySeq(seq);

        return shop;
    }

    @PostMapping("/api/menu/register")
    public ResponseEntity MenuRegister(@RequestBody Map<String, String> params, HttpServletResponse res) {

        Menu menu = new Menu();

        menu.setShopseq(Integer.parseInt(params.get("shopseq")));
        menu.setMenu(params.get("menu"));
        menu.setInfo(params.get("info"));
        menu.setPrice(Integer.parseInt(params.get("price")));
        menu.setImage(params.get("image"));
        menu.setSale(Integer.parseInt(params.get("sale")));

        menuRepository.save(menu);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}