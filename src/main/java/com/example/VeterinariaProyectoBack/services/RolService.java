package com.example.VeterinariaProyectoBack.services;

import java.util.List;
import java.util.Optional;

import com.example.VeterinariaProyectoBack.entity.Rol;
import com.example.VeterinariaProyectoBack.repository.RolRepository;

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
@RequestMapping("/rol")
@CrossOrigin
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/buscar")
    public List<Rol> getAllRol(){
        return rolRepository.findAll();
    }

    @PostMapping("/guardar")
    public Rol saveRol(@RequestBody Rol rol){
        return rolRepository.save(rol);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteRol(@PathVariable ("id") int id){
        Optional<Rol> rol;
        rol = rolRepository.findById(id);
        if(rol.isPresent()){
            rolRepository.delete(rol.get());
        }
    }
    
}
