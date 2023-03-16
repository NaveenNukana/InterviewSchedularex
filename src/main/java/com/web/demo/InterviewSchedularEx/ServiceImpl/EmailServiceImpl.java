package com.web.demo.InterviewSchedularEx.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.web.demo.InterviewSchedularEx.dto.EmailDto;
import com.web.demo.InterviewSchedularEx.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendEmail(EmailDto emailDto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

//	if(!CollectionUtils.isEmpty(emailDto.getToList())) {
//			String[]toList=emailDto.getToList().toArray(new String[0]);
//			simpleMailMessage.setTo(toList);
//		}else {
//			simpleMailMessage.setTo(emailDto.getTo());
//		}
//		simpleMailMessage.setSubject(emailDto.getSubject());
//		simpleMailMessage.setText(emailDto.getMessage());
//		javaMailSender.send(simpleMailMessage);
//		
//	}
		try {

			// Creating a simple mail message
//          SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			String[] toList = emailDto.getToList().toArray(new String[0]);
			simpleMailMessage.setTo(toList);
			simpleMailMessage.setFrom("yashu2639725@gmail.com");
			simpleMailMessage.setSubject(emailDto.getSubject());
			simpleMailMessage.setText(emailDto.getMessage());
			// Sending the mail
			javaMailSender.send(simpleMailMessage);
			return "Mail Sent Successfully...";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			simpleMailMessage.setTo(emailDto.getTo());

			return "Error while Sending Mail";
		}
	}

}
