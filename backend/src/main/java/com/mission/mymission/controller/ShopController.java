package com.mission.mymission.controller;

import com.mission.mymission.entity.Menu;
import com.mission.mymission.entity.Shop;
import com.mission.mymission.repository.MenuRepository;
import com.mission.mymission.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class ShopController {
    private final ShopRepository shopRepository;

    @GetMapping("/shop")
    public List<Shop> getShop() {
        List<Shop> shop = shopRepository.findAll();

        return shop;
    }
}
