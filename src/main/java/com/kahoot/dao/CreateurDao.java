package com.kahoot.dao;

import com.kahoot.entity.Createur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CreateurDao extends JpaRepository<Createur, Long> {
    // Ajoutez des méthodes spécifiques à Createur si nécessaire
}