package com.flatirons.interview.interviewservice.repository.specification;

import com.flatirons.interview.interviewservice.domain.entity.Interview;
import org.springframework.data.jpa.domain.Specification;

public final class InterviewSpecification {

    private InterviewSpecification() {
    }

    public static Specification<Interview> hasCandidateId(Long candidateId) {
        return (root, query, cb) ->
                candidateId == null ? null :
                        cb.equal(root.get("candidateId"), candidateId);
    }

    public static Specification<Interview> hasInterviewerId(Long interviewerId) {
        return (root, query, cb) ->
                interviewerId == null ? null :
                        cb.equal(root.get("interviewerId"), interviewerId);
    }
}