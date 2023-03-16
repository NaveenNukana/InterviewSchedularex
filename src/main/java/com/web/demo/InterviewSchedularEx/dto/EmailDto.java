package com.web.demo.InterviewSchedularEx.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@ToString
public class EmailDto {
	private String from;
	private String to;
	private List<String> toList;
	private String message;
	private String subject;

}
