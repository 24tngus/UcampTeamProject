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

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

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
        Collections.reverse(userList);
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
        Collections.reverse(storeList);
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
        Collections.reverse(shopList);
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
        Collections.reverse(shopList);
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
        Collections.reverse(shopList);
        return shopList;
    }




    // review service
    // 후기 전체 목록 조회
    @Override
    public List<Review> getReviewList() {
        List<Review> reviewList = reviewRepository.findAll();
        Collections.reverse(reviewList);
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
        Collections.reverse(reviewList);
        return reviewList;
    }

    // 식당 검색
    @Override
    public List<Review> searchByShopSeq(Long shopSeq) {
        List<Review> reviewList = reviewRepository.findByShopseq(shopSeq);
        Collections.reverse(reviewList);
        return reviewList;
    }




    // 메인 페이지 꾸미기
    // 고객 수
    @Override
    public Long getUserCount() {
        return userRepository.count();
    }

    // 판매자 수
    @Override
    public Long getStoreCount() {
        return storeRepository.count();
    }

    // 승인 된 식당 수
    @Override
    public Long getShopCount() {
        Long permitShopCount = shopRepository.countByPermit(1);
        return permitShopCount;
    }

    // 최근 댓글 5개까지 보여주기
    @Override
    public List<Review> getRecentReviews() {
        return reviewRepository.findTop5ByOrderBySeqDesc();
    }

}
