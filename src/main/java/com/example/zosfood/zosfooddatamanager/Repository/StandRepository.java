package com.example.zosfood.zosfooddatamanager.Repository;

import com.example.zosfood.zosfooddatamanager.Document.Stand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandRepository extends MongoRepository<Stand,String> {
}
