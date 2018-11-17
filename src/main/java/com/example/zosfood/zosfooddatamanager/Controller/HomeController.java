package com.example.zosfood.zosfooddatamanager.Controller;

import com.example.zosfood.zosfooddatamanager.Entity.Category;
import com.example.zosfood.zosfooddatamanager.Entity.Stand;
import com.example.zosfood.zosfooddatamanager.Entity.Usuario;
import com.example.zosfood.zosfooddatamanager.Service.CategoryService;
import com.example.zosfood.zosfooddatamanager.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class HomeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/fill")
    public String setValues(){
        categoryService.save(new Category(1,"Jojo's Part 1","Phantom Blood"));
        usuarioService.save(new Usuario(1,"Jhonatan Joestar",new Stand(1,"Goodest Boi","Being Best JOJO")));
        categoryService.save(new Category(2,"Jojo's Part 2","Battle Tendency"));
        usuarioService.save(new Usuario(1,"Jhoseph Joestar",new Stand(1,"Hermit Purple","Crash planes and NIGERUNDAYO")));
        categoryService.save(new Category(3,"Jojo's Part 3","Stardust Crusaders"));
        usuarioService.save(new Usuario(1,"Jotaro Kuyo",new Stand(1,"Star Platinum","Fucks dolphins and can stop time sometimes")));
        categoryService.save(new Category(4,"Jojo's Part 4","Diamond is Unbreakable"));
        usuarioService.save(new Usuario(1,"Josuke Higashikata",new Stand(1,"Crazy Diamond","As useless as Joseph but GRATO DAZE")));
        categoryService.save(new Category(5,"Jojo's Part 5","Vento Aureo"));
        usuarioService.save(new Usuario(1,"Giorno Giovanna",new Stand(1,"Gold Experience","Brings shit to life and drinks piss")));
        return "Listo Papuh";
    }
}
