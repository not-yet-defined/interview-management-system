package com.flatirons.interview.interviewservice.repository;


import com.flatirons.interview.interviewservice.domain.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}