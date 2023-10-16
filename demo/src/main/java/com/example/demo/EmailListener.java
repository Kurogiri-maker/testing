package com.example.demo;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.event.MessageCountAdapter;
import jakarta.mail.event.MessageCountEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.pop3.EmailService.extractContent;


public class EmailListener extends MessageCountAdapter {

    @Override
    public void messagesAdded(MessageCountEvent event){
        List<Response> responses = new ArrayList<>();
        System.out.println("New messages added");
        try {
            Message[] messages = event.getMessages();
            for (Message message : messages) {
                Response response = new Response(null,message.getFrom()[0].toString(),message.getSubject(), extractContent(message));
                responses.add(response);
            }
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(responses);
    }
}
