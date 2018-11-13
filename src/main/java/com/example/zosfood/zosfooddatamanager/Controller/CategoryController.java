package com.example.zosfood.zosfooddatamanager.Controller;

import com.example.zosfood.zosfooddatamanager.Entity.Category;
import com.example.zosfood.zosfooddatamanager.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> findAll(){
        return categoryService.findAll();
    }


    @GetMapping("/fill")
    public String setValues(){
        categoryService.save(new Category(1,"Jojo's Part 1","Phantom Blood"));
        categoryService.save(new Category(2,"Jojo's Part 2","Battle Tendency"));
        categoryService.save(new Category(2,"Jojo's Part 3","Stardust Crusaders"));
        categoryService.save(new Category(2,"Jojo's Part 4","Diamond is Unbreakable"));
        categoryService.save(new Category(2,"Jojo's Part 5","Vento Aureo"));
        return "Listo Papuh";
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
