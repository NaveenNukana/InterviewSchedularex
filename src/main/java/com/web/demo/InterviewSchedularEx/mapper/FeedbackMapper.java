package com.web.demo.InterviewSchedularEx.mapper;

import org.mapstruct.Mapper;

import com.web.demo.InterviewSchedularEx.dto.FeedbackDto;
import com.web.demo.InterviewSchedularEx.model.Feedback;
@Mapper(componentModel = "spring")
public interface FeedbackMapper {
	FeedbackDto toFeedbackDto(Feedback feedback);

	Feedback toFeedback(FeedbackDto feedbackDto);
}


