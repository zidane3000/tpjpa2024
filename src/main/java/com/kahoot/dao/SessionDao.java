package com.kahoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kahoot.entity.Session;

public interface SessionDao extends JpaRepository<Session,Long> {
   
}