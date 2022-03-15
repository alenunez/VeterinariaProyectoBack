package com.example.VeterinariaProyectoBack.services;

import java.util.List;
import java.util.Optional;

import com.example.VeterinariaProyectoBack.entity.CitaMedica;
import com.example.VeterinariaProyectoBack.entity.Mascota;
import com.example.VeterinariaProyectoBack.entity.Usuario;
import com.example.VeterinariaProyectoBack.repository.CitaMedicaRepository;
import com.example.VeterinariaProyectoBack.repository.MascotaRepository;
import com.example.VeterinariaProyectoBack.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PutMapping;

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

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    public CitaMedica actualizar(CitaMedica citaMedica) {
        return citaMedicaRepository.save(citaMedica);
    }
    @PutMapping("/actualizar")
    public void actualizarMascota(@RequestBody CitaMedica citaMedica){
                actualizar(citaMedica);
    }


    @GetMapping("/buscar")
    public List<CitaMedica> getAllCitaMedica(){
        return citaMedicaRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public CitaMedica findById(@PathVariable final Long id){
        CitaMedica cita = new CitaMedica();
        List<CitaMedica> citas = citaMedicaRepository.findAll();
        for(int i = 0; i < citas.size();i++){
            if(citas.get(i).getIdCita()==id){
                return citas.get(i);
            }
        }
        return cita;
    }

    @PostMapping("/guardar/{idUsuario}/{idMascota}")
    public CitaMedica saveCita(@RequestBody CitaMedica cita,@PathVariable("idUsuario") int idUsuario,@PathVariable("idMascota") int idMascota){
        List<Usuario>usuarios = usuarioRepository.findAll();
        Usuario usuario = new Usuario();
        for(int i = 0 ; i <usuarios.size();i++){
            if(usuarios.get(i).getIdUsuario()==idUsuario){
                usuario = usuarios.get(i);
            }
        }
        List<Mascota> mascotas = mascotaRepository.findAll();
        Mascota mascota = new Mascota();
        for(int i = 0 ; i <mascotas.size();i++){
            if(mascotas.get(i).getIdMascota()==idMascota){
                mascota = mascotas.get(i);
            }
        }
        cita.setUsuario(usuario);
        cita.setMascota(mascota);

        return citaMedicaRepository.save(cita);
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
