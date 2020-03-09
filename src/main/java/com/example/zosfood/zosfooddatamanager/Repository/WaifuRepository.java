package com.example.zosfood.zosfooddatamanager.Repository;

import com.example.zosfood.zosfooddatamanager.Document.Waifu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaifuRepository extends MongoRepository<Waifu, String>{
}
