package com.example.zosfood.zosfooddatamanager.Controller;

import com.example.zosfood.zosfooddatamanager.Document.Waifu;
import com.example.zosfood.zosfooddatamanager.Service.WaifuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WaifuController {
    @Autowired
    WaifuService waifuService;

    @GetMapping("/waifus")
    public List<Waifu> listarWaifus(){
        return waifuService.findall();
    }
}
