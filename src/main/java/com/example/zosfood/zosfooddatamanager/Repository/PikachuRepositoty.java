package com.example.zosfood.zosfooddatamanager.Repository;

import com.example.zosfood.zosfooddatamanager.Entity.Pikachu;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PikachuRepositoty extends MongoRepository<Pikachu, String> {
}
