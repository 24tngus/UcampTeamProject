package com.mission.mymission.controller;

import com.mission.mymission.entity.ReserveSetting;
import com.mission.mymission.entity.ShopRegister;
import com.mission.mymission.entity.Store;
import com.mission.mymission.repository.ReservesettingRepository;
import com.mission.mymission.repository.ShopRegisterRepository;
import com.mission.mymission.repository.StoreRepository;
import com.mission.mymission.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class ReservesettingController {
    @Autowired
    ReservesettingRepository reservesettingRepository;

    private final JwtService jwtService;
    private final StoreRepository storeRepository;
    private final ShopRegisterRepository registerRepository;

    @GetMapping("/reserve")
    public List<ReserveSetting> getReserve(){
        List<ReserveSetting> reserves = reservesettingRepository.findAll();

        return reserves;
    }
    @GetMapping("/reserve/shop")
    public List<ReserveSetting> getReserveShop(@CookieValue(value = "token", required = false) String token){
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        Store stores = storeRepository.findBySeq(seq);
        String storeid = stores.getId();

        List<ReserveSetting> reserves = reservesettingRepository.findByStoreid(storeid);

        return reserves;
    }
    @PutMapping("/reserve/update/{seq}")
    public void updateReserveSetting(@PathVariable int seq, @RequestBody ReserveSetting updatedReserve) {
        reservesettingRepository.updateReservesetting(seq, updatedReserve.getTeam(), updatedReserve.getPeople(), updatedReserve.getDate(),
                updatedReserve.getTime0810(), updatedReserve.getTime1012(), updatedReserve.getTime1214(), updatedReserve.getTime1416(),
                updatedReserve.getTime1618(), updatedReserve.getTime1820(), updatedReserve.getTime2022());
    }

    @PostMapping("/reserve/insert")
    public ResponseEntity<ReserveSetting> insertReserve(@RequestBody ReserveSetting newReserve, @CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        Store stores = storeRepository.findBySeq(seq);
        String storeid = stores.getId();
        // 추가
        newReserve.setStoreid(storeid);
        ReserveSetting savedReserve = reservesettingRepository.save(newReserve);
        return ResponseEntity.ok(savedReserve);
    }
    @GetMapping("/reverse/reserveuser/{storeid}/{date}")
    public List<ReserveSetting> getTime(@PathVariable String storeid, @PathVariable Date date) {
        List<ReserveSetting> result = reservesettingRepository.findByStoreidAndDate(storeid, date);
        System.out.println(storeid);
        System.out.println(date);

        int time0810Sum = 0;
        int time1012Sum = 0;
        int time1214Sum = 0;
        int time1416Sum = 0;
        int time1618Sum = 0;
        int time1820Sum = 0;
        int time2022Sum = 0;

        for (ReserveSetting reserve : result) {
            time0810Sum += reserve.getTime0810();
            time1012Sum += reserve.getTime1012();
            time1214Sum += reserve.getTime1214();
            time1416Sum += reserve.getTime1416();
            time1618Sum += reserve.getTime1618();
            time1820Sum += reserve.getTime1820();
            time2022Sum += reserve.getTime2022();
        }

        ReserveSetting sumReserve = new ReserveSetting();
        sumReserve.setTime0810(time0810Sum);
        sumReserve.setTime1012(time1012Sum);
        sumReserve.setTime1214(time1214Sum);
        sumReserve.setTime1416(time1416Sum);
        sumReserve.setTime1618(time1618Sum);
        sumReserve.setTime1820(time1820Sum);
        sumReserve.setTime2022(time2022Sum);

        System.out.println("time0810" + time0810Sum);
        System.out.println("time1012" + time1012Sum);
        System.out.println("time1214" + time1214Sum);
        System.out.println("time1416" + time1416Sum);
        System.out.println("time1618" + time1618Sum);
        System.out.println("time1820" + time1820Sum);
        System.out.println("time2022" + time2022Sum);


        List<ReserveSetting> sumResult = new ArrayList<>();
        sumResult.add(sumReserve);

        System.out.println("Sum of time0810: " + time0810Sum);
        System.out.println("Sum of time1012: " + time1012Sum);
        System.out.println("Sum of time1214: " + time1214Sum);
        System.out.println("Sum of time1416: " + time1416Sum);
        System.out.println("Sum of time1618: " + time1618Sum);
        System.out.println("Sum of time1820: " + time1820Sum);
        System.out.println("Sum of time2022: " + time2022Sum);

        System.out.println("Sum result: " + sumResult);
        return sumResult;
    }
}