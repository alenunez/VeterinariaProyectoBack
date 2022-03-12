package com.example.VeterinariaProyectoBack.services;

import java.util.List;
import java.util.Optional;

import com.example.VeterinariaProyectoBack.entity.CitaMedica;
import com.example.VeterinariaProyectoBack.repository.CitaMedicaRepository;

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
@RequestMapping("/citaMedica")
@CrossOrigin
public class CitaMedicaService {

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;

    @GetMapping("/buscar")
    public List<CitaMedica> getAllCitaMedica(){
        return citaMedicaRepository.findAll();
    }

    @PostMapping("/guardar")
    public CitaMedica saveCitaMedica(@RequestBody CitaMedica citaMedica){
        return citaMedicaRepository.save(citaMedica);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteCitaMedica(@PathVariable ("id") int id){
        Optional<CitaMedica> citaMedica;
        citaMedica = citaMedicaRepository.findById(id);
        if(citaMedica.isPresent()){
            citaMedicaRepository.delete(citaMedica.get());
        }
    }
    
}
