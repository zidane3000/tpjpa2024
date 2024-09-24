package classAbstracts;

import java.util.Collection;

import entity.ReponsePossible;
import entity.Session;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Kahoot {
    public enum Type {
        QUIZ, SONDAGE
    }
    private long id;
    private int score;
    private int classement;
    private Type type;
    private Session session;
    private Collection<ReponsePossible> reponsesPossibles;

    public Kahoot() {
    }

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

    @OneToMany(mappedBy = "kahoot")
    public Collection<ReponsePossible> getReponsesPossibles() {
        return reponsesPossibles;
    }

    public String getType() {
        return type.toString();
    }
}
