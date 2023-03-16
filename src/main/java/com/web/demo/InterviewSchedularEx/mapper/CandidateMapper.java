package com.web.demo.InterviewSchedularEx.mapper;

import org.mapstruct.Mapper;

import com.web.demo.InterviewSchedularEx.dto.CandidateDto;
import com.web.demo.InterviewSchedularEx.model.Candidate;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

	CandidateDto toCandidateDto(Candidate candidate);

	Candidate toCandidate(CandidateDto candidateDto);
}
