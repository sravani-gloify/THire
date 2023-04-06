package com.tHire.candidate.Service;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.tHire.candidate.Repository.CandidateRepository;
import com.tHire.candidate.model.Candidate;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
    	
	public Candidate save(Candidate candidate) {
		
		 
		Random r=new Random();
		String i=String.format("%04d",r.nextInt(10000));
		 System.out.println(i);
		 candidate.setOtp(i);
		
	
	return candidateRepository.save(candidate);
	}
	
	public Candidate findById(Long id) {
		return candidateRepository.findById(id).get();
		
	}

	public Candidate update(Candidate candidate) {
		
		return candidateRepository.save(candidate);
	}
 
	public void deleteById(Long id) {
		
	    candidateRepository.deleteById(id);;
	}

	public CandidateRepository getCandidateRepository() {
		return candidateRepository;
	}

	public void setCandidateRepository(CandidateRepository candidateRepository) {
		this.candidateRepository = candidateRepository;
	}

	

			
	
}
