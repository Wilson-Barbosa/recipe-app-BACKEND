package com.cuisinehub.recipes.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    // Injecting the MailSender class
    @Autowired JavaMailSender eMailSender;

    // Method that gets called to send an email
    public void sendSimpleRegistrationEmail(String userEmail, String subject, String text){

        // Creates a simple message
        SimpleMailMessage emailToBeSent = new SimpleMailMessage();

        // Populates the message with information
        emailToBeSent.setFrom("cuisineHub@email.com");
        emailToBeSent.setText(text);
        emailToBeSent.setTo(userEmail);
        emailToBeSent.setSubject(subject);

        // Sends the email
        eMailSender.send(emailToBeSent);

    }

}
