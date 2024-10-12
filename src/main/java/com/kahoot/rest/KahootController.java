package com.kahoot.rest;

import com.kahoot.dto.KahootDTO;
import com.kahoot.entity.Kahoot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.kahoot.dao.KahootDao;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/kahoots")  // Base path for all methods
public class KahootController {

    @Autowired
    private KahootDao kahootDao;

    /**
     * GET /kahoots  --> Returns all Kahoots from the database.
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Kahoot>> getAllKahoots() {
        List<Kahoot> kahoots = kahootDao.findAll();
        return new ResponseEntity<>(kahoots, HttpStatus.OK);
    }

    /**
     * POST /kahoots/create  --> Creates a new Kahoot and saves it to the database.
     */
    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody KahootDTO kahootDTO) {
        try {
            Kahoot.Type kahootType = Kahoot.Type.valueOf(kahootDTO.getType().toUpperCase());
            Kahoot kahoot = new Kahoot(kahootDTO.getScore(), kahootDTO.getClassement(), kahootType, null);
            kahoot.setQuestion(kahootDTO.getQuestion());
            kahootDao.save(kahoot);
            String kahootId = String.valueOf(kahoot.getId());
            return new ResponseEntity<>("Kahoot created successfully with ID = " + kahootId, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error creating Kahoot: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * DELETE /kahoots/delete?id={id}  --> Deletes the Kahoot with the given ID.
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam long id) {
        try {
            Kahoot kahoot = new Kahoot();
            kahoot.setId(id);
            kahootDao.delete(kahoot);
            return new ResponseEntity<>("Kahoot deleted successfully!", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error deleting Kahoot: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO : a tester
    /**
     * GET /kahoots/get-by-question/{question}  --> Returns the ID of the Kahoot with the given question.
     */
    @GetMapping("/get-by-question/{question}")
    @ResponseBody
    public ResponseEntity<String> getByQuestion(@PathVariable("question") String question) {
        try {
            question = URLDecoder.decode(question, StandardCharsets.UTF_8);
            Kahoot kahoot = kahootDao.findByQuestion(question);
            String kahootId = String.valueOf(kahoot.getId());
            return new ResponseEntity<>("The ID of the Kahoot is: " + kahootId, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Kahoot not found", HttpStatus.NOT_FOUND);
        }
    }

     /**
     * PUT /kahoots/update  --> Updates the score, ranking, type, and question for the Kahoot in the database.
     */
    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<String> updateKahoot(@RequestParam long id, @RequestBody KahootDTO kahootDTO) {
        try {
            Kahoot kahoot = kahootDao.findById(id).orElseThrow(() -> new RuntimeException("Kahoot not found"));
            kahoot.setScore(kahootDTO.getScore());
            kahoot.setClassement(kahootDTO.getClassement());
            kahoot.setQuestion(kahootDTO.getQuestion());
            Kahoot.Type kahootType = Kahoot.Type.valueOf(kahootDTO.getType().toUpperCase());
            kahoot.setType(kahootType);
            kahootDao.save(kahoot);
            return new ResponseEntity<>("Kahoot updated successfully!", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error updating Kahoot: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
