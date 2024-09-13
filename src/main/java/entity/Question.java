package entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Question {

    private long id;
    private String text;
    @OneToMany(mappedBy = "question")
    private List<Reponse> reponses;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }
}
