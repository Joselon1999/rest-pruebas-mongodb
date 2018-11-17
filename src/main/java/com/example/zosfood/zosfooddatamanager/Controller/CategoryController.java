package com.example.zosfood.zosfooddatamanager.Controller;

import com.example.zosfood.zosfooddatamanager.Entity.Category;
import com.example.zosfood.zosfooddatamanager.Entity.Stand;
import com.example.zosfood.zosfooddatamanager.Entity.Usuario;
import com.example.zosfood.zosfooddatamanager.Service.CategoryService;
import com.example.zosfood.zosfooddatamanager.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/category")
    public List<Category> findAll(){
        return categoryService.findAll();
    }


    @GetMapping("/category/{id}")
    public Category retrieveCategory(@PathVariable String id){
        Optional<Category> category = categoryService.findCategoryById(id);
        if (!category.isPresent()){
            return null;
        }else {
            return category.get();
        }
    }
    @PostMapping("/addCategory")
    public String newCategory(@RequestBody Category category){
        Category category1 = categoryService.save(category);
        return "Se creo la categoria con ID: "+category1.getId();
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable String id){
        categoryService.delete(id);
        return "Categoria Eliminada: "+id;
    }

    @PutMapping("/books")
    public String updateBook(@RequestBody Category category){
        categoryService.save(category);
        return "Categoria actualizada";
    }

    @GetMapping("/categories/{id}")
    public String updateById(@PathVariable int id,@RequestBody Category category){
        Optional<Category> findCat = categoryService.findCategoryById(String.valueOf(id));
        if (!findCat.isPresent()){
            return "No se encontro el id:"+id;
        }else {
            category.setId(id);
            categoryService.save(category);
            return "Listo ;v";
        }

    }


}
