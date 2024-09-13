package entity;

import classAbstracts.Utilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Createur extends Utilisateur {

    private long idC;

    @Id
    @GeneratedValue
    public long getIdC() {
        return idC;
    }
}
