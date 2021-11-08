package com.tsmc.ecp.mail;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailClientTest {
 
    private GreenMail smtpServer;
 
    @Before
    public void setUp() throws Exception {
        smtpServer = new GreenMail(new ServerSetup(25, null, "smtp"));
        smtpServer.start();
    }
 
    @After
    public void tearDown() throws Exception {
        smtpServer.stop();
    }
    
    @Autowired
    private MailClient mailClient;
     
    @Test
    public void shouldSendMail() throws Exception {
        //given
        String recipient = "yuchien.weng@gmail.com";
        String message = "Test message content";
        //when
        mailClient.prepareAndSend(recipient, message);
        //then
        String content = "<span>" + message + "</span>";
        assertReceivedMessageContains(content);
    }
     
    private void assertReceivedMessageContains(String expected) throws IOException, MessagingException {
        smtpServer = new GreenMail(new ServerSetup(25, null, "smtp"));
        smtpServer.start();
        
        MimeMessage[] receivedMessages = smtpServer.getReceivedMessages();
        assertEquals(1, receivedMessages.length);
        String content = (String) receivedMessages[0].getContent();
        assertTrue(content.contains(expected));
    }
     
}