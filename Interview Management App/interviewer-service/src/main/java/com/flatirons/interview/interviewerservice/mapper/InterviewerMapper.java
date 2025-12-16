package com.flatirons.interview.interviewerservice.mapper;

import com.flatirons.interview.interviewerservice.domain.entity.Interviewer;
import com.flatirons.interview.interviewerservice.dto.InterviewerRequestDto;
import com.flatirons.interview.interviewerservice.dto.InterviewerResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InterviewerMapper {

    Interviewer toEntity(InterviewerRequestDto dto);

    InterviewerResponseDto toDto(Interviewer entity);
}
