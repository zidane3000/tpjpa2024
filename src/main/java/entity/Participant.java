package entity;

import classAbstracts.Utilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Participant extends Utilisateur {

    private long idP;

    @Id
    @GeneratedValue
    public long getIdP() {
        return idP;
    }

}
