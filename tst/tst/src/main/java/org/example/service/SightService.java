package org.example.service;

import org.example.repository.SightRepository;
import org.example.sight.Sight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightService {
    @Autowired
    private SightRepository repository;
    public List<Sight> getSight(String zone){
        return repository.findByZoneLike(zone);
    }
}
