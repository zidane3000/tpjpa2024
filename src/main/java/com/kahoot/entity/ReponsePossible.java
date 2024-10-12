package com.kahoot.entity;


import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class ReponsePossible implements Serializable {

    private long id;
    private String texteReponse;
    private boolean correct;

    private Question question;

    public ReponsePossible() {}

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexteReponse() {
        return texteReponse;
    }

    public void setTexteReponse(String texteReponse) {
        this.texteReponse = texteReponse;
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}