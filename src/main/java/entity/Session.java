package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Session implements Serializable {

    private long id;
    private int PIN;
    private int score_final;

    private Createur createur;
    private Collection<Participant> participants;
    private Collection<Kahoot> kahoots;
    private Collection<ReponseParticipant> reponsesParticipants;

    public Session() {
        this.participants = new HashSet<Participant>();
        this.kahoots = new HashSet<Kahoot>();
        this.reponsesParticipants = new HashSet<ReponseParticipant>();
        this.score_final = 0;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public int getScore_final() {
        return score_final;
    }

    @OneToMany(mappedBy = "session")
    public Collection<Participant> getParticipants() {
        return participants;
    }

    @ManyToOne
    public Createur getCreateur() {
        return createur;
    }

    @OneToMany(mappedBy = "session")
    public Collection<Kahoot> getKahoots() {
        return kahoots;
    }

    @OneToMany(mappedBy = "session")
    public Collection<ReponseParticipant> getReponsesParticipants() {
        return reponsesParticipants;
    }

    public void setKahoots(Collection<Kahoot> kahoots) {
        this.kahoots = kahoots;
    }

    public void setCreateur(Createur createur) {
        this.createur = createur;
    }

    public void setParticipants(Collection<Participant> participants) {
        this.participants = participants;
    }

    public void setScore_final(int score_final) {
        this.score_final = score_final;
    }

    public void setReponsesParticipants(Collection<ReponseParticipant> reponsesParticipants) {
        this.reponsesParticipants = reponsesParticipants;
    }

}
