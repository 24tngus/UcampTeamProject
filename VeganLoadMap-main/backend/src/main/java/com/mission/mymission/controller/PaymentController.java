package com.mission.mymission.controller;

import com.mission.mymission.entity.Payment;
import com.mission.mymission.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class PaymentController {
    private final PaymentRepository paymentRepository;

    @GetMapping("/payment")
    public List<Payment> findPaymentList() {
        List<Payment> paymentList = paymentRepository.findAll();
        System.out.println("getPaymentList() => " + paymentList);

        return paymentList;
    }

    @GetMapping("/paymentSuccess/{paymentid}")
    public Payment findPaymentByPaymentId(@PathVariable String paymentid) {
        Payment payment = paymentRepository.findBypaymentid(paymentid);
        System.out.println("Back paymentId => " + paymentid);
        System.out.println("Back payment => " + payment);

        return payment;
    }

    @PostMapping("/payment")
    public Payment insertPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }


}
