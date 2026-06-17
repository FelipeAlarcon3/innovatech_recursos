package com.example.recursos.repository;

import com.example.recursos.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecursoRepository extends JpaRepository<Recurso, String> {
    List<Recurso> findByDisponibleTrue();
    List<Recurso> findByEquipo(String equipo);
}
