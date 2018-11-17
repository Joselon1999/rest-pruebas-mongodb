package com.example.zosfood.zosfooddatamanager.Controller;

import com.example.zosfood.zosfooddatamanager.Service.CategoryService;
import com.example.zosfood.zosfooddatamanager.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Arrays;

@Controller
public class HomeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public String index(){
        return "index";
    }


}
