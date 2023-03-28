 package com.web.demo.InterviewSchedularEx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {

	private Long id;
	private String name;
	private String address;
	private String emailId;
	private String mobile;
	private String resumeUrl;
	private Integer ctc;
	private Integer ectc;
	private String location;
	private String notice;
	private String remarkss;
	
	

}
