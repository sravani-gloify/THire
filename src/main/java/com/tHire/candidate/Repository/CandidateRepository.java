package com.tHire.candidate.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tHire.candidate.model.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long>{

	//@Query(value= "",nativeQuery=true)
	

	
}
