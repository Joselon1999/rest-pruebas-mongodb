package com.example.zosfood.zosfooddatamanager.Repository;

import com.example.zosfood.zosfooddatamanager.Document.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
}
