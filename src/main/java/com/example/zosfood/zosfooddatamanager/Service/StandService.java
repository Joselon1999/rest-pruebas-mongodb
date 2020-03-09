package com.example.zosfood.zosfooddatamanager.Service;

import com.example.zosfood.zosfooddatamanager.Document.Stand;
import com.example.zosfood.zosfooddatamanager.Repository.StandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandService {

    @Autowired
    private StandRepository standRepository;

    public List<Stand> findAll(){
        return standRepository.findAll();
    }

    public Stand save(Stand stand){
        return standRepository.save(stand);
    }

    //MongoRepository usa CrudRepository por lo que el Delete pide un valor STRING
    public void delete(String id){
        standRepository.deleteById(id);
    }

    //MongoRepository usa CrudRepository por lo que el FindBy pide un valor STRING
    public Optional<Stand> findStandById(String id){
        return standRepository.findById(id);
    }
}
