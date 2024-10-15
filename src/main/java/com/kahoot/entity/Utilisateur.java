package com.kahoot.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public abstract class Utilisateur implements Serializable {

    private long id;
    private String surnom;

    @Id@GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }
}