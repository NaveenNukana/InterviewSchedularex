package com.web.demo.InterviewSchedularEx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.web.demo.InterviewSchedularEx.Enum.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String mobile;
	@Column(name = "emailId")
	private String emailId;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column
	private String password;
	@Column
	private Role role;
	@Column
	private String profileUrl;
	@Column(name = "forgotToken", unique = true, nullable = true)
	private String forgotToken;
	@Column
	private Integer otp;

}
