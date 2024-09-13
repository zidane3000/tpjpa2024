package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reponse {
    private long id;
    private String text;
    private boolean isCorrect;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Participant participant;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public Question getQuestion() {
        return question;
    }

    public Participant getParticipant() {
        return participant;
    }
}