package com.tHire.candidate.Configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	 @Value("${spring.mail.host}")
	    private String host;
	    
	    @Value("${spring.mail.port}")
	    private int port;
	    
	    @Value("${spring.mail.username}")
	    private String username;
	    
	    @Value("${spring.mail.password}")
	    private String password;
	    
	    @Value("${spring.mail.subject}")
	    private String subject;
	    
	    @Value("${spring.mail.text}") 
	    private String text;
	    @Bean
	    public JavaMailSenderImpl javaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost(this.host);
	        mailSender.setPort(this.port);
	        mailSender.setUsername(this.username);
	        mailSender.setPassword(this.password);
	        
	        Properties props = mailSender.getJavaMailProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.debug", "true");
	        
	        return mailSender;
	    }
}
