package com.kahoot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.kahoot.dto.KahootDTO;
import com.kahoot.service.KahootService;

import java.util.List;

@Controller
@RequestMapping("/kahoots")
public class KahootController {

    @Autowired
    private KahootService kahootService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<KahootDTO>> getAllKahoots() {
        List<KahootDTO> kahoots = kahootService.getAllKahoots();
        return ResponseEntity.ok(kahoots);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<KahootDTO> create(@RequestBody KahootDTO kahootDTO) {
        KahootDTO createdKahoot = kahootService.createKahoot(kahootDTO);
        return ResponseEntity.ok(createdKahoot);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<Void> delete(@RequestParam long id) {
        kahootService.deleteKahoot(id);
        return ResponseEntity.noContent().build();
    }

    

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<KahootDTO> updateKahoot(@RequestParam long id, @RequestBody KahootDTO kahootDTO) {
        KahootDTO updatedKahoot = kahootService.updateKahoot(id, kahootDTO);
        return ResponseEntity.ok(updatedKahoot);
    }
}