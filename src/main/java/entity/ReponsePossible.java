package entity;

import java.util.HashSet;
import java.util.Set;

import classAbstracts.Kahoot;
import jakarta.persistence.*;

@Entity
public class ReponsePossible {

    private long id;
    private String reponses;
    private Kahoot kahoot;

    public ReponsePossible() {
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    
    public String getReponses() {
        return reponses;
    }

    public void setReponses(String reponses) {
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
