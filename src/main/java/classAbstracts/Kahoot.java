package classAbstracts;

import java.util.Collection;

import entity.ReponsePossible;
import entity.Session;
import jakarta.persistence.*;

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
    public Kahoot(int score, int classement, Type type, Session session) {
        this.score = score;
        this.classement = classement;
        this.type = type;
        this.session = session;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setReponsesPossibles(Collection<ReponsePossible> reponsesPossibles) {
        this.reponsesPossibles = reponsesPossibles;
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

    @OneToMany(mappedBy = "kahoot", cascade = CascadeType.ALL)
    public Collection<ReponsePossible> getReponsesPossibles() {
        return reponsesPossibles;
    }

    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
    }
}
