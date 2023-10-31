package com.mission.mymission.controller;

import com.mission.mymission.entity.*;
import com.mission.mymission.repository.ReserveRepository;
import com.mission.mymission.repository.ReservesettingRepository;
import com.mission.mymission.repository.ShopRegisterRepository;
import com.mission.mymission.repository.StoreRepository;
import com.mission.mymission.service.JwtService;
import lombok.RequiredArgsConstructor;
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
    private final JwtService jwtService;
    private final StoreRepository storeRepository;
    private final ShopRegisterRepository shopRegisterRepository;
    private final ReserveRepository reserveRepository;
    private final ReservesettingRepository reservesettingRepository;

    // 판매자가 예약 등록한 리스트 반환
    @GetMapping("/reserve/set")
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

    @GetMapping("/reserve/shop/info/{seq}")
    public ResponseEntity getReserveUser (@PathVariable("seq") int seq) {
        Reserve reserve = reserveRepository.findBySeq(seq);

        return new ResponseEntity<>(reserve, HttpStatus.OK);
    }

    @DeleteMapping("/reserve/set/delete/{seq}")
    public ResponseEntity removeReserve (@PathVariable("seq") int seq) {
        Reserve reserve = reserveRepository.findBySeq(seq);

        reserveRepository.delete(reserve);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/reserve/set/update/{seq}")
    public void updateReserve(@PathVariable int seq, @RequestBody ReserveSetting updatedReserve) {
        reservesettingRepository.updateReservesetting(seq, updatedReserve.getTeam(), updatedReserve.getPeople(), updatedReserve.getDate(),
                updatedReserve.getTime0810(), updatedReserve.getTime1012(), updatedReserve.getTime1214(), updatedReserve.getTime1416(),
                updatedReserve.getTime1618(), updatedReserve.getTime1820(), updatedReserve.getTime2022());
    }

    @PostMapping("/reserve/set/insert")
    public ResponseEntity<ReserveSetting> insertReserve(@RequestBody ReserveSetting newReserve, @CookieValue(value = "token", required = false) String token) {
        if (!jwtService.isValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        int seq = jwtService.getSeq(token);
        Store stores = storeRepository.findBySeq(seq);

        String storeid = stores.getId();
        newReserve.setStoreid(storeid);
//        newReserve.setStoreid("example11");
        if (reservesettingRepository.existsByDetails(newReserve.getDate(), newReserve.getTime0810(), newReserve.getTime1012(), newReserve.getTime1214(), newReserve.getTime1416(), newReserve.getTime1618(), newReserve.getTime1820(), newReserve.getTime2022())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 이미 존재하는 경우 409 Conflict 반환
        }

        ReserveSetting savedReserve = reservesettingRepository.save(newReserve);
        return ResponseEntity.ok(savedReserve);
    }

    @GetMapping("/reservesetting/{date}")
    public List<ReserveSetting> getTime(@RequestParam String storename, @PathVariable Date date) {
        ShopRegister shopRegister = shopRegisterRepository.findByStorename(storename);
        String storeid = shopRegister.getStoreid();
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