package com.kahoot.dto;

import lombok.Data;

@Data
public class QuestionDTO {
    
        private long id;
        private String question;
        private String reponse;
        private KahootDTO kahoot;
        private boolean correcte;
        private int score;

}
