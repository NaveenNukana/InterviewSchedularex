package com.web.demo.InterviewSchedularEx.Repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.demo.InterviewSchedularEx.dto.FeedbackDto;
import com.web.demo.InterviewSchedularEx.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Id> {
	

}
