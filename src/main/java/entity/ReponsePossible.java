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

    
    public ReponsePossible() {
    }

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

    public void setId(long id) {
        this.id = id;
    }

    public void setReponses(Set<String> reponses) {
        this.reponses = reponses;
    }

    public void setKahoot(Kahoot kahoot) {
        this.kahoot = kahoot;
    }

    public void addReponse(String reponse) {
        this.reponses.add(reponse);
    }


}
