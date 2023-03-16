package com.web.demo.InterviewSchedularEx.service;

import com.web.demo.InterviewSchedularEx.dto.CandidateDto;
import com.web.demo.InterviewSchedularEx.model.Candidate;

public interface CandidateService {

	CandidateDto createCandidate(CandidateDto candidateDto);

	Candidate findCandidateByEmail(String emailId);

}
