package kahoot.dto;

import kahoot.domain.Kahoot;
import kahoot.domain.Question;
import kahoot.domain.ReponsePossible;

import java.util.Collection;

public class QuestionDTO {
    private long id;
    private Question.TypeQuestion typeQuestion;
    private String texteQuestion;

    private long kahoot_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getKahoot_id() {
        return kahoot_id;
    }

    public void setKahoot_id(long kahoot_id) {
        this.kahoot_id = kahoot_id;
    }

    public Question.TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(Question.TypeQuestion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getTexteQuestion() {
        return texteQuestion;
    }

    public void setTexteQuestion(String texteQuestion) {
        this.texteQuestion = texteQuestion;
    }
}
