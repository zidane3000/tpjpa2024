package entity;

import classAbstracts.Kahoot;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class Session {

    private long id;
    private int PIN;
    private int score_final;
    private int classement_final;

    private Createur createur;
    private Collection<Participant> participants;
    private Collection<Kahoot> kahoots;
    private Collection<ReponseParticipant> reponseParticipant;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public int getPIN() {
        return PIN;
    }

    public int getScore_final() {
        return score_final;
    }

    public int getClassement_final() {
        return classement_final;
    }
    @OneToMany
    public Collection<Participant> getParticipants() {
        return participants;
    }
    @ManyToOne
    public Createur getCreateur() {
        return createur;
    }

    @OneToMany
    public Collection<Kahoot> getKahoots() {
        return kahoots;
    }

    @OneToMany
    public Collection<ReponseParticipant> getReponseParticipant() {
        return reponseParticipant;
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

    public void setClassement_final(int classement_final) {
        this.classement_final = classement_final;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setReponseParticipant(Collection<ReponseParticipant> reponseParticipant) {
        this.reponseParticipant = reponseParticipant;
    }

    public void setScore_final(int score_final) {
        this.score_final = score_final;
    }



}
