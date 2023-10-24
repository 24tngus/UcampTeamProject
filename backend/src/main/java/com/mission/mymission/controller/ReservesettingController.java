package com.mission.mymission.controller;

import com.mission.mymission.entity.Reserve;
import com.mission.mymission.entity.Reservesetting;
import com.mission.mymission.repository.ReservesettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReservesettingController {
    @Autowired
    ReservesettingRepository reservesettingRepository;

    @GetMapping("/api/reservetest")
    public List<Reservesetting> getReserve(){
        List<Reservesetting> reserves = reservesettingRepository.findAll();

        return reserves;
    }
    @PutMapping("/api/reservetest/update/{seq}")
    public void updateReserveSetting(@PathVariable int seq, @RequestBody Reservesetting updatedReserve) {
        reservesettingRepository.updateReservesetting(seq, updatedReserve.getTeam(), updatedReserve.getPeople(), updatedReserve.getDate(),
                updatedReserve.getTime0810(), updatedReserve.getTime1012(), updatedReserve.getTime1214(), updatedReserve.getTime1416(),
                updatedReserve.getTime1618(), updatedReserve.getTime1820(), updatedReserve.getTime2022());
    }

    @PostMapping("/api/reservetest/insert")
    public ResponseEntity<Reservesetting> insertReserve(@RequestBody Reservesetting newReserve) {
        newReserve.setShopseq(2);
        Reservesetting savedReserve = reservesettingRepository.save(newReserve);
        return ResponseEntity.ok(savedReserve);
    }
    @GetMapping("/api/reversetest/reserveuser/{shopseq}/{date}")
    public List<Reservesetting> getTime(@PathVariable int shopseq, @PathVariable Date date) {
        List<Reservesetting> result = reservesettingRepository.findByShopseqAndDate(shopseq, date);
        System.out.println(shopseq);
        System.out.println(date);

        int time0810Sum = 0;
        int time1012Sum = 0;
        int time1214Sum = 0;
        int time1416Sum = 0;
        int time1618Sum = 0;
        int time1820Sum = 0;
        int time2022Sum = 0;

        for (Reservesetting reserve : result) {
            time0810Sum += reserve.getTime0810();
            time1012Sum += reserve.getTime1012();
            time1214Sum += reserve.getTime1214();
            time1416Sum += reserve.getTime1416();
            time1618Sum += reserve.getTime1618();
            time1820Sum += reserve.getTime1820();
            time2022Sum += reserve.getTime2022();
        }

        Reservesetting sumReserve = new Reservesetting();
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


        List<Reservesetting> sumResult = new ArrayList<>();
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