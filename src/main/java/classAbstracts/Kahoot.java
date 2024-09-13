package classAbstracts;

import entity.Session;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public abstract class Kahoot {

    private long id;
    private int score;
    private int classement;

    private Session session;

    public int getScore() {
        return score;
    }

    public int getClassement() {
        return classement;
    }

    @ManyToOne
    public Session getSession() {
        return session;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }
}
