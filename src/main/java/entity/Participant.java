package entity;

import java.util.ArrayList;
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
    private List<ReponseParticipant> reponsesParticipant;
    private Session session;
    private int scoreTotal;

    public Participant() {
        this.reponsesParticipant = new ArrayList<>();
    }


    @Id
    @GeneratedValue
    public long getIdP() {
        return idP;
    }

    @OneToMany(mappedBy = "participant")
    public List<ReponseParticipant> getReponseParticipant() {
        return reponsesParticipant;
    }

    @ManyToOne
    public Session getSession() {
        return session;
    }

    public void setReponseParticipant(List<ReponseParticipant> reponseParticipant) {
        this.reponsesParticipant = reponseParticipant;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public void addReponse(ReponseParticipant reponse) {
        if (reponsesParticipant == null) {
            reponsesParticipant = new ArrayList<>();
        }
        this.reponsesParticipant.add(reponse);
    }
}
