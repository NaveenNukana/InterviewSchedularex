package com.web.demo.InterviewSchedularEx.service;

import java.util.List;

import com.web.demo.InterviewSchedularEx.dto.InterviewDto;

public interface InterviewService {
	
	InterviewDto scheduleInterview(InterviewDto interviewDto);
	 List<InterviewDto> getInterview(String ScheduleEmail);
	
}
