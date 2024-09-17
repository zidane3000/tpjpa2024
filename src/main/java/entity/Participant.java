package entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import classAbstracts.Utilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Participant extends Utilisateur {

    private long idP;
    private List<ReponseParticipant> reponseParticipant;
    private Session session;

    @Id
    @GeneratedValue
    public long getIdP() {
        return idP;
    }

    @OneToMany(mappedBy = "participant")
    public List<ReponseParticipant> getReponseParticipant() {
        return reponseParticipant;
    }

    @ManyToOne
    public Session getSession() {
        return session;
    }

    public void setIdP(long idP) {
        this.idP = idP;
    }

    public void setReponseParticipant(List<ReponseParticipant> reponseParticipant) {
        this.reponseParticipant = reponseParticipant;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    

}
