package com.mission.mymission.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mission.mymission.entity.Review;
import com.mission.mymission.entity.Shop;
import com.mission.mymission.entity.Store;
import com.mission.mymission.entity.User;

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
    void deleteStore(Long seq);
    Store getStore(Long seq);


    // shop service
    List<Shop> getShopList();
    void deleteShop(Long seq);
    Shop getShop(Long seq);
    List<Shop> getNewShopReqList();
    void updateNewShopReq(Long seq);



    // review service
    List<Review> getReviewList();
    void deleteReview(Long seq);
    List<Review> searchByWriter(String writer);
    List<Review> searchByShopSeq(Long shopSeq);
}