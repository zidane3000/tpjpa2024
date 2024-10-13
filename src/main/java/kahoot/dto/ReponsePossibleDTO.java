package kahoot.dto;

public class ReponsePossibleDTO {
    private long id;
    private String texteReponse;
    private boolean correct;
    private long question_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexteReponse() {
        return texteReponse;
    }

    public void setTexteReponse(String texteReponse) {
        this.texteReponse = texteReponse;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }
}
