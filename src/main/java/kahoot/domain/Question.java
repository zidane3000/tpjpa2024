package kahoot.domain;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Question implements Serializable {

    public enum TypeQuestion {
        CHOIX_MULTIPLES, REPONSE_COURTE
    }

    private long id;
    private TypeQuestion typeQuestion;
    private String texteQuestion;

    private Kahoot kahoot;
    private Collection<ReponsePossible> reponsesPossibles;

    public Question() {}

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getTexteQuestion() {
        return texteQuestion;
    }

    public void setTexteQuestion(String texteQuestion) {
        this.texteQuestion = texteQuestion;
    }

    @ManyToOne
    public Kahoot getKahoot() {
        return kahoot;
    }

    public void setKahoot(Kahoot kahoot) {
        this.kahoot = kahoot;
    }

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    public Collection<ReponsePossible> getReponsesPossibles() {
        return reponsesPossibles;
    }

    public void setReponsesPossibles(Collection<ReponsePossible> reponsesPossibles) {
        this.reponsesPossibles = reponsesPossibles;
    }
}