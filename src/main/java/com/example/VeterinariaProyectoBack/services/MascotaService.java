package com.example.VeterinariaProyectoBack.services;

import java.util.List;
import java.util.Optional;

import com.example.VeterinariaProyectoBack.entity.Mascota;
import com.example.VeterinariaProyectoBack.repository.MascotaRepository;

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
@RequestMapping("/mascota")
@CrossOrigin
public class MascotaService {

    
    @Autowired
    private MascotaRepository mascotaRepository;

    @GetMapping("/buscar")
    public List<Mascota> getAllMascota(){
        return mascotaRepository.findAll();
    }

    @PostMapping("/guardar")
    public Mascota saveMascota(@RequestBody Mascota mascota){
        return mascotaRepository.save(mascota);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteMascota(@PathVariable ("id") int id){
        Optional<Mascota> mascota;
        mascota = mascotaRepository.findById(id);
        if(mascota.isPresent()){
            mascotaRepository.delete(mascota.get());
        }
    }
    
}
