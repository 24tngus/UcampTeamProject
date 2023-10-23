package com.mission.mymission.controller;

import com.mission.mymission.entity.Menu;
import com.mission.mymission.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class MenuController {
    private final MenuRepository menuRepository;

    @GetMapping("/menu")
    public List<Menu> getMenu() {
        List<Menu> menu = menuRepository.findAll();

        return menu;
    }
}
