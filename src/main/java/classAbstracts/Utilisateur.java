package classAbstracts;


public abstract class Utilisateur {

    private String nom;
    private String prenom;

    private String profession;

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
    
}
