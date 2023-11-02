package com.mission.mymission.controller;

import com.mission.mymission.entity.Shop;
import com.mission.mymission.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/shop/korean")
    public List<Shop> getKorean() {
        List<Shop> shop1 = shopRepository.findByCategory("한식");
        System.out.println("한식 카테고리 테스트" + shop1);
        return shop1;
    }
    @GetMapping("/shop/western")
    public List<Shop> getWestern() {
        List<Shop> shop1 = shopRepository.findByCategory("양식");
        System.out.println("양식 카테고리 테스트" + shop1);
        return shop1;
    }
    @GetMapping("/shop/fusion")
    public List<Shop> getFusion() {
        List<Shop> shop1 = shopRepository.findByCategory("퓨전");
        System.out.println("퓨전 카테고리 테스트" + shop1);
        return shop1;
    }

    @PostMapping("/map")
    public Shop postMap(@RequestBody Shop shop) {
        return shopRepository.save(shop);
    }

    @GetMapping("/map")
    public Shop getBylatlng(@RequestParam String lat, @RequestParam String lng) {
        Shop shop = shopRepository.findByLatAndLng(lat, lng);
        System.out.println("getBylatlng => " + shop.toString());
        return shop;
    }
//
//    @GetMapping("/shop/storeInfo")
//    public Shop storeInfo(int seq){
//        Shop shop = shopRepository.findBySeq(seq);
//
//        return shop;
//    }

}