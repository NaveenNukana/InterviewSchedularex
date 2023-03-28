package com.web.demo.InterviewSchedularEx.ServiceImpl;

import java.io.File;
import java.io.IOException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.web.demo.InterviewSchedularEx.dto.CalenderDto;
import com.web.demo.InterviewSchedularEx.dto.EmailDto;
import com.web.demo.InterviewSchedularEx.service.EmailService;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.parameter.ParticipationLevel;
import biweekly.property.Attendee;
import biweekly.property.Method;
import biweekly.util.Duration;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendEmail(EmailDto emailDto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

		try {

			String[] toList = emailDto.getToList().toArray(new String[0]);	
			simpleMailMessage.setTo(toList);
			simpleMailMessage.setFrom("yashu2639725@gmail.com");
			simpleMailMessage.setSubject(emailDto.getSubject());
			simpleMailMessage.setText(emailDto.getMessage());

			javaMailSender.send(simpleMailMessage);
			return "Mail Sent Successfully...";
		}

		catch (Exception e) {
			simpleMailMessage.setTo(emailDto.getTo());

			return "Error while Sending Mail";
		}
	}

	@Override
	public void sendCalenderInvite(CalenderDto calenderDto) throws IOException, MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		mimeMessage.setRecipients(Message.RecipientType.TO, getToAddress(calenderDto.getAttendees()));
		mimeMessage.setSubject(calenderDto.getSubject());

		MimeMultipart mimeMultipart = new MimeMultipart("mixed");

		mimeMultipart.addBodyPart(getAttachmentMimeBodyPart());
		mimeMultipart.addBodyPart(createCalenderMimeBody(calenderDto));

		mimeMessage.setContent(mimeMultipart);
		javaMailSender.send(mimeMessage);

	}

	private MimeBodyPart getAttachmentMimeBodyPart() throws IOException, MessagingException {

		File file = new File("src/main/resources/naveen21.pdf");
		MimeBodyPart attachmentMineBodyPart = new MimeBodyPart();
		attachmentMineBodyPart.attachFile(file);

		return attachmentMineBodyPart;
	}

	private BodyPart createCalenderMimeBody(CalenderDto calenderDto) throws IOException, MessagingException {
		MimeBodyPart calenderBody = new MimeBodyPart();

		final DataSource source = new ByteArrayDataSource(createCal(calenderDto), "text/calender;charset=UTF-8");
		calenderBody.setDataHandler(new DataHandler(source));
		calenderBody.setHeader("content-type", "text/calender;charset=UTF-8;method=REQUEST");
		return calenderBody;

	}

	private Address[] getToAddress(List<Attendee> attendees) {

		return attendees.stream().map(attendee -> {
			Address address = null;
			try {

				address = new InternetAddress(attendee.getEmail());
			} catch (AddressException e) {
				e.printStackTrace();
			}
			return address;
		}).collect(Collectors.toList()).toArray(new InternetAddress[0]);

	}

	private String createCal(CalenderDto calenderDto) {
		ICalendar ical = new ICalendar();
		ical.addProperty(new Method(Method.REQUEST));
		VEvent event = new VEvent();
		event.setUrl(calenderDto.getMeetingLink());
		event.setSummary(calenderDto.getSummary());
		event.setDescription(calenderDto.getDescription());
		;
		event.setDateStart(getStartDate(calenderDto.getEventDateTime()));
		event.setDuration(new Duration.Builder().hours(1).build());
		event.setOrganizer(calenderDto.getOrganizer());
		addAttendee(event, calenderDto.getAttendees());
		ical.addEvent(event);
		return Biweekly.write(ical).go();

	}

	private void addAttendee(VEvent event, List<Attendee> attendees) {
		for (Attendee attendee : attendees) {
			attendee.setParticipationLevel(ParticipationLevel.REQUIRED);
			event.addAttendee(attendee);
		}

	}

	private Date getStartDate(LocalDateTime eventDateTime) {
		Instant instant = eventDateTime.atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);

	}

}
