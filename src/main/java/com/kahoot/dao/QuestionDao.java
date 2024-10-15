package com.kahoot.dao;

import com.kahoot.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface QuestionDao extends JpaRepository<Question, Long> {
    // Ajoutez des méthodes spécifiques à Question si nécessaire
}