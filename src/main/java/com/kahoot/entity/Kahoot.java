package com.kahoot.entity;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Kahoot implements Serializable {
    public enum Type {
        QUIZ, SONDAGE
    }

    private long id;
    private Type type;
    private String titre;
    private int PIN;
    private Createur createur;
    private Collection<Participant> participants;
    private Collection<Question> questions;

    public Kahoot() {}

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    @ManyToOne(optional = false)
    public Createur getCreateur() {
        return createur;
    }

    public void setCreateur(Createur createur) {
        this.createur = createur;
    }

    @OneToMany(mappedBy = "kahoot")
    public Collection<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Collection<Participant> participants) {
        this.participants = participants;
    }

    @OneToMany(mappedBy = "kahoot", cascade = CascadeType.ALL)
    public Collection<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Collection<Question> questions) {
        this.questions = questions;
    }
}