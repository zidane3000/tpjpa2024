package com.kahoot.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
public class ReponseParticipant implements Serializable {
    private long id;
    private ReponsePossible reponsePossible;
    private Participant participant;
    private int score;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public ReponseParticipant() {
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public ReponsePossible getReponsePossible() {
        return reponsePossible;
    }

    public void setReponsePossible(ReponsePossible reponsePossible) {
        this.reponsePossible = reponsePossible;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}