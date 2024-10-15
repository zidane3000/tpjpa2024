package com.kahoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kahoot.entity.Question;
import com.kahoot.mapper.KahootMapper;
import com.kahoot.mapper.QuestionMapper;

import org.mapstruct.factory.Mappers;

@Configuration
public class MapperConfig {

    @Bean
    public KahootMapper kahootMapper() {
        return Mappers.getMapper(KahootMapper.class);
    }

    @Bean
    public QuestionMapper questionMapper() {
        return Mappers.getMapper(QuestionMapper.class);
    }
}