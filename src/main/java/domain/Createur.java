package domain;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Createur extends Utilisateur {

    private long id;
    private Collection<Kahoot> kahoots;

    public Createur() {
        super();
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "createur")
    public Collection<Kahoot> getKahoots() {
        return kahoots;
    }

    public void setKahoots(Collection<Kahoot> kahoots) {
        this.kahoots = kahoots;
    }

}
