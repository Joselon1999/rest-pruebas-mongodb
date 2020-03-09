package com.example.zosfood.zosfooddatamanager.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pikachu {
    @Id
    int id;
    String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pikachu(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Pikachu() {
    }
}
