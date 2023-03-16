package com.web.demo.InterviewSchedularEx.mapper;

import org.mapstruct.Mapper;

import com.web.demo.InterviewSchedularEx.dto.TalentDto;
import com.web.demo.InterviewSchedularEx.model.Talent;

@Mapper(componentModel = "spring")
public interface TalentMapper {
	TalentDto toTalentDto(Talent talent);

	Talent toTalent(TalentDto talentDto);
}
