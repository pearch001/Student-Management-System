package com.SMS.SMSapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class JavaMailSender {
    @Bean
    public JavaMailSender javaMailSender(){
        return new JavaMailSender();
    }
}
