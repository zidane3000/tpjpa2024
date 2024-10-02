package entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class ReponseParticipant {
    private long id;
    private String text;
    private boolean isCorrect;
    private ReponsePossible reponsePossible;
    private Participant participant;
    private Session session;

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    @OneToOne
    public ReponsePossible getReponsePossible() {
        return reponsePossible;
    }

    public void setReponsePossible(ReponsePossible reponsePossible) {
        this.reponsePossible = reponsePossible;
    }

    @ManyToOne
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}