package entity;

import java.util.Set;

import classAbstracts.Kahoot;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ReponsePossible {

    private long id;
    private Set<String> reponses;

    private Kahoot kahoot;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public Set<String> getReponses() {
        return reponses;
    }

    @ManyToOne
    public Kahoot getKahoot() {
        return kahoot;
    }

}
