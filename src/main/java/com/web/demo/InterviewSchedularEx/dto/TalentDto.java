package com.web.demo.InterviewSchedularEx.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class TalentDto {
	private Long id;
	private String name;
	private String requriment;
	private LocalDate sartDate;
	private LocalDate endDate;
	private String jobLocation;

}
