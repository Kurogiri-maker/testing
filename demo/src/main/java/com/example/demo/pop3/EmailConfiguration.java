package com.example.demo.pop3;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@AllArgsConstructor
public class EmailConfiguration {

    private EmailService service;

    @Scheduled(cron = "* * * * *  *")
    public void run() throws Exception {
//        System.out.println("I started working");
        service.receiveEmail();
    }
}
