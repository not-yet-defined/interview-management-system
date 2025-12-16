package com.flatirons.interview.interviewservice.domain.entity;

import com.flatirons.interview.interviewservice.domain.enums.InterviewStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "interviews")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long candidateId;
    private Long interviewerId;

    private LocalDateTime scheduledAt;

    @Enumerated(EnumType.STRING)
    private InterviewStatus status;
}