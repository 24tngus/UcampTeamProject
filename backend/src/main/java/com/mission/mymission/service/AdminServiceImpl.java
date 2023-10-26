package com.mission.mymission.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mission.mymission.entity.Review;
import com.mission.mymission.entity.Shop;
import com.mission.mymission.entity.Store;
import com.mission.mymission.entity.User;
import com.mission.mymission.repository.ReviewRepository;
import com.mission.mymission.repository.ShopRepository;
import com.mission.mymission.repository.StoreRepository;
import com.mission.mymission.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ShopRepository shopRepository;
    private final ReviewRepository reviewRepository;


    // User service
    @Override
    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public void deleteUser(String nickname) {
        User user = userRepository.findByNickname(nickname);
        userRepository.delete(user);
    }

    @Override
    public User getUser(String nickname) {
        User user = userRepository.findByNickname(nickname);
        return user;
    }



    // store service
    @Override
    public List<Store> getStoreList() {
        List<Store> storeList = storeRepository.findAll();
        log.info(storeList);
        return storeList;
    }

    @Override
    public void deleteStore(Long seq) {
        Store store = storeRepository.findBySeq(seq);
        storeRepository.delete(store);
    }

    @Override
    public Store getStore(Long seq) {
        Store store = storeRepository.findBySeq(seq);
        return store;
    }



    // shop service
    @Override
    public List<Shop> getShopList() {
        List<Shop> shopList = shopRepository.findByPermit(1);
        return shopList;
    }

    @Override
    public void deleteShop(Long seq) {
        Shop shop = shopRepository.findBySeq(seq);
        shopRepository.delete(shop);
    }

    @Override
    public Shop getShop(Long seq) {
        Shop shop = shopRepository.findBySeq(seq);
        return shop;
    }

    @Override
    public List<Shop> getNewShopReqList() {
        List<Shop> shopList = shopRepository.findByPermit(0);
        return shopList;
    }

    @Override
    public void updateNewShopReq(Long seq) {
        Shop shop = shopRepository.findBySeq(seq);
        if (shop.getPermit() == 0) {
            shop.setPermit(1);
            shopRepository.save(shop);
        }
    }



    // review service
    @Override
    public List<Review> getReviewList() {
        List<Review> reviewList = reviewRepository.findAll();
        return reviewList;
    }

    @Override
    public void deleteReview(Long seq) {
        Review review = reviewRepository.findBySeq(seq);
        reviewRepository.delete(review);
    }

    @Override
    public List<Review> searchByWriter(String writer) {
        List<Review> reviewList = reviewRepository.findByWriterContaining(writer);
        return reviewList;
    }

    @Override
    public List<Review> searchByShopSeq(Long shopSeq) {
        List<Review> reviewList = reviewRepository.findByShopseq(shopSeq);
        return reviewList;
    }


}