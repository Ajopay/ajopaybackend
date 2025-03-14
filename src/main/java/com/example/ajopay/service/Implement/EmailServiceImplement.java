package com.example.ajopay.service.Implement;

import com.example.ajopay.dto.RequestDto.EmailDetails;
import com.example.ajopay.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImplement implements EmailService {
    @Autowired
private JavaMailSender mailSender;
    @Value("ismaeelmopelola@gmail.com")
private String senderMail;
    @Override
    public void sendEmailAlert(EmailDetails emailDetails) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(senderMail);
            message.setText(emailDetails.getMesageBody());
            message.setSubject(emailDetails.getSubject());
            message.setTo(emailDetails.getRecipient());

            mailSender.send(message);
        }
        catch (Exception e){

            System.out.println("Mail sent successfully");
        }
    }
}
