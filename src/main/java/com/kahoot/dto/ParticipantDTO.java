package com.kahoot.dto;

import lombok.Data;
import java.util.List;

@Data
public class ParticipantDTO {
    private long id;
    private KahootDTO kahoot;
    private int scoreTotal;
    private List<ReponseParticipantDTO> reponseParticipants;
}