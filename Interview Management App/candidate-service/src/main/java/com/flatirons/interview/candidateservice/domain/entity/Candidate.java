package com.flatirons.interview.candidateservice.domain.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer experienceYears;
}