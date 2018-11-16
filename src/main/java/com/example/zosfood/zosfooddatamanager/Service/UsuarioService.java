package com.example.zosfood.zosfooddatamanager.Service;

import com.example.zosfood.zosfooddatamanager.Entity.Usuario;
import com.example.zosfood.zosfooddatamanager.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //MongoRepository usa CrudRepository por lo que el Delete pide un valor STRING
    public void delete(String id){
        usuarioRepository.deleteById(id);
    }

    //MongoRepository usa CrudRepository por lo que el FindBy pide un valor STRING
    public Optional<Usuario> findUsuarioById(String id){
        return usuarioRepository.findById(id);
    }

}
