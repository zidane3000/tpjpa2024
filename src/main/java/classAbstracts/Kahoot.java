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
    private String question;

    public Kahoot() {
    }

    public int getScore() {
        return score;
    }

    public int getClassement() {
        return classement;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public void setScore(int score) {
        this.score = score;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setReponsesPossibles(Collection<ReponsePossible> reponsesPossibles) {
        this.reponsesPossibles = reponsesPossibles;
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
    }

}
