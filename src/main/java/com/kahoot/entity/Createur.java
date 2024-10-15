package com.kahoot.entity;


import java.util.Collection;

import jakarta.persistence.*;

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


    @OneToMany(mappedBy = "createur" , fetch = FetchType.LAZY)
    public Collection<Kahoot> getKahoots() {
        return kahoots;
    }

    public void setKahoots(Collection<Kahoot> kahoots) {
        this.kahoots = kahoots;
    }

}