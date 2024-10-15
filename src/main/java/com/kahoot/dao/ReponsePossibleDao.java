package com.kahoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahoot.entity.ReponsePossible;

public interface ReponsePossibleDao extends JpaRepository<ReponsePossible, Long> {
    // Ajoutez des méthodes spécifiques à ReponsePossible si nécessaire
    
}
