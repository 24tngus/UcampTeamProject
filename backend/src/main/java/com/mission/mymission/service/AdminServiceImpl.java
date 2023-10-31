package com.mission.mymission.service;

import com.mission.mymission.entity.*;
import com.mission.mymission.repository.*;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final ShopRegisterRepository ShopRegisterRepository;
    private final ReviewRepository reviewRepository;
    private final ShopRegisterDeletionService scheduleShopRegisterDeletion;

    @PersistenceContext
    private EntityManager entityManager;


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
    public void deleteStore(String email) {
        Store store = storeRepository.findByEmail(email);
        storeRepository.delete(store);
    }

    // 판매자 개별 조회
    @Override
    public Store getStore(Long seq) {
        Store store = storeRepository.findBySeq(seq);
        return store;
    }



    // shop service
    @Override
    public List<Shop> getShopList() {
        List<Shop> shopList = shopRepository.findAll();
        Collections.reverse(shopList);
        return shopList;
    }

    @Override
    public void deleteShop(String storename) {
        Shop shop = shopRepository.findByStorename(storename);
        shopRepository.delete(shop);
    }

    @Override
    public Shop getShop(String storename) {
        Shop shop = shopRepository.findByStorename(storename);
        return shop;
    }

    @Override
    public List<Shop> getDuplicateShop() {
        String jpql = "SELECT s FROM Shop s WHERE s.storename IN " +
                "(SELECT s2.storename FROM Shop s2 GROUP BY s2.storename HAVING COUNT(s2.storename) > 1)";
        TypedQuery<Shop> query = entityManager.createQuery(jpql, Shop.class);
        return query.getResultList();
    }

    @Override
    public void deleteDuplicateShop(long seq) {
        Shop shop = shopRepository.findBySeq(seq);
        shopRepository.delete(shop);
    }

    @Override
    public List<Shop> searchShopByStorename(String storename) {
        List<Shop> shopList = shopRepository.searchByStorename(storename);
        Collections.reverse(shopList);
        return shopList;
    }




    // shop_register service
    // 식당 전체 목록 조회
    @Override
    public List<ShopRegister> getShopRegisterList() {
        List<ShopRegister> shopRegisterListList = ShopRegisterRepository.findByPermit(1);
        Collections.reverse(shopRegisterListList);
        return shopRegisterListList;
    }

    // 식당 삭제
    @Override
    public void deleteShopRegister(String storename) {
        ShopRegister shopRegister = ShopRegisterRepository.findByStorename(storename);
        ShopRegisterRepository.delete(shopRegister);
    }

    // storename으로 storeid 찾기
    @Transactional
    public String getStoreIdByStoreName(String storename) {
        String query = "SELECT sr.storeid FROM ShopRegister sr WHERE sr.storename = :storename";
        List<String> results = entityManager.createQuery(query, String.class)
                .setParameter("storename", storename)
                .getResultList();

        String storeId = results.get(0);
        System.out.println("Found storeId: " + storeId);
        return storeId;
    }

    // storeid로 store의 email 찾기
    @Transactional
    public String getStoreEmailById(String storeid) {
        String query = "SELECT s.email FROM Store s WHERE s.id = :storeid";
        List<String> results = entityManager.createQuery(query, String.class)
                .setParameter("storeid", storeid)
                .getResultList();

        String storeEmail = results.get(0);
        System.out.println("Store email: " + storeEmail);
        return storeEmail;
    }

    // 식당 개별 조회
    @Override
    public ShopRegister getShopRegister(String storename) {
        ShopRegister shopRegister = ShopRegisterRepository.findByStorename(storename);
        return shopRegister;
    }

    // 신규 식당 전체 목록
    @Override
    public List<ShopRegister> getNewShopReqList() {
        List<ShopRegister> shopRegisterList = ShopRegisterRepository.findByPermit(0);
        Collections.reverse(shopRegisterList);
        return shopRegisterList;
    }

    // 신규 식당 요청 승인
    @Override
    public void permitNewShopReq(Long seq) {
        ShopRegister shopRegister = ShopRegisterRepository.findBySeq(seq);
        if (shopRegister.getPermit() == 0) {
            shopRegister.setPermit(1);
            ShopRegisterRepository.save(shopRegister);
        }
    }

    // 신규 식당 요청 거부
    @Override
    public void refusalNewShopReq(Long seq) {
        ShopRegister shopRegister = ShopRegisterRepository.findBySeq(seq);
        if (shopRegister.getPermit() == 0) {
            shopRegister.setPermit(2);

            shopRegister.setPermitUpdateTime(LocalDateTime.now());

            ShopRegisterRepository.save(shopRegister);
            scheduleShopRegisterDeletion.scheduleShopRegisterDeletion();
        }
    }

    // 요청 거부된 식당 목록 조회
    @Override
    public List<ShopRegister> getrefusalShopList() {
        List<ShopRegister> shopRegisterList = ShopRegisterRepository.findByPermit(2);
        Collections.reverse(shopRegisterList);
        return shopRegisterList;
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
    public List<Review> searchByStorename(String storename) {
        List<Review> reviewList = reviewRepository.searchByStorename(storename);
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
        Long permitShopCount = ShopRegisterRepository.countByPermit(1);
        return permitShopCount;
    }

    // 요청 들어온 식당 수
    @Override
    public Long getNewShopCount() {
        Long permitShopCount = ShopRegisterRepository.countByPermit(0);
        return permitShopCount;
    }

    // 최근 댓글 5개까지 보여주기
    @Override
    public List<Review> getRecentReviews() {
        return reviewRepository.findTop5ByOrderBySeqDesc();
    }

}
