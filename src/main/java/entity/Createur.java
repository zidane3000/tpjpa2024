package entity;

import java.util.Collection;

import org.hibernate.annotations.ManyToAny;

import classAbstracts.Utilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Createur extends Utilisateur {

    private long idC;
    private Collection<Session> sessions;

    public Createur() {
        super();
    }

    @Id
    @GeneratedValue
    public long getIdC() {
        return idC;
    }

    @OneToMany(mappedBy = "createur")
    public Collection<Session> getSessions() {
        return sessions;
    }

    public void setNom(String nom) {
        super.setNom(nom);
    }

    public void setPrenom(String prenom) {
        super.setPrenom(prenom);
    }

    public void setProfession(String profession) {
        super.setProfession(profession);
    }

    public void setIdC(long idC) {
        this.idC = idC;
    }

    public void setSessions(Collection<Session> sessions) {
        this.sessions = sessions;
    }



}
