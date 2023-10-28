package com.mission.mymission.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {
    @Autowired
    private JavaMailSender javaMailSender;

    // 고객, 판매자 용 메일
    public void sendMail(String email) { // 사용자 이메일을 매개변수로 추가
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

            // 1. 메일 수신자 설정 (사용자 이메일로 설정)
            String[] receiveArr = {email};
            messageHelper.setTo(receiveArr);

            // 2. 메일 제목 설정
            messageHelper.setSubject("VeganLoadMap Test Mail");

            // 3. 메일 내용 설정
            // HTML 적용됨
            String content =
                            "<h1>VeganLoadMap 계정 삭제 안내</h1>" +
                                    "<br><br>" +
                                    "회원님 안녕하세요?<br>" +
                                    "회원님의 계정이 오늘부로 VeganLoadMap에서 삭제처리 되었습니다.<br>" +
                                    "이용에 차질이 없도록 미리 메일로 안내드립니다.<br>" +
                                    "<br><br>" +
                                    "문의 사항이 있을 경우,<br>" +
                                    "다음 연락처로 연락주시면 감사하겠습니다.<br>" +
                                    "00-000-0000";
            messageHelper.setText(content, true);

            // 4. 메일 전송
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    // 식당 용 메일
    public void sendMailShop(String storeEmail) { // 사용자 이메일을 매개변수로 추가
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

            // 1. 메일 수신자 설정 (사용자 이메일로 설정)
            String[] receiveArr = {storeEmail};
            messageHelper.setTo(receiveArr);

            // 2. 메일 제목 설정
            messageHelper.setSubject("VeganLoadMap Test Mail");

            // 3. 메일 내용 설정
            // HTML 적용됨
            String content =
                    "<h1>VeganLoadMap 식당 삭제 안내</h1>" +
                            "<br><br>" +
                            "회원님 안녕하세요?<br>" +
                            "회원님의 식당이 오늘부로 VeganLoadMap에서 삭제처리 되었습니다.<br>" +
                            "이용에 차질이 없도록 미리 메일로 안내드립니다.<br>" +
                            "<br><br>" +
                            "문의 사항이 있을 경우,<br>" +
                            "다음 연락처로 연락주시면 감사하겠습니다.<br>" +
                            "00-000-0000";
            messageHelper.setText(content, true);

            // 4. 메일 전송
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
