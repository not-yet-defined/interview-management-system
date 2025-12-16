package com.flatirons.interview.interviewerservice.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "interviewers")
public class Interviewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String skill;
}
