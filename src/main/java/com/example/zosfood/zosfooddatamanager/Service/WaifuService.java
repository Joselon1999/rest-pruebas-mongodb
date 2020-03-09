package com.example.zosfood.zosfooddatamanager.Service;

import com.example.zosfood.zosfooddatamanager.Document.Waifu;
import com.example.zosfood.zosfooddatamanager.Repository.WaifuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaifuService {

    @Autowired
    WaifuRepository waifuRepository;

    public List<Waifu> findall(){return waifuRepository.findAll();}
    public Waifu save(Waifu waifu){return waifuRepository.save(waifu);}
    public void delete(String id){waifuRepository.deleteById(id);}
    public Optional<Waifu> findWaifuById(String id){
        return waifuRepository.findById(id);
    }
}
