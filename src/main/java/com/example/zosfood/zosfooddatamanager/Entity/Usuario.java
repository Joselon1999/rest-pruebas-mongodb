package com.example.zosfood.zosfooddatamanager.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {

    @Id
    int id;
    String nombres;
    Stand stand;
    Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Usuario(int id, String nombres, Stand stand, Category category) {
        this.id = id;
        this.nombres = nombres;
        this.stand = stand;
        this.category = category;
    }

    public Usuario() {
    }
}
