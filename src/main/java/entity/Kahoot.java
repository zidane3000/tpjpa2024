package entity;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Kahoot")
@Entity
public class Kahoot implements Serializable {
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
    public Kahoot(int score, int classement, Type type, Session session) {
        this.score = score;
        this.classement = classement;
        this.type = type;
        this.session = session;
    }

    @XmlElement(name = "id")
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "session")
    @ManyToOne
    public Session getSession() {
        return session;
    }


    @XmlElementWrapper(name = "reponsesPossibles")
    @XmlElement(name = "reponsesPossibles")
    @OneToMany(mappedBy = "kahoot", cascade = CascadeType.ALL)
    public Collection<ReponsePossible> getReponsesPossibles() {
        return reponsesPossibles;
    }

    @XmlElement(name = "type")
    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
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

    public void setReponsesPossibles(Collection<ReponsePossible> reponsesPossibles) {
        this.reponsesPossibles = reponsesPossibles;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @XmlElement(name = "score")
    public int getScore() {
        return score;
    }

    @XmlElement(name = "classement")
    public int getClassement() {
        return classement;
    }

    @XmlElement(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
