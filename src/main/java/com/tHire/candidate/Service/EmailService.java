package com.tHire.candidate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.stereotype.Service;

import com.tHire.candidate.model.Candidate;

@Service
public class EmailService {
	// Java Program to Illustrate Creation Of
	// Service implementation class
		@Autowired private JavaMailSender javaMailSender;

		@Value("${spring.mail.username}") private String sender;
        @Value("${spring.mail.subject}") private String subject;
        @Value("${spring.mail.text}")  private String text;
		// Method 1
		// To send a simple email
		public String sendSimpleMail(Candidate candidate)
		{

			// Try block to check for exceptions
			try {

				// Creating a simple mail message
				SimpleMailMessage mailMessage
					= new SimpleMailMessage();

				// Setting up necessary details
				mailMessage.setFrom(sender);
				mailMessage.setTo(candidate.getEmailId());
                mailMessage.setSubject(subject);
                String text1 = "";
                text1 = text + candidate.getOtp() ; 
                mailMessage.setText(text1);
				// Sending the mail
				javaMailSender.send(mailMessage);
				return "Mail Sent Successfully...";
			}

			// Catch block to handle the exceptions
			catch (Exception e) {
				return "Error while Sending Mail";
			}
		}

}
