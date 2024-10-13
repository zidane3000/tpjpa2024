package kahoot.dto;

public class ParticipantDTO extends UtilisateurDTO{
    private int scoreTotal;
    private long kahoot_id;

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public long getKahoot_id() {
        return kahoot_id;
    }

    public void setKahoot_id(long kahoot_id) {
        this.kahoot_id = kahoot_id;
    }
}
