package com.example.zosfood.zosfooddatamanager.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Waifu {

    @Id
    int id;
    String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Waifu(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Waifu() {
    }
}
