package com.example.VeterinariaProyectoBack.services;

import java.util.List;
import java.util.Optional;

import com.example.VeterinariaProyectoBack.entity.Usuario;
import com.example.VeterinariaProyectoBack.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/buscar")
    public List<Usuario> getAllUsuario(){
        return usuarioRepository.findAll();
    }

    @PostMapping("/guardar")
    public Usuario saveUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteUsuario(@PathVariable ("id") int id){
        Optional<Usuario> usuario;
        usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            usuarioRepository.delete(usuario.get());
        }
    }
    
}
