package com.example.recursos.service;

import com.example.recursos.model.Recurso;
import com.example.recursos.repository.RecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    private final RecursoRepository repository;

    public RecursoService(RecursoRepository repository){
        this.repository = repository;
    }

    public List<Recurso> listar(){
        return repository.findAll();
    }

    public List<Recurso> listarDisponibles(){
        return repository.findByDisponibleTrue();
    }

    public List<Recurso> listarPorEquipos(String equipo){
        return repository.findByEquipo(equipo);
    }

    public Recurso guardar(Recurso recurso){
        return repository.save(recurso);
    }

    public Optional<Recurso> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Optional<Recurso> asignar(Long id, Long proyectoId){
        return repository.findById(id).map(recurso -> {
            recurso.setProyectoAsignadoId(proyectoId);
            recurso.setDisponible(false);
            return repository.save(recurso);
        });
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }
}