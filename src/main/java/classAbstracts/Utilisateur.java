package classAbstracts;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
public abstract class Utilisateur implements Serializable {

    private String nom, prenom;

    private String profession;

    private String email, motDePasse;


    public String getNom(){
        return nom;
    };

    public String getPrenom() {
        return prenom;
    }

    public String getProfession() {
        return profession;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
