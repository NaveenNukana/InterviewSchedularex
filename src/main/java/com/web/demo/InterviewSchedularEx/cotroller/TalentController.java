package com.web.demo.InterviewSchedularEx.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.demo.InterviewSchedularEx.dto.TalentDto;
import com.web.demo.InterviewSchedularEx.exception.ResourceNotFoundException;
import com.web.demo.InterviewSchedularEx.model.Talent;
import com.web.demo.InterviewSchedularEx.service.TalentService;

@RestController
@RequestMapping("/talent")
public class TalentController {
	@Autowired
	private TalentService talentService;
	@PostMapping
	public HttpEntity<TalentDto> createTalent(@RequestBody TalentDto talentDto){
		TalentDto talent=talentService.createTalent(talentDto);
		return new ResponseEntity<>(talent, HttpStatus.CREATED);

}
	@GetMapping("/{id}")
	public HttpEntity<Talent> findById(@PathVariable long id) {
		Talent talents = talentService.getTalent(id);
//				.orElseThrow(() -> new ResourceNotFoundException("Resource not found ", HttpStatus.NOT_FOUND));
		return new ResponseEntity<>(talents, HttpStatus.CREATED);

	}


}