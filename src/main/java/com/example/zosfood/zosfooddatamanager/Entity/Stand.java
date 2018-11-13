package com.example.zosfood.zosfooddatamanager.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stand")
public class Stand {

    @Id
    int id;
    String nombre;
    String habilidad;
    Usuario usuario;

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

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Stand(int id, String nombre, String habilidad, Usuario usuario) {
        this.id = id;
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.usuario = usuario;
    }

    public Stand() {
    }
}
