package com.example.VeterinariaProyectoBack.services;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @GetMapping("/buscar")
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Usuario findById(@PathVariable final Long id) {
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = usuarioRepository.findAll();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario() == id) {
                usuario = usuarios.get(i);
                return usuarios.get(i);
            }

        }
        return usuario;
    }

    @GetMapping("/buscar/mascotas/{id}")
    public List<Mascota> getMascotasUsersById(@PathVariable final Long id) {
        List<Mascota> mascotasUsuario = new ArrayList<Mascota>();;
        List<Mascota> mascotas = mascotaRepository.findAll();
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i).getUsuario().getIdUsuario() == id) {
                mascotasUsuario.add(mascotas.get(i));
            }
        }
        return mascotasUsuario;
    }

    @PostMapping("/guardar")
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        /**
         * List<Rol>roles = rolRepository.findAll();
         * for(int i = 0; i < roles.size();i++){
         * if(usuario.getRol().getIdRol()==roles.get(i).getIdRol()){
         * usuario.setRol(roles.get(i));
         * }
         * }
         */
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteUsuario(@PathVariable("id") int id) {
        Optional<Usuario> usuario;
        usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
        }
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        List<Usuario> usuarios = usuarioRepository.findByCorreoAndPassword(usuario.getCorreo(), usuario.getPassword());
        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        } else {
            return null;
        }
    }

}
