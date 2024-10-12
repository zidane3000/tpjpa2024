package com.kahoot.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kahoot.entity.Kahoot;
import com.kahoot.dto.KahootDTO;

@Mapper
public interface KahootMapper {
    KahootMapper INSTANCE = Mappers.getMapper(KahootMapper.class);

    KahootDTO kahootToKahootDTO(Kahoot kahoot);

    Kahoot kahootDTOToKahoot(KahootDTO kahootDTO);
}