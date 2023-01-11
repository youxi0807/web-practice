package org.example;

import org.example.crawler.KeelungSightsCrawler;
import org.example.repository.SightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements ApplicationRunner {
    @Autowired
    private SightRepository repository;
    @Autowired
    private KeelungSightsCrawler crawler;
    @Override
    public void run(ApplicationArguments args) throws Exception{
        repository.saveAll(crawler.getAllSights());
        crawler.clearAllSights();
    }
}
