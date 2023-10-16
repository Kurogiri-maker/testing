package com.example.demo;

import com.example.demo.Response;
import com.sun.mail.pop3.POP3Folder;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.pop3.EmailService.extractContent;

public class KeepAliveRunnable implements Runnable{
    private static final long KEEP_ALIVE_FREQ = 5000; // 5 minutes
    private POP3Folder folder;

    public KeepAliveRunnable(POP3Folder folder){
        this.folder = folder;
    }

    @Override
    public void run() {
        try {
            folder.open(Folder.READ_ONLY);
            while(!Thread.interrupted()){
                try {
                    System.out.println("Thread started");
                    Message[] messages = folder.getMessages();
                    List<Response> responses = new ArrayList<>();

                    for (Message message : messages) {
                        Response response = new Response(null,message.getFrom()[0].toString(),message.getSubject(), extractContent(message));
                        // Process each email message as needed
                        System.out.println("Subject: " + message.getSubject());
                        System.out.println("From: " + message.getFrom()[0]);
                        System.out.println("Description :"+ extractContent(message));
                        responses.add(response);
                    }
                    Thread.sleep(KEEP_ALIVE_FREQ);
                } catch (MessagingException | IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            folder.close(false);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
