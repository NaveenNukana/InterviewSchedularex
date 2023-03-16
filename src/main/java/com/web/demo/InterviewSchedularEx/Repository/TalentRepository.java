package com.web.demo.InterviewSchedularEx.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.InterviewSchedularEx.model.Talent;
@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {

}
