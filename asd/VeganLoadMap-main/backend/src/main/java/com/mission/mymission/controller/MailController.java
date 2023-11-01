package com.mission.mymission.controller;

import com.mission.mymission.entity.User;
import com.mission.mymission.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MailController {
    @Autowired
    private JavaMailSender javaMailSender;
    private final UserRepository userRepository;

    @ResponseBody
    @PostMapping("/email")
    public Map email(String email){
        Map map = new HashMap();
        User user = userRepository.findByEmail(email);

        if(user != null){
            map.put("exist", "이미 존재하는 이메일입니다.");
        }else {
            Random random = new Random();
            String key = "";

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);

            for(int i=0; i<3; i++){
                int index = random.nextInt(26) + 65;
                key += (char) index;
            }
            for(int i=0; i<6; i++){
                int numIndex = random.nextInt(10);
                key += numIndex;
            }
            String mail = "\n Plantiful 회원가입 이메일 인증.";
            message.setSubject("회원가입을 위한 이메일 인증번호 메일입니다.");
            message.setText("인증번호는" + key + "입니다." + mail);

            try{
                javaMailSender.send(message);
            } catch(Exception e){
                e.printStackTrace();
            }
            map.put("key" , key);
            map.put("user", user);
        }
        return map;
    }
}
