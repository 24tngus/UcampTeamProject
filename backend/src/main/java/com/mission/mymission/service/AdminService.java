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
    void deleteShopRegister(Long seq);
    ShopRegister getShopRegister(Long seq);
    List<ShopRegister> getNewShopReqList();
    void permitNewShopReq(Long seq);
    void refusalNewShopReq(Long seq);
    List<ShopRegister> getrefusalShopList();



    // review service
    List<Review> getReviewList();
    void deleteReview(Long seq);
    List<Review> searchByWriter(String writer);
    List<Review> searchByShopSeq(Long shopseq);

//    List<Review> searchByStoreid(String storeid);
    List<Review> getRecentReviews();


    // main
    Long getUserCount();
    Long getStoreCount();
    Long getShopCount();

}
