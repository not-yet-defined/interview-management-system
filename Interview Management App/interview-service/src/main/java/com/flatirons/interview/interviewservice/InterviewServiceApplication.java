package com.flatirons.interview.interviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.flatirons.interview.interviewservice.client")
public class InterviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewServiceApplication.class, args);
	}

}
