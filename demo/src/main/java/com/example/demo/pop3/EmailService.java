package com.example.demo.pop3;

import com.example.demo.ResponseRepository;
import com.sun.mail.pop3.POP3Folder;
import jakarta.mail.*;
import org.springframework.stereotype.Service;


import java.io.*;

import java.util.Properties;

@Service
public class EmailService {


    private ResponseRepository repository;

    private PartnerRepository partnerRepository;

    public EmailService(ResponseRepository repository, PartnerRepository partnerRepository){
        this.repository = repository;
        this.partnerRepository = partnerRepository;
    }


    public void receiveEmail() throws Exception {

        Properties props = new Properties();
        props.setProperty("mail.store.protocol","pop3s");
        props.setProperty("mail.pop3s.host","pop.gmail.com");
        props.setProperty("mail.pop3s.port","995");
        props.setProperty("mail.pop3.starttls.enable","true");

        Session session = Session.getDefaultInstance(props);
//        session.setDebug(true);

        Store store = session.getStore("pop3s");
        store.connect("popservertest6@gmail.com","kottqiahbwiaotlr");

        POP3Folder inbox = (POP3Folder) store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        Message[] messages = inbox.getMessages();

        for (Message message : messages) {
            InputStream is = extractAttachements(message);
            if(is != null){
                // Process each email message as needed
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Attachement :"+ partnerRepository.save(FileReaderService.processPDFAsCSV(is)));
            }
        }
        inbox.close(false);
        store.close();
    }


    public static InputStream extractAttachements(Part part) throws MessagingException, IOException {

        Multipart multipart = (Multipart) part.getContent();;
        for(int i=0;i< multipart.getCount();i++){
            BodyPart bodyPart = multipart.getBodyPart(i);

            String filename = bodyPart.getFileName();
            if(filename != null){
                return bodyPart.getDataHandler().getInputStream();
            }
        }
        return null;
    }


    public static void saveFileToDirectory(BodyPart bodyPart, String filename){
       File outputFile = new File(filename);
        try(
                FileOutputStream fos = new FileOutputStream(outputFile)) {
             bodyPart.getDataHandler().writeTo(fos);
//            System.out.println("Saved attachement : "+ filename);
        } catch (IOException | MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String extractContent(Part part) throws MessagingException, IOException {
        Object content = part.getContent();
        if( content instanceof String){
            return (String) content;
        } else if(content instanceof Multipart){
            Multipart multipart = (Multipart) content;
            for(int i=0;i< multipart.getCount();i++){
                BodyPart bodyPart = multipart.getBodyPart(i);
                return extractContent(bodyPart);
            }
        }
        return "";
    }




}
