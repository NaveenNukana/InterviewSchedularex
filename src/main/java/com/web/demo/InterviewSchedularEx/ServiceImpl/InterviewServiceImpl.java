package com.web.demo.InterviewSchedularEx.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.InterviewSchedularEx.Repository.InterviewRepository;
import com.web.demo.InterviewSchedularEx.dto.EmailDto;
import com.web.demo.InterviewSchedularEx.dto.InterviewDto;
import com.web.demo.InterviewSchedularEx.mapper.InterviewMapper;
import com.web.demo.InterviewSchedularEx.model.Interview;
import com.web.demo.InterviewSchedularEx.service.EmailService;
import com.web.demo.InterviewSchedularEx.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;
	@Autowired
	private InterviewMapper interviewMapper;
	@Autowired
	private EmailService emailservice;

	@Override
	public InterviewDto scheduleInterview(InterviewDto interviewDto) {
		Interview interview = interviewMapper.toInterview(interviewDto);
		interviewRepository.save(interview);
		EmailDto emailDto = composeEmail(interview);
		emailservice.sendEmail(emailDto);
		interviewDto = interviewMapper.toInterviewDto(interview);
		return interviewDto;
	}

	@Override
	public List<InterviewDto> getInterview(String ScheduleEmail) {
		List<Interview> interviews = interviewRepository.getInterviewByScheduler_EmailId(ScheduleEmail);
		List<InterviewDto> interviewDtos = interviewMapper.toDtos(interviews);
		return interviewDtos;

	}

	private EmailDto composeEmail(Interview interview) {
		return EmailDto.builder()
			 	.from(interview.getScheduler().getEmailId())
				.message(String.format("Your is interview is scheduler at is ", interview.getDateTime()))
				.subject("Interview")
				.toList(getToEmails(interview))
				.build();
	}

	List<String> getToEmails(Interview interview) {
		List<String> emails = new ArrayList<>();
		emails.add(interview.getCandidate().getEmailId());
		emails.add(interview.getScheduler().getEmailId());
		return emails;
	}

}
