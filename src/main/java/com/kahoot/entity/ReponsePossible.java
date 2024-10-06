package com.kahoot.entity;

import jakarta.persistence.*;

@Entity
public class ReponsePossible {

    private long id;
    private String reponses;
    private Kahoot kahoot;

    public ReponsePossible() {
    }
    public ReponsePossible(String reponses) {
        this.reponses = reponses;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReponses() {
        return reponses;
    }

    public void setReponses(String reponses) {
        this.reponses = reponses;
    }

    public void setKahoot(Kahoot kahoot) {
        this.kahoot = kahoot;
    }

    @ManyToOne
    public Kahoot getKahoot() {
        return kahoot;
    }

    

}
