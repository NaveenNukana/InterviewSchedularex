	package com.web.demo.InterviewSchedularEx.model;

import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.web.demo.InterviewSchedularEx.Enum.InterviewStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "feedback")			
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name = "cadidate_id")
	private Candidate candidate;
	@OneToOne
	@JoinColumn(name = "interview_id")
	private Interview interview;
	@Enumerated(EnumType.STRING)
	private InterviewStatus status;
	private String remarks;
	private Integer rating;
}
