package com.mission.mymission.controller;

import com.mission.mymission.entity.Payment;
import com.mission.mymission.repository.PaymentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api")
public class PaymentController {
    private final PaymentRepository paymentRepository;

    private static final String IMP_KEY = "5516260652634065";
    private static final String IMP_SECRET = "VgpN11zDwgsgvluyTtDHddN1gjYTUd8gTpBy7v8NZrtVXLiIfGBoxLs4uubugfjL59c54Xed5nUBfxSB";
    private static final String API_URL = "https://api.iamport.kr";
    private static final String API_URL_GET_TOKEN = API_URL + "/users/getToken";

    private static String access_token;


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

    @GetMapping("/payment/seq/{seq}")
    public Payment findPaymentBySeq(@PathVariable int seq) {
        Payment payment = paymentRepository.findBySeq(seq);

        return payment;
    }


    @PostMapping("/payment")
    public Payment insertPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    public String getPaymentToken(){
        String token = "";
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(API_URL_GET_TOKEN);

            JSONObject json = new JSONObject();
            json.put("imp_key", IMP_KEY);
            json.put("imp_secret", IMP_SECRET);

            String jsonPayload = json.toString();

            StringEntity entity = new StringEntity(jsonPayload);
            entity.setContentType("application/json");
            post.setEntity(entity);

            HttpResponse response = client.execute(post);

            if(response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);
                System.out.println("body => " + body);

                // JSON 파싱
                JSONObject jsonResponse = new JSONObject(body);
                JSONObject responseObj = jsonResponse.getJSONObject("response");
                String accessToken = responseObj.getString("access_token");

                System.out.println("access_token => " + accessToken);
                token = accessToken;
            } else {
                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
                System.out.println(response.toString());
                System.out.println(response.getEntity());
            }

        } catch (Exception e){
            System.err.println(e.toString());
            System.out.println(e.toString());
        }

        return token;
    }

    @PostConstruct
    public void initialize() {
        access_token = getPaymentToken();
        System.out.println("initialize access_token => " + access_token);
    }

//    @PostMapping("/payment/cancel")
//    public Payment cancelPayment(@RequestBody Payment payment) {
//        Payment payment = paymentRepository.findBypaymentid(paymentid);
//        // 환불 처리
//        return payment;
//    }


}