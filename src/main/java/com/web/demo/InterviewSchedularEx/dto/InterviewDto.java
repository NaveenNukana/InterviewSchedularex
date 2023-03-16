package com.web.demo.InterviewSchedularEx.dto;

import java.time.LocalDateTime;

import javax.persistence.Table;

import com.web.demo.InterviewSchedularEx.Enum.InterviewStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@Table(name="interviewDto")
@NoArgsConstructor
public class InterviewDto {
	private Long id;
   private String candidateEmailId;
	private String schedularEmailId;
	private String interviewerEmailId;
    private LocalDateTime dateTime;
//    private String dateTime;
	private Long talentId;
	private InterviewStatus interviewStatus;
	private String meetlink;
}
