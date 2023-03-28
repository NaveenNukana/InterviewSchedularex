package com.web.demo.InterviewSchedularEx.mapper;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.InterviewSchedularEx.dto.InterviewDto;
import com.web.demo.InterviewSchedularEx.model.Candidate;
import com.web.demo.InterviewSchedularEx.model.Interview;
import com.web.demo.InterviewSchedularEx.model.Talent;
import com.web.demo.InterviewSchedularEx.model.User;
import com.web.demo.InterviewSchedularEx.service.CandidateService;
import com.web.demo.InterviewSchedularEx.service.TalentService;
import com.web.demo.InterviewSchedularEx.service.UserService;

@Service
public class InterviewMapper {
	@Autowired
	private UserService userService;
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private TalentService talentService;

	public InterviewDto toInterviewDto(Interview interview) {
		return InterviewDto.builder()
				.id(interview.getId())
				.candidateEmailId(Optional.ofNullable(interview.getCandidate()).map(Candidate::getEmailId).orElse(null))			
				.interviewerEmailId(Optional.ofNullable(interview.getInterviewer()).map(User::getEmailId).orElse(null))
				.talentId(Optional.ofNullable(interview.getTalent()).map(Talent::getId).orElse(null))
				.interviewStatus(interview.getInterviewStatus())
				.schedularEmailId(Optional.ofNullable(interview.getScheduler()).map(User::getEmailId).orElse(null))
				.meetlink(interview.getMeetingLink()).dateTime(interview.getDateTime())
				.interviewStatus(interview.getInterviewStatus()).build();

	}

	public Interview toInterview(InterviewDto interviewDto) {
		Interview interview = new Interview();
		interview.setCandidate(candidateService.findCandidateByEmail(interviewDto.getCandidateEmailId()));
		interview.setScheduler(userService.findUserByEmailId(interviewDto.getSchedularEmailId()));
		interview.setInterviewer(userService.findUserByEmailId(interviewDto.getInterviewerEmailId()));
		interview.setTalent(talentService.getTalent(interviewDto.getTalentId()));
		interview.setDateTime(interviewDto.getDateTime());
		interview.setMeetingLink(interviewDto.getMeetlink());

		interview.setInterviewStatus(interviewDto.getInterviewStatus());
		return interview;
	}

	public List<InterviewDto> toDtos(List<Interview> interviews) {
		if (interviews == null) {
			return new ArrayList<>();
		}
		return interviews
				.stream()
				.map(interview -> toInterviewDto(interview))  
				.collect(Collectors.toList());
	}
}
