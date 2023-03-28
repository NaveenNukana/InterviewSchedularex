package com.web.demo.InterviewSchedularEx.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.web.demo.InterviewSchedularEx.dto.CalenderDto;
import com.web.demo.InterviewSchedularEx.dto.EmailDto;

public interface EmailService {
	String sendEmail(EmailDto emailDto);
	void sendCalenderInvite(CalenderDto calenderDto) throws IOException, MessagingException;

}
