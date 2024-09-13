package entity;

import classAbstracts.Kahoot;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class Session {

    private long PIN;
    private int score_final;
    private int classement_final;

    private Collection<Kahoot> kahoots;

    @Id
    @GeneratedValue
    public long getPIN() {
        return PIN;
    }

    public int getScore_final() {
        return score_final;
    }

    public int getClassement_final() {
        return classement_final;
    }

    @OneToMany
    public Collection<Kahoot> getKahoots() {
        return kahoots;
    }
}
