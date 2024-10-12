package com.kahoot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kahoot.dto.QuestionDTO;
import com.kahoot.entity.Question;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDTO questionToQuestionDTO(Question question);

    Question questionDTOToQuestion(QuestionDTO questionDTO);
}