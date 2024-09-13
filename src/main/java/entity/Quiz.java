package entity;

import classAbstracts.Kahoot;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Quiz extends Kahoot {

    private long idQ;

    @Id
    @GeneratedValue
    public long getIdQ() {
        return idQ;
    }
}
