package com.tHire.candidate.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tHire.candidate.Service.CandidateService;
import com.tHire.candidate.Service.EmailService;
import com.tHire.candidate.Service.OtpService;
import com.tHire.candidate.model.Candidate;


@RestController
@RequestMapping("/candidate")
public class CandidateController {
	@Autowired
	private CandidateService candidateService;

	@Autowired
	private EmailService emailService;
	 @Autowired
		private OtpService otpService;

	@GetMapping("/get")
	public String getData()
	{
		return "Welcome to the tHire ";
	}
	
	@PostMapping("/save")
	public Candidate saveCandidateDatails(@RequestBody Candidate candidate) {
		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String userName=auth.getName();
		String  otp=  candidate.getOtp();
//		System.out.println(otp);
//		
		otpService.generateOTP(otp);
	emailService.sendSimpleMail(candidate);
		return candidateService.save(candidate);
		
	}

	@GetMapping("/{id}")
	public Candidate name(@PathVariable Long id) {
		
		return candidateService.findById(id);
	}
	@PutMapping("/update/{id}")
	public Candidate saveOrUpdate(@PathVariable Long id,@RequestBody  Candidate candidateDetails)
	{
	    
		Candidate candidate=candidateService.findById(id);
		candidate.setMobileNo(candidateDetails.getMobileNo());
		candidate.setEmailId(candidateDetails.getEmailId());
        return candidateService.update(candidate);
		
	}
	@DeleteMapping("/delete/1")
	public void delete(@PathVariable Long id)
	{
		candidateService.deleteById(id);
		
	}
	
    

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	

	public CandidateService getCandidateService() {
		return candidateService;
	}

	public void setCandidateService(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

}
