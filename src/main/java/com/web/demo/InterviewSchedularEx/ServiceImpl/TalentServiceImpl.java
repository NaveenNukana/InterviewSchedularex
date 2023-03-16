package com.web.demo.InterviewSchedularEx.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.web.demo.InterviewSchedularEx.Repository.TalentRepository;
import com.web.demo.InterviewSchedularEx.dto.TalentDto;
import com.web.demo.InterviewSchedularEx.exception.ResourceNotFoundException;
import com.web.demo.InterviewSchedularEx.mapper.TalentMapper;
import com.web.demo.InterviewSchedularEx.model.Talent;
import com.web.demo.InterviewSchedularEx.service.TalentService;

@Service
public class TalentServiceImpl implements TalentService {
	@Autowired
	private TalentMapper talentMapper;
	@Autowired
	private TalentRepository talentRepository;

	@Override
	public TalentDto createTalent(TalentDto talentDto) {
		Talent talent = talentMapper.toTalent(talentDto);
		Talent talentEntity = talentRepository.save(talent);
		talentDto = talentMapper.toTalentDto(talentEntity);
		return talentDto;
	}

	@Override
	public Talent getTalent(long talentId) {
		Talent talents = talentRepository.findById(talentId)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found ", HttpStatus.NOT_FOUND));
		return talents;

	}

	@Override
	public List<TalentDto> findAll() {
		List<Talent> talents = talentRepository.findAll();
		return null;
	}

}
