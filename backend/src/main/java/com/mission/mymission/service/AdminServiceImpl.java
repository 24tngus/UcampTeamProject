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
    // 고객 전체 목록 조회
    @Override
    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    // 고객 삭제
    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmail(email);
        userRepository.delete(user);
    }

    // 고객 개별 조회
    @Override
    public User getUser(String nickname) {
        User user = userRepository.findByNickname(nickname);
        return user;
    }



    // store service
    // 판매자 전체 목록 조회
    @Override
    public List<Store> getStoreList() {
        List<Store> storeList = storeRepository.findAll();
        log.info(storeList);
        return storeList;
    }

    // 판매자 삭제
    @Override
    public void deleteStore(Long seq) {
        Store store = storeRepository.findBySeq(seq);
        storeRepository.delete(store);
    }

    // 판매자 개별 조회
    @Override
    public Store getStore(Long seq) {
        Store store = storeRepository.findBySeq(seq);
        return store;
    }



    // shop service
    // 식당 전체 목록 조회
    @Override
    public List<Shop> getShopList() {
        List<Shop> shopList = shopRepository.findByPermit(1);
        return shopList;
    }

    // 식당 삭제
    @Override
    public void deleteShop(Long seq) {
        Shop shop = shopRepository.findBySeq(seq);
        shopRepository.delete(shop);
    }

    // 식당 개별 조회
    @Override
    public Shop getShop(Long seq) {
        Shop shop = shopRepository.findBySeq(seq);
        return shop;
    }

    // 신규 식당 전체 목록
    @Override
    public List<Shop> getNewShopReqList() {
        List<Shop> shopList = shopRepository.findByPermit(0);
        return shopList;
    }

    // 신규 식당 요청 승인
    @Override
    public void permitNewShopReq(Long seq) {
        Shop shop = shopRepository.findBySeq(seq);
        if (shop.getPermit() == 0) {
            shop.setPermit(1);
            shopRepository.save(shop);
        }
    }

    // 신규 식당 요청 거부
    @Override
    public void refusalNewShopReq(Long seq) {
        Shop shop = shopRepository.findBySeq(seq);
        if (shop.getPermit() == 0) {
            shop.setPermit(2);
            shopRepository.save(shop);
        }
    }

    // 요청 거부된 식당 목록 조회
    @Override
    public List<Shop> getrefusalShopList() {
        List<Shop> shopList = shopRepository.findByPermit(2);
        return shopList;
    }




    // review service
    // 후기 전체 목록 조회
    @Override
    public List<Review> getReviewList() {
        List<Review> reviewList = reviewRepository.findAll();
        return reviewList;
    }

    // 후기 삭제
    @Override
    public void deleteReview(Long seq) {
        Review review = reviewRepository.findBySeq(seq);
        reviewRepository.delete(review);
    }

    // 작성자 검색
    @Override
    public List<Review> searchByWriter(String writer) {
        List<Review> reviewList = reviewRepository.findByWriterContaining(writer);
        return reviewList;
    }

    // 식당 검색
    @Override
    public List<Review> searchByShopSeq(Long shopSeq) {
        List<Review> reviewList = reviewRepository.findByShopseq(shopSeq);
        return reviewList;
    }


}
