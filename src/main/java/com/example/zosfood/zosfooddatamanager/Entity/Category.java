package com.example.zosfood.zosfooddatamanager.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Category {

    @Id
    private int id;
    private String nombre;
    private String descripcion;
    private List<Usuario> usuarios;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Category(int id, String nombre, String descripcion, List<Usuario> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarios = usuarios;
    }

    public Category() {
    }
}