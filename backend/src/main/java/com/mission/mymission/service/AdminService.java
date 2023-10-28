package com.mission.mymission.service;

import com.mission.mymission.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface AdminService {

    // User service
    List<User> getUserList();
    void deleteUser(String email);
    User getUser(String nickname);


    // store service
    List<Store> getStoreList();
    void deleteStore(String email);
    Store getStore(Long seq);


    // shop service
    List<ShopRegister> getShopRegisterList();
    void deleteShopRegister(String storename);
    ShopRegister getShopRegister(String storename);
    List<ShopRegister> getNewShopReqList();
    void permitNewShopReq(Long seq);
    void refusalNewShopReq(Long seq);
    List<ShopRegister> getrefusalShopList();



    // review service
    List<Review> getReviewList();
    void deleteReview(Long seq);
    List<Review> searchByWriter(String writer);
    List<Review> searchByStorename(String storename);
    List<Review> getRecentReviews();


    // main
    Long getUserCount();
    Long getStoreCount();
    Long getShopCount();
    Long getNewShopCount();

}
