package org.example.repository;

import org.example.sight.Sight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SightRepository extends MongoRepository<Sight,String> {
    List<Sight> findByZoneLike(String zone);
}
