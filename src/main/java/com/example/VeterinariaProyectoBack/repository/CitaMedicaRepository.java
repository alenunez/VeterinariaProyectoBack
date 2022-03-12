package com.example.VeterinariaProyectoBack.repository;

import java.io.Serializable;

import com.example.VeterinariaProyectoBack.entity.CitaMedica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("citaMedicaRepository")
public interface CitaMedicaRepository extends JpaRepository<CitaMedica,Serializable> {
    
}
