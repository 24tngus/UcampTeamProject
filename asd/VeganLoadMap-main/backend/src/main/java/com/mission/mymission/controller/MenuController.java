package com.mission.mymission.controller;

import com.mission.mymission.entity.Menu;
import com.mission.mymission.entity.Shop;
import com.mission.mymission.repository.MenuRepository;
import com.mission.mymission.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class MenuController {
    @Autowired
    private final MenuRepository menuRepository;
    private final ShopRepository shopRepository;

    @GetMapping("/menu")
    public List<Menu> getMenu() {
        List<Menu> menu = menuRepository.findAll();

        return menu;
    }

    @RequestMapping("/menu/{shopseq}")
    public List<Menu> getMenuByShopSeq(@PathVariable int shopseq) {
        List<Menu> menuList = menuRepository.findByshopseq(shopseq);
        System.out.println("getMenuByShopSeq => " + menuList);
        System.out.println("호출되는지 확인");
        System.out.println();
        System.out.println();

        return menuList;
    }


    @RequestMapping("/menu/shop/{seq}")
    public Shop getMenuBySeq(@PathVariable("seq") int seq) {
        Shop shop = shopRepository.findBySeq(seq);

        return shop;
    }

}