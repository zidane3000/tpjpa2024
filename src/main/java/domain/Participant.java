package domain;

import java.util.ArrayList;
import java.util.List;

import domain.classAbstracts.Utilisateur;
import jakarta.persistence.*;

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



    public void setIdP(long idP) {
        this.idP = idP;
    }

    @OneToMany(mappedBy = "participant")
    public List<ReponseParticipant> getReponsesParticipant() {
        return reponsesParticipant;
    }

    @ManyToOne
    public Session getSession() {
        return session;
    }

    public void setReponsesParticipant(List<ReponseParticipant> reponseParticipant) {
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
