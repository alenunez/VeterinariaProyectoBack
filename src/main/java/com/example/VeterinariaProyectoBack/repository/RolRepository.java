package com.example.VeterinariaProyectoBack.repository;

import java.io.Serializable;

import com.example.VeterinariaProyectoBack.entity.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rolRepository")
public interface RolRepository extends JpaRepository<Rol,Serializable> {
    
}
