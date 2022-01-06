package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.constant.MailConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailAPI {
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping
    public void sendMailTest(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(MailConstant.CLIENT_EMAIL);
        simpleMailMessage.setSubject("Test gui mail");
        simpleMailMessage.setText("Do Minh Tuan");

        javaMailSender.send(simpleMailMessage);
    }
}
