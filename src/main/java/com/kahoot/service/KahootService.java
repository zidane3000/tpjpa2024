package com.kahoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kahoot.dao.KahootDao;
import com.kahoot.dto.KahootDTO;
import com.kahoot.entity.Kahoot;
import com.kahoot.mapper.KahootMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KahootService {

    public String getKahootMessage() {
        return "Hello from KahootService";
    }
    @Autowired
    private KahootDao kahootDao;

    @Autowired
    private KahootMapper kahootMapper;

    @Transactional
    public List<KahootDTO> getAllKahoots() {
        List<Kahoot> kahoots = kahootDao.findAll();
        return kahoots.stream()
                      .map(kahootMapper::kahootToKahootDTO)
                      .collect(Collectors.toList());
    }

    @Transactional
    public KahootDTO createKahoot(KahootDTO kahootDTO) {
        Kahoot kahoot = kahootMapper.kahootDTOToKahoot(kahootDTO);
        kahoot = kahootDao.save(kahoot);
        return kahootMapper.kahootToKahootDTO(kahoot);
    }

    @Transactional
    public void deleteKahoot(long id) {
        kahootDao.deleteById(id);
    }

    @Transactional
    public KahootDTO updateKahoot(long id, KahootDTO kahootDTO) {
        Kahoot kahoot = kahootMapper.kahootDTOToKahoot(kahootDTO);
        kahoot.setId(id);
        kahoot = kahootDao.save(kahoot);
        return kahootMapper.kahootToKahootDTO(kahoot);
    }

    
}