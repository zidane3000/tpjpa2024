package com.kahoot.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kahoot.dao.KahootDao;
import com.kahoot.entity.Kahoot;

@Service
public class KahootService {

    public String getKahootMessage() {
        return "Hello to Kahoot!";
    }

    @Autowired
    private KahootDao kahootDao;

    public List<Kahoot> getAllKahoots() {
        return kahootDao.findAll();
    }

    public Kahoot saveKahoot(Kahoot kahoot) {
        return kahootDao.save(kahoot);
    }

    public void deleteKahoot(long id) {
        Kahoot kahoot = new Kahoot();
        kahoot.setId(id);
        kahootDao.delete(kahoot);
    }

    public Kahoot getKahoot(long id) {
        return kahootDao.findById(id).orElse(null);
    }

    public Kahoot updateKahoot(Kahoot kahoot) {
        return kahootDao.save(kahoot);
    }

    

    
    
}
