package com.web.demo.InterviewSchedularEx.model;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.demo.InterviewSchedularEx.Enum.InterviewStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "interview")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Interview {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@ManyToOne(optional = false)
@JoinColumn(name = "candidate_id", referencedColumnName = "id")
private Candidate candidate;
@ManyToOne(optional = false)
@JoinColumn(name = "scheduler_id", referencedColumnName = "id")
private User scheduler;
@ManyToOne(optional = false)
@NotFound(action = NotFoundAction.IGNORE)
@JoinColumn(name = "interviewer_id", referencedColumnName = "id")
private User interviewer;
@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
private LocalDateTime dateTime;
//private String dateTime;
@ManyToOne(optional = false)
@JoinColumn(name = "talent_id", referencedColumnName = "id")
private Talent talent;
@Enumerated(EnumType.STRING)
private InterviewStatus interviewStatus;
private String meetingLink;

}
