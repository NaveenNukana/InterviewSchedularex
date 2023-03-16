package com.web.demo.InterviewSchedularEx.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.InterviewSchedularEx.Repository.FeedbackRepository;
import com.web.demo.InterviewSchedularEx.dto.FeedbackDto;
import com.web.demo.InterviewSchedularEx.mapper.FeedbackMapper;
import com.web.demo.InterviewSchedularEx.model.Feedback;
import com.web.demo.InterviewSchedularEx.service.FeedbackService;
@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	private FeedbackMapper feedbackMapper;
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
		// TODO Auto-generated method stub
		Feedback feedback = feedbackMapper.toFeedback(feedbackDto);
		Feedback fDto = feedbackRepository.save(feedback);
		FeedbackDto feedbackDto2 = feedbackMapper.toFeedbackDto(fDto);
		return feedbackDto2;
	}

}
