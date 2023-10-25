package com.mission.mymission.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mission.mymission.entity.Shop;
import com.mission.mymission.entity.User;
import com.mission.mymission.service.AdminService;

@Controller
@RequiredArgsConstructor
@Transactional
@RequestMapping("/admin")
@Log4j2
public class AdminController {

    private final AdminService adminService;

    // 관리자 메인페이지
    @GetMapping("/main")
    public String admin_main(Model model) {
        return "/admin/main";
    }

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
        return "redirect:/admin/manageUser";
    }

    // 고객 상세정보 페이지
    @GetMapping("/manageUserInfo/{email}")
    public String manageUserInfo(@PathVariable String email, Model model) {
        User user = adminService.getUser(email);
        model.addAttribute("user", user);
        return "/admin/manageUserInfo";
    }

    // 식당(주인) 관리 페이지
    @GetMapping("/manageStore")
    public String manageStore(Model model) {
        adminService.getStoreList();
        model.addAttribute("stores", adminService.getStoreList());
        return "/admin/manageStore";
    }

    // 식당(주인) 삭제 메서드
    @GetMapping("/deleteStore/{seq}")
    public String deleteStore(@PathVariable Long seq) {
        adminService.deleteStore(seq);
        return "redirect:/admin/manageStore";
    }

    // 식당(가게) 관리 페이지
    @GetMapping("/manageShop")
    public String manageShop(Model model) {
        adminService.getShopList();
        model.addAttribute("shops", adminService.getShopList());
        return "/admin/manageShop";
    }

    // 식당(가게) 삭제 메서드
    @GetMapping("/deleteShop/{seq}")
    public String deleteShop(@PathVariable Long seq) {
        adminService.deleteShop(seq);
        return "redirect:/admin/manageShop";
    }

    // 식당(가게) 상세정보 페이지
    @GetMapping("/manageShopInfo/{seq}")
    public String manageShopInfo(@PathVariable Long seq, Model model) {
        Shop shop = adminService.getShop(seq);
        model.addAttribute("shop", shop);
        return "/admin/manageShopInfo";
    }

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

}
