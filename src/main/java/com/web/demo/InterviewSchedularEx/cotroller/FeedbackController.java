package com.web.demo.InterviewSchedularEx.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.demo.InterviewSchedularEx.dto.FeedbackDto;
import com.web.demo.InterviewSchedularEx.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired(required=true)
	private FeedbackService feedbackService;

	@PostMapping
	public HttpEntity<FeedbackDto> createFeedback(@RequestBody FeedbackDto feedbackDto) {
		FeedbackDto fDto = feedbackService.createFeedback(feedbackDto);
		return new ResponseEntity<>(fDto, HttpStatus.CREATED);

	}

}
