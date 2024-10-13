package kahoot.domain;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Participant extends Utilisateur {

    private long id;
    private Kahoot kahoot;
    private int scoreTotal;

    private List<ReponseParticipant> reponseParticipants;

    public Participant() {
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

    @ManyToOne
    @JoinColumn(nullable = false)
    public Kahoot getKahoot() {
        return kahoot;
    }

    @OneToMany(mappedBy = "participant", fetch = FetchType.LAZY)
    public List<ReponseParticipant> getReponseParticipants() {
        return reponseParticipants;
    }

    public void setReponseParticipants(List<ReponseParticipant> reponseParticipants) {
        this.reponseParticipants = reponseParticipants;
    }

    public void setKahoot(Kahoot kahoot) {
        this.kahoot = kahoot;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }
}