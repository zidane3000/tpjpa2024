package com.kahoot.rest;

import com.kahoot.entity.Session;
import com.kahoot.dao.SessionDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/sessions")  // Base path for all methods
public class SessionController {

    @Autowired
    private SessionDao sessionDao;

    /**
     * GET /sessions  --> Returns all Sessions from the database.
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Session>> getAllSessions() {
        try {
            List<Session> sessions = sessionDao.findAll();
            return new ResponseEntity<>(sessions, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * POST /sessions/create  --> Creates a new Session and saves it to the database.
     */
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody Session session) {
        try {
            sessionDao.save(session);
            String sessionId = String.valueOf(session.getId());
            return new ResponseEntity<>("Session created successfully with ID = " + sessionId, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error creating Session: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * DELETE /sessions/delete?id={id}  --> Deletes the Session with the given ID.
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam long id) {
        try {
            Session session = new Session();
            session.setId(id);
            sessionDao.delete(session);
            return new ResponseEntity<>("Session deleted successfully!", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error deleting Session: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * GET /sessions/get-by-id/{id}  --> Returns the Session with the given ID.
     */
    @GetMapping("/get-by-id/{id}")
    @ResponseBody
    public ResponseEntity<Session> getById(@PathVariable("id") long id) {
        try {
            Session session = sessionDao.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
            return new ResponseEntity<>(session, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * PUT /sessions/update  --> Updates the details of the Session in the database.
     */
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<String> updateSession(@RequestParam long id, @RequestBody Session sessionDetails) {
        try {
            Session session = sessionDao.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
            session.setPIN(sessionDetails.getPIN());
            session.setScore_final(sessionDetails.getScore_final());
            session.setCreateur(sessionDetails.getCreateur());
            session.setParticipants(sessionDetails.getParticipants());
            session.setKahoots(sessionDetails.getKahoots());
            session.setReponsesParticipants(sessionDetails.getReponsesParticipants());
            sessionDao.save(session);
            return new ResponseEntity<>("Session updated successfully!", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error updating Session: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}