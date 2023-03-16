package com.web.demo.InterviewSchedularEx.service;

import java.util.List;

import com.web.demo.InterviewSchedularEx.dto.TalentDto;
import com.web.demo.InterviewSchedularEx.model.Talent;

public interface TalentService {
	TalentDto createTalent(TalentDto talentDto);

	List<TalentDto> findAll();

	Talent getTalent(long talentId);

}
