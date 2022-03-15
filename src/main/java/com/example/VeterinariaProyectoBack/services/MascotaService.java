package com.example.VeterinariaProyectoBack.services;

import java.util.List;
import java.util.Optional;

import com.example.VeterinariaProyectoBack.entity.Mascota;
import com.example.VeterinariaProyectoBack.entity.Usuario;
import com.example.VeterinariaProyectoBack.repository.MascotaRepository;
import com.example.VeterinariaProyectoBack.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascota")
@CrossOrigin
public class MascotaService {

    
    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Mascota actualizar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }
    @PutMapping("/actualizar")
    public void actualizarMascota(@RequestBody Mascota mascota ){
                actualizar(mascota);
    }

    @GetMapping("/buscar")
    public List<Mascota> getAllMascota(){
        return mascotaRepository.findAll();
    }
    @GetMapping("/buscar/{id}")
    public Mascota findById(@PathVariable final Long id){
        Mascota mascota = new Mascota();
        List<Mascota> mascotas = mascotaRepository.findAll();
        for(int i = 0; i < mascotas.size();i++){
            if(mascotas.get(i).getIdMascota()==id){
                return mascotas.get(i);
            }
 
        }
        return mascota;
    }


    @PostMapping("/guardar/{idUsuario}")
    public Mascota saveMascota(@RequestBody Mascota mascota,@PathVariable("idUsuario") int idUsuario){
        List<Usuario>usuarios = usuarioRepository.findAll();
        Usuario usuario = new Usuario();
        for(int i = 0 ; i <usuarios.size();i++){
            if(usuarios.get(i).getIdUsuario()==idUsuario){
                usuario = usuarios.get(i);
            }
        }
        mascota.setUsuario(usuario);

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
