package com.example.VeterinariaProyectoBack.repository;

import java.io.Serializable;

import com.example.VeterinariaProyectoBack.entity.Mascota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mascotaRepository")
public interface MascotaRepository extends JpaRepository<Mascota,Serializable>  {
    
}
