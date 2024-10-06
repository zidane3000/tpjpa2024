package service;

import domain.Kahoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface KahootDao extends JpaRepository<Kahoot, Long> {

    public Kahoot findByQuestion(String question);

}
