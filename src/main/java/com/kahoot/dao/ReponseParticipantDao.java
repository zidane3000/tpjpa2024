package com.kahoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahoot.entity.ReponseParticipant;

public interface ReponseParticipantDao extends JpaRepository<ReponseParticipant, Long> {
    // Ajoutez des méthodes spécifiques à ReponseParticipant si nécessaire
    
}
