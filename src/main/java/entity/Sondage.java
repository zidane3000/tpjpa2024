package entity;

import classAbstracts.Kahoot;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Sondage extends Kahoot {

    private long idS;

    @Id
    @GeneratedValue
    public long getIdS() {
        return idS;
    }
}
