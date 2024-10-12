package com.kahoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahoot.entity.Participant;

public interface ParticipantDao extends JpaRepository<Participant,Long> {
   
}