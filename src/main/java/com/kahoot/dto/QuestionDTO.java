package com.kahoot.dto;

import lombok.Data;

@Data
public class QuestionDTO {
    
    private long id;
    private TypeQuestion typeQuestion;
    private String texteQuestion;
    private KahootDTO kahoot;

    public enum TypeQuestion {
        CHOIX_MULTIPLES, REPONSE_COURTE
    }
}
