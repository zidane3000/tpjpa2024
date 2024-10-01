package entity;

import java.util.ArrayList;
import java.util.Collection;
import classAbstracts.Utilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import classAbstracts.Kahoot;

@Entity
public class Createur extends Utilisateur {

    private long idC;
    private Collection<Session> sessions;

    public Createur() {
        this.sessions = new ArrayList<>();
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


    public void creerSession(Session s){
        if (sessions == null) {
            sessions = new ArrayList<>();
        }
        this.sessions.add(s);
    }

}
