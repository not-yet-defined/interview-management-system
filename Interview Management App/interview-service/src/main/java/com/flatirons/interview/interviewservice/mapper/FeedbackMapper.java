package com.flatirons.interview.interviewservice.mapper;

import com.flatirons.interview.interviewservice.domain.entity.Feedback;
import com.flatirons.interview.interviewservice.dto.FeedbackRequestDto;
import com.flatirons.interview.interviewservice.dto.FeedbackResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "interviewId", ignore = true)
    Feedback toEntity(FeedbackRequestDto dto);

    FeedbackResponseDto toDto(Feedback entity);
}
