package com.flatirons.interview.interviewservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "candidate-service")
public interface CandidateClient {

    @GetMapping("/candidates/{id}")
    void validateCandidate(@PathVariable Long id);
}
