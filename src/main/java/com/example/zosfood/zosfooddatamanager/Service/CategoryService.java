package com.example.zosfood.zosfooddatamanager.Service;

import com.example.zosfood.zosfooddatamanager.Entity.Category;
import com.example.zosfood.zosfooddatamanager.Entity.Usuario;
import com.example.zosfood.zosfooddatamanager.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    //MongoRepository usa CrudRepository por lo que el Delete pide un valor STRING
    public void delete(String id){
        categoryRepository.deleteById(id);
    }

    //MongoRepository usa CrudRepository por lo que el FindBy pide un valor STRING
    public Optional<Category> findCategoryById(String id){
        return categoryRepository.findById(id);
    }

}

