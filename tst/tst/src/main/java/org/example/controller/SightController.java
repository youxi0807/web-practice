package org.example.controller;

import org.example.service.SightService;
import org.example.sight.Sight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SightController {
    @Autowired
    private SightService sightService;
    @GetMapping("/SightAPI")
    public ResponseEntity<List<Sight>> getSights(@RequestParam("zone") String zone){
        List<Sight> sights = sightService.getSight(zone + "區");
        return ResponseEntity.ok(sights);
    }
}
