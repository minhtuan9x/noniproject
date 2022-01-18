package com.nonicafe.config;

import com.nonicafe.constant.MailConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);

        javaMailSender.setUsername(MailConstant.MY_EMAIL);
        javaMailSender.setPassword(MailConstant.MY_PASSWORD);

        javaMailSender.setDefaultEncoding("UTF-8");

        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return javaMailSender;
    }

    @Bean
    public SimpleMailMessage simpleMailMessage(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(MailConstant.CLIENT_EMAIL);
        return simpleMailMessage;
    }
}
