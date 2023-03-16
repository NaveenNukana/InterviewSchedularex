package com.web.demo.InterviewSchedularEx.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	@Column(name = "email_id")
	private String emailId;
	private String mobile;
	private String resumeUrl;
	private Integer ctc;
	private Integer ectc;
	private String location;
	private String notice;
	private String remarkss;
	

}