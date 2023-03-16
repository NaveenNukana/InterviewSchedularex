package com.web.demo.InterviewSchedularEx.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.web.demo.InterviewSchedularEx.Repository.CandidateRepository;
import com.web.demo.InterviewSchedularEx.dto.CandidateDto;
import com.web.demo.InterviewSchedularEx.mapper.CandidateMapper;
import com.web.demo.InterviewSchedularEx.model.Candidate;
import com.web.demo.InterviewSchedularEx.service.CandidateService;
@Service
public class CandidateServiceImpl implements CandidateService{
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private CandidateMapper candidateMapper;
    @Override
	public CandidateDto createCandidate(CandidateDto candidateDto) {
		Candidate candidate = candidateMapper.toCandidate(candidateDto);
		candidate = candidateRepository.save(candidate);
		candidateDto = candidateMapper.toCandidateDto(candidate);
		return candidateDto;
	}
	@Override
	public Candidate findCandidateByEmail(String emailId) {
		Candidate candidate= candidateRepository.findCandidateByEmailId(emailId);
//		UserDto userDto=userMapper.toUserDto(user);		
		return candidate;
	
}
}
