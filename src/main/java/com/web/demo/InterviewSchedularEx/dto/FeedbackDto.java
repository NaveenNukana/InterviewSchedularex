package com.web.demo.InterviewSchedularEx.dto;
import com.web.demo.InterviewSchedularEx.Enum.InterviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {

				
		private long id;
		private String candidateEmailId;
		private String interviewerEmailId;;
		private InterviewStatus status;
		private String remarks;
		private Integer rating;
	}

