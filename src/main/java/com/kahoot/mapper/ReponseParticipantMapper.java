package com.kahoot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kahoot.dto.ReponseParticipantDTO;
import com.kahoot.entity.ReponseParticipant;

@Mapper
public interface ReponseParticipantMapper {
    ReponseParticipantMapper INSTANCE = Mappers.getMapper(ReponseParticipantMapper.class);

    ReponseParticipantDTO reponseParticipantToReponseParticipantDTO(ReponseParticipant reponseParticipant);

    ReponseParticipant reponseParticipantDTOToReponseParticipant(ReponseParticipantDTO reponseParticipantDTO);
}