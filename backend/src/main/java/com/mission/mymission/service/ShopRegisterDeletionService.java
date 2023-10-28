package com.mission.mymission.service;

import com.mission.mymission.entity.ShopRegister;
import com.mission.mymission.repository.ShopRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShopRegisterDeletionService {

    @Autowired
    private ShopRegisterRepository shopRegisterRepository;

    public void scheduleShopRegisterDeletion() {
        LocalDateTime currentTime = LocalDateTime.now();
        List<ShopRegister> shopRegisters = shopRegisterRepository.findByPermit(2);
        for (ShopRegister shopRegister : shopRegisters) {
            LocalDateTime updateTime = shopRegister.getPermitUpdateTime();
            if (updateTime != null) {
                LocalDateTime deleteTime = updateTime.plusDays(1); // 일주일 뒤에 삭제
                if (currentTime.isAfter(deleteTime)) {
                    shopRegisterRepository.delete(shopRegister);
                }
            }
        }
    }
}