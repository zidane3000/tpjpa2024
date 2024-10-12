package com.kahoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kahoot.dao.ParticipantDao;
import com.kahoot.entity.Participant;

import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantDao participantDao;

    public List<Participant> getAllParticipants() {
        return participantDao.findAll();
    }

    public Participant saveParticipant(Participant participant) {
        return participantDao.save(participant);
    }
}