package com.kahoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kahoot.mapper.KahootMapper;
import org.mapstruct.factory.Mappers;

@Configuration
public class MapperConfig {

    @Bean
    public KahootMapper kahootMapper() {
        return Mappers.getMapper(KahootMapper.class);
    }
}