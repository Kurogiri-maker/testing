package com.example.demo;

import com.example.demo.pop3.EmailService;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/pop")
@AllArgsConstructor
@Slf4j
public class EmailController {

    private ResponseRepository repository;

     private EmailService service;

    @GetMapping
    public List<Response> receiveEmail() throws MessagingException, IOException {
        return repository.findAll();
    }


}
