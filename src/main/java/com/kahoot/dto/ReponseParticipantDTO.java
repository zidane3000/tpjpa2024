package com.kahoot.dto;

import lombok.Data;

@Data
public class ReponseParticipantDTO {

    private long id;
    private String reponse;
    private boolean correcte;
    private int score;
    private ParticipantDTO participant;
}
