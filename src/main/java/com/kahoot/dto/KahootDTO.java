package com.kahoot.dto;

import java.util.Collection;

import com.kahoot.entity.Kahoot.Type;

import lombok.Data;

@Data
public class KahootDTO {
    private Type type;
    private String titre;
    private int PIN;
    private CreateurDTO createur;

    private Collection<QuestionDTO> questions;
}