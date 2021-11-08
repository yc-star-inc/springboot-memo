package com.tsmc.ecp.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailClient {
 
    private JavaMailSender mailSender;
 
    @Autowired
    public MailClient(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    @Autowired
    MailContentBuilder mailContentBuilder;
 
    public void prepareAndSend(String recipient, String message) {
        
        MimeMessagePreparator messagePreparator = mimeMessage -> {
        	
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("sample@dolszewski.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject("Sample mail subject");
            //messageHelper.setText(message);
            
            String content = mailContentBuilder.build(message);
            messageHelper.setText(content, true);
        };
        try {
            mailSender.send(messagePreparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
        }
    }
 
}