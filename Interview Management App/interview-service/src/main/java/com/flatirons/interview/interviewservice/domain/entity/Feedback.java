package com.flatirons.interview.interviewservice.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long interviewId;
    private Integer rating;
    private String comments;
}