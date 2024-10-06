package com.kahoot.entity;

import java.util.ArrayList;
import java.util.Collection;

import com.kahoot.entity.classAbstracts.Utilisateur;
import jakarta.persistence.*;

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

    public void setIdC(long idC) {
        this.idC = idC;
    }

    @OneToMany(mappedBy = "createur", fetch = FetchType.EAGER)
    public Collection<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Collection<Session> sessions) {
        this.sessions = sessions;
    }


    public void creerSession(Session s){
        if (sessions == null) {
            sessions = new ArrayList<>();
        }
        this.sessions.add(s);
    }

}
