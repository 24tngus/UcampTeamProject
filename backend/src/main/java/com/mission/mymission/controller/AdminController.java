package com.mission.mymission.controller;

import com.mission.mymission.entity.*;
import com.mission.mymission.service.EmailSendService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.Banner;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.mission.mymission.service.AdminService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Transactional
@RequestMapping("/admin")
@Log4j2
public class AdminController {

    private final AdminService adminService;
    private final EmailSendService emailSendService;


    // 관리자 메인페이지
    @GetMapping("/main")
    public String admin_main(Model model) {
        // 고객 수
        Long userCount = adminService.getUserCount();
        model.addAttribute("userCount", userCount);

        // 판매자 수
        Long storeCount = adminService.getStoreCount();
        model.addAttribute("storeCount", storeCount);

        // 식당 수
        Long shopCount = adminService.getShopCount();
        model.addAttribute("shopCount", shopCount);

        // 요청 들어온 식당 수
        Long newShopCount = adminService.getNewShopCount();
        model.addAttribute("newShopCount", newShopCount);

        // 최근 댓글 5개까지 보여주기
        adminService.getRecentReviews();
        model.addAttribute("Review", adminService.getRecentReviews());

        return "/admin/main";
    }

    // 기타 페이지
    @GetMapping("/etc")
    public String admin_etc(Model model) {
        return "/admin/etc";
    }



    // User Controller
    // 고객 관리 페이지
    @GetMapping("/manageUser")
    public String manageUser(User user, BindingResult result, Model model) {
        adminService.getUserList();
        model.addAttribute("users", adminService.getUserList());
        return "/admin/manageUser";
    }

    // 고객 삭제 메서드
    @GetMapping("/deleteUser/{email}")
    public String deleteUser(@PathVariable String email) {
        adminService.deleteUser(email);
        emailSendService.sendMail(email);
        return "redirect:/admin/manageUser";
    }

    // 고객 상세정보 페이지
    @GetMapping("/manageUserInfo/{nickname}")
    public String manageUserInfo(@PathVariable String nickname, Model model) {
        User user = adminService.getUser(nickname);
        model.addAttribute("user", user);
        return "/admin/manageUserInfo";
    }



    // Store Controller
    // 판매자 관리 페이지
    @GetMapping("/manageStore")
    public String manageStore(Model model) {
        adminService.getStoreList();
        model.addAttribute("stores", adminService.getStoreList());
        return "/admin/manageStore";
    }

    // 판매자 삭제 메서드
    @GetMapping("/deleteStore/{email}")
    public String deleteStore(@PathVariable String email) {
        adminService.deleteStore(email);
        emailSendService.sendMail(email);
        return "redirect:/admin/manageStore";
    }

    // 판매자 상세정보 페이지
    @GetMapping("/manageStoreInfo/{seq}")
    public String manageStoreInfo(@PathVariable Long seq, Model model) {
        Store store = adminService.getStore(seq);
        model.addAttribute("store", store);
        return "admin/manageStoreInfo";
    }



    // Shop Controller
    // 식당 관리 페이지
    @GetMapping("/manageShop")
    public String manageShop(Model model) {
        adminService.getShopRegisterList();
        model.addAttribute("shopRegisters", adminService.getShopRegisterList());
        return "/admin/manageShop";
    }

    // 식당 삭제 메서드
    @GetMapping("/deleteShop/{storename}")
    public String deleteShop(@PathVariable String storename) {
        // 단계 1: 'storename'을 사용하여 'shop_register'에서 'storeid'를 가져옵니다.
        String storeid = adminService.getStoreIdByStoreName(storename);

        if (storeid != null) {
            // 단계 2: 'storeid'를 사용하여 store 테이블에서 이메일을 가져옵니다.
            String storeEmail = adminService.getStoreEmailById(storeid);

            if (storeEmail != null) {
                adminService.deleteShopRegister(storename);

                // 단계 3: 이메일을 보냅니다.
                emailSendService.sendMailShop(storeEmail);
            }
        }

        return "redirect:/admin/manageShop";
    }

    // 식당 상세정보 페이지
    @GetMapping("/manageShopInfo/{storename}")
    public String manageShopInfo(@PathVariable String storename, Model model) {
        ShopRegister shopRegister = adminService.getShopRegister(storename);
        model.addAttribute("shopRegister", shopRegister);
        return "/admin/manageShopInfo";
    }

    // 신규 식당 요청 관리 페이지
    @GetMapping("/manageNewShopReq")
    public String manageNewShopReq(Model model) {
        adminService.getNewShopReqList();
        model.addAttribute("shopRegisters", adminService.getNewShopReqList());
        return "/admin/manageNewShopReq";
    }

    // 신규 식당 요청 상세정보 페이지
    @GetMapping("/manageNewShopReqInfo/{storename}")
    public String manageNewShopReqInfo(@PathVariable String storename, Model model) {
        ShopRegister shopRegister = adminService.getShopRegister(storename);
        model.addAttribute("shopRegister", shopRegister);
        return "/admin/manageNewShopReqInfo";
    }

    // 신규 식당 요청 승인 메서드
    @GetMapping("/permitNewShopReq/{seq}")
    public String permitNewShopReq(@PathVariable Long seq) {
        adminService.permitNewShopReq(seq);
        return "redirect:/admin/manageShop";
    }

    // 신규 식당 요청 거부 메서드
    @GetMapping("/refusalNewShopReq/{seq}")
    public String refusalNewShopReq(@PathVariable Long seq) {
        adminService.refusalNewShopReq(seq);
        return "redirect:/admin/manageRefusalShop";
    }

    // 요청 거부된 식당 관리 페이지
    @GetMapping("/manageRefusalShop")
    public String manageRefusalShop(Model model) {
        adminService.getrefusalShopList();
        model.addAttribute("shopRegisters", adminService.getrefusalShopList());
        return "/admin/manageRefusalShop";
    }

    // 요청 거부된 식당 삭제 메서드
    @GetMapping("/deleteRefusalShop/{storename}")
    public String deleteNewShopReq(@PathVariable String storename) {
        adminService.deleteShopRegister(storename);
        return "redirect:/admin/manageRefusalShop";
    }

    // 요청 거부된 식당 요청 상세정보 페이지
    @GetMapping("/manageRefusalShopInfo/{storename}")
    public String manageRefusalShopInfo(@PathVariable String storename, Model model) {
        ShopRegister shopRegister = adminService.getShopRegister(storename);
        model.addAttribute("shopRegister", shopRegister);
        return "/admin/manageRefusalShopInfo";
    }



    // Review Controller
    // 리뷰 관리 페이지
    @GetMapping("/manageReview")
    public String manageReview(Model model) {
        adminService.getReviewList();
        model.addAttribute("reviews", adminService.getReviewList());
        return "/admin/manageReview";
    }

    // 리뷰 삭제 메서드
    @GetMapping("/deleteReview/{seq}")
    public String deleteReview(@PathVariable Long seq) {
        adminService.deleteReview(seq);
        return "redirect:/admin/manageReview";
    }

    // 검색 필터
    @GetMapping("/searchReview")
    public String search(@RequestParam String keyword, @RequestParam int filter, Model model) {
        List<Review> searchList = new ArrayList<>();

        if (filter == 2) {
            // 작성자 검색
            searchList = adminService.searchByWriter(keyword);
        } else if (filter == 1) {
            // 식당 이름(storename)으로 검색
            try {
                String storename = String.valueOf(keyword);
                searchList = adminService.searchByStorename(storename);
            } catch (NumberFormatException e) {

            }
        }

        model.addAttribute("searchList", searchList);
        return "admin/manageReview";
    }

}
