package com.kahoot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kahoot.dto.ParticipantDTO;
import com.kahoot.entity.Participant;

@Mapper
public interface ParticipantMapper {
    ParticipantMapper INSTANCE = Mappers.getMapper(ParticipantMapper.class);

    ParticipantDTO participantToParticipantDTO(Participant participant);

    Participant participantDTOToParticipant(ParticipantDTO participantDTO);
}