package com.flatirons.interview.interviewservice.mapper;

import com.flatirons.interview.interviewservice.domain.entity.Interview;
import com.flatirons.interview.interviewservice.dto.InterviewRequestDto;
import com.flatirons.interview.interviewservice.dto.InterviewResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InterviewMapper {

    @Mapping(target = "status", constant = "SCHEDULED")
    Interview toEntity(InterviewRequestDto dto);

    InterviewResponseDto toDto(Interview entity);
}