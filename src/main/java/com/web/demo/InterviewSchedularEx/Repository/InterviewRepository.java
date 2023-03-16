package com.web.demo.InterviewSchedularEx.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.InterviewSchedularEx.model.Interview;
@Repository
public interface InterviewRepository extends JpaRepository<Interview ,Long> {

	List<Interview> getInterviewByScheduler_EmailId(String scheduleEmail);


	

}
