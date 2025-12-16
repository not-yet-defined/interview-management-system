package com.flatirons.interview.interviewservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "interviewer-service")
public interface InterviewerClient {

    @GetMapping("/interviewers/{id}")
    void validateInterviewer(@PathVariable Long id);
}
