package com.example.zosfood.zosfooddatamanager.Controller;

import com.example.zosfood.zosfooddatamanager.Entity.Pikachu;
import com.example.zosfood.zosfooddatamanager.Service.PikachuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PikachuController {
    @Autowired
    PikachuService pikachuService;

    @GetMapping("/pikachus")
    public List<Pikachu> listarTodo(){
        return pikachuService.findAll();
    }
}
