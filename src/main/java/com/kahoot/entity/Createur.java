package com.kahoot.entity;


import java.util.Collection;

import jakarta.persistence.*;

@Entity
public class Createur extends Utilisateur {

    
    private Collection<Kahoot> kahoots;



    @OneToMany(mappedBy = "createur" , fetch = FetchType.LAZY)
    public Collection<Kahoot> getKahoots() {
        return kahoots;
    }

    public void setKahoots(Collection<Kahoot> kahoots) {
        this.kahoots = kahoots;
    }

}