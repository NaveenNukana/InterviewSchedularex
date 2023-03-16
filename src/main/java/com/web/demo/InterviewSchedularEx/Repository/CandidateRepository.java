package com.web.demo.InterviewSchedularEx.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.InterviewSchedularEx.model.Candidate;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	Candidate findCandidateByEmailId(String emailId);

}
