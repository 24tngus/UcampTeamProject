package com.mission.mymission.controller;

import com.mission.mymission.entity.Menu;
import com.mission.mymission.entity.Shop;
import com.mission.mymission.repository.MenuRepository;
import com.mission.mymission.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Menu> getMenuByshopseq(@PathVariable("shopseq") int shopseq) {
        List<Menu> menuList = menuRepository.findByshopseq(shopseq);
        System.out.println("getMenuByShopSeq => " + menuList);

        return menuList;
    }

    @RequestMapping("/menu/shop/{seq}")
    public Shop getMenuBySeq(@PathVariable("seq") int seq) {
        Shop shop = shopRepository.findBySeq(seq);

        return shop;
    }

}