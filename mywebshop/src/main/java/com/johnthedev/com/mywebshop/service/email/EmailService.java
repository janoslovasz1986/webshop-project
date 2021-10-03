package com.johnthedev.com.mywebshop.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService{

    private JavaMailSender javaMailSender;
    
    @Value("${spring.mail.username}")
    private String MESSAGE_FROM;
    
    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender ) {
    	
    	this.javaMailSender = javaMailSender;
    	
    }
	
    public void sendMessage(String email) {
    	SimpleMailMessage message = null;
    	
    	try {
    		
    		message = new SimpleMailMessage();
    		message.setFrom(MESSAGE_FROM);
    		message.setTo(email);
    		message.setSubject("Sikeres regisztrálás");
    		message.setText("Kedves " + email + "! \n \n Köszönjük, hogy regisztráltál honlapunkra!");
    		javaMailSender.send(message);
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    
    	
    	
    	
    }


	
}
