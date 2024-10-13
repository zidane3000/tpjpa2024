package kahoot.dto;

import java.util.Date;

public class ReponseParticipantDTO {

    private long id;
    private Date date;
    private int score;
    private long participant_id;
    private long reponsePossible_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(long participant_id) {
        this.participant_id = participant_id;
    }

    public long getReponsePossible_id() {
        return reponsePossible_id;
    }

    public void setReponsePossible_id(long reponsePossible_id) {
        this.reponsePossible_id = reponsePossible_id;
    }
}
