package com.example.recursos.controller;

import com.example.recursos.model.Recurso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.recursos.service.RecursoService;

import java.util.List;

@RestController
@RequestMapping("/api/recursos")
@CrossOrigin(origins = "*")
public class RecursoController {
    private final RecursoService service;

    public RecursoController(RecursoService service) {
        this.service = service;
    }
    @GetMapping
    public List<Recurso> listar() {
        return service.listar();
    }

    @GetMapping("/disponibles")
    public List<Recurso> disponibles() {
        return service.listarDisponibles();
    }

    @GetMapping("/equipo/{nombre}")
    public List<Recurso> porEquipo(@PathVariable String nombre) {
        return service.listarPorEquipos(nombre);
    }

    @PostMapping
    public Recurso crear(@RequestBody Recurso recurso) {
        return service.guardar(recurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> actualizar(@PathVariable Long id, @RequestBody Recurso recurso) {
        recurso.setId(id);
        return ResponseEntity.ok(service.guardar(recurso));
    }

    @PutMapping("/{id}/asignar/{proyectoId}")
    public ResponseEntity<Recurso> asignar(@PathVariable String id, @PathVariable Long proyectoId) {
        return service.asignar(id, proyectoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}