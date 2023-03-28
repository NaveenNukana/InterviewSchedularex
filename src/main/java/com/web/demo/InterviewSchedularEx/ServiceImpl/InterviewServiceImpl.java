package com.web.demo.InterviewSchedularEx.ServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.InterviewSchedularEx.Repository.InterviewRepository;
import com.web.demo.InterviewSchedularEx.dto.CalenderDto;
import com.web.demo.InterviewSchedularEx.dto.EmailDto;
import com.web.demo.InterviewSchedularEx.dto.InterviewDto;
import com.web.demo.InterviewSchedularEx.mapper.InterviewMapper;
import com.web.demo.InterviewSchedularEx.model.Candidate;
import com.web.demo.InterviewSchedularEx.model.Interview;
import com.web.demo.InterviewSchedularEx.model.User;
import com.web.demo.InterviewSchedularEx.service.EmailService;
import com.web.demo.InterviewSchedularEx.service.InterviewService;

import biweekly.parameter.ParticipationLevel;
import biweekly.property.Attendee;
import biweekly.property.Organizer;

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
		CalenderDto calenderDto=composeCalender(interview);
		emailservice.sendEmail(emailDto);
		try {
			emailservice.sendCalenderInvite(calenderDto);
		} catch (IOException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		interviewDto = interviewMapper.toInterviewDto(interview);
		return interviewDto;
	}

	private CalenderDto composeCalender(Interview interview) {
		Candidate candidate=interview.getCandidate();
		  return CalenderDto.builder()
		  .subject(String.format("is your Interview Scheduler with AvenueCode",candidate.getName() ) )
		  .description("Scheduling your first round of technical interview")
		  .meetingLink(interview.getMeetingLink())
		  .summary("Scheduling your first round of technical interview")
		  .eventDateTime(interview.getDateTime())
		  .organizer(new Organizer("AvenueCode","ifoanvenueCode"))
		  .attendees(getAttendees(interview))
		  .build();
		
	}
	private List<Attendee> getAttendees(Interview interview){
		Candidate candidate=interview.getCandidate();
		User scheduler=interview.getScheduler();
		User interviewer = interview.getInterviewer();
		List<Attendee> attendees=new ArrayList<>();
		Attendee CandideteAttendee =new Attendee(candidate.getName(),candidate.getEmailId());
		CandideteAttendee.setParticipationLevel(ParticipationLevel.REQUIRED);
		 attendees.add(CandideteAttendee);
		Attendee schedulerAttendee =new Attendee(scheduler.getName(),scheduler.getEmailId());
		schedulerAttendee.setParticipationLevel(ParticipationLevel.OPTIONAL);
		attendees.add(schedulerAttendee);
		Attendee interviewerAttendee =new Attendee(interviewer.getName(),interviewer.getEmailId());
		interviewerAttendee.setParticipationLevel(ParticipationLevel.REQUIRED);
		attendees.add(interviewerAttendee);
		return attendees;
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
				.message(String.format("Your is interview is scheduler at is ",interview.getDateTime()))
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
