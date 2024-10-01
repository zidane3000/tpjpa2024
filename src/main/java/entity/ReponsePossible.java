package entity;

import java.util.HashSet;
import java.util.Set;

import classAbstracts.Kahoot;
import jakarta.persistence.*;

@Entity
public class ReponsePossible {

    private long id;
    private Set<String> reponses;
    private Kahoot kahoot;

    public ReponsePossible() {
        this.reponses = new HashSet<String>();
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    @ElementCollection
    public Set<String> getReponses() {
        return reponses;
    }

    public void setReponses(Set<String> reponses) {
        this.reponses = reponses;
    }

    public void setKahoot(Kahoot kahoot) {
        this.kahoot = kahoot;
    }

    @ManyToOne
    public Kahoot getKahoot() {
        return kahoot;
    }

}
