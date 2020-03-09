package com.example.zosfood.zosfooddatamanager.Service;

import com.example.zosfood.zosfooddatamanager.Document.Pikachu;
import com.example.zosfood.zosfooddatamanager.Repository.PikachuRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PikachuService {
    @Autowired
    PikachuRepositoty pikachuRepositoty;

    public List<Pikachu> findAll(){return pikachuRepositoty.findAll();}
    public Pikachu save(Pikachu pikachu){return pikachuRepositoty.save(pikachu);}
    public void delete(String id){pikachuRepositoty.deleteById(id);}
    public Optional<Pikachu> findPikachuById(String id){return pikachuRepositoty.findById(id);}
}
